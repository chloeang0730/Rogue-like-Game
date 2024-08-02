package game.npc;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.actions.AttackAction;
import game.enums.Status;

import java.util.ArrayList;
import java.util.Random;

/**
 * Provides an attack behaviour for an actor, enabling them to attack other actors deemed hostile.
 * This behaviour scans the immediate exits from the actor's current location on the map, identifying any actor present
 * at those locations. If an actor with a hostile status is found, an attack action will be performed against them.
 * @author Chloe Ang
 * @since 02-04-2024
 * @version 1.0
 */
public class AttackBehaviour implements Behaviour {

    private final Random random = new Random();

    /**
     * Returns an attack action on the other actors
     * If no movement is possible, returns null.
     *
     * @param actor the Actor enacting the behaviour
     * @param map the map that actor is currently on
     * @return an Action, or null if no MoveAction is possible
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        ArrayList<Action> actions = new ArrayList<>();
        Weapon weapon = new IntrinsicWeapon(1,"punches",25);
        for (Exit exit : map.locationOf(actor).getExits()) {
            Location destination = exit.getDestination();
            Actor target = destination.getActor();
            if (target != null && target.hasCapability(Status.HOSTILE_TO_ENEMY)) {
                actions.add(new AttackAction(target, exit.getName(),weapon));
            }
        }
        if (!actions.isEmpty()) {
            return actions.get(random.nextInt(actions.size()));
        }
        else {
            return null;
        }

    }
}
