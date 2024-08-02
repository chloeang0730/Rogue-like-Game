package game.npc;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.actions.AttackAction;
import game.enums.Ability;
import game.enums.Status;
import game.items.MetalPipe;

import java.util.TreeMap;


/**
 * Represents a Huntsman Spider, an actor within the game with distinct behaviors and the capability to spawn.
 * The Huntsman Spider is an NPC (Non-Player Character) with specific behaviors that define its interaction within the game environment.
 * It implements the SpawnCreature interface, indicating its ability to be spawned in the game world.
 * This class also configures the HuntsmanSpider with a set of behaviors prioritized by their importance.
 * @author Chloe Ang
 * @since 02-04-2024
 * @version 1.0
 */
public class HuntsmanSpider extends Actor implements SpawnCreature {

    private TreeMap<Integer, Behaviour> behaviours = new TreeMap<>();

    /**
     * Construct a HuntsmanSpider object with specific name, display character and hitpoints.
     */
    public HuntsmanSpider() {
        super("Huntsman Spider", '8', 1);
        this.behaviours.put(998, new AttackBehaviour());
        this.behaviours.put(999, new WanderBehaviour());
    }

    /**
     * At each turn, select a valid action to perform.
     *
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return the valid action that can be performed in that iteration or null if no valid action is found
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {

        for (Behaviour behaviour : behaviours.values()) {
            Action action = behaviour.getAction(this, map);
            if(action != null)
                return action;
        }
        return new DoNothingAction();
    }

    /**
     * The HuntsmanSpider can be attacked by any actor that has the HOSTILE_TO_ENEMY capability
     *
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return The list of actions allowed to be performed on HuntsmanSpider
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        // HuntsmanSpider can be attacked by other actor who is hostile to enemy
        if(otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)){
            actions.add(new AttackAction(this, direction, new IntrinsicWeapon(1, "punches",5)));
        }
        // HuntsmanSpider can be attacked by other actor with metal
        if(otherActor.hasCapability(Ability.ATTACK_WITH_METAL_PIPE)){
            actions.add(new AttackAction(this, direction, new MetalPipe()));
        }

        return actions;
    }
    /**
     * Spawns a new HuntsmanSpider into the game environment.
     *
     * @return A new HuntsmanSpider
     */
    @Override
    public Actor spawn(){
        return new HuntsmanSpider();
    }

}
