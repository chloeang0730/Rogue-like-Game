package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.Weapon;

import java.util.Random;

/**
 * An action class that manages the attack action. This action allows an actor to attempt to hit another actor using
 * either an intrinsic weapon or a specified weapon. The success of the attack is determined based on the weapon's chance to hit,
 * and damage is inflicted accordingly. If the target actor is hit and the damage is sufficient to drop the
 * target's hit points to zero , such as the target will lose its life.
 *
 * @author Chloe Ang
 * @since 02-04-2024
 * @version 1.0
 */
public class AttackAction extends Action {

    /**
     * The Actor that is to be attacked
     */
    private Actor target;

    /**
     * The direction of incoming attack.
     */
    private String direction;

    /**
     * Random number generator
     */
    private Random rand = new Random();

    /**
     * Weapon used for the attack
     */
    private Weapon weapon;

    /**
     * Constructs a AttackAction with a target and direction.
     *
     * @param target    the Actor to attack
     * @param direction the direction where the attack should be performed (only used for display purposes)
     * @param weapon the weapon used by actor to attack
     */
    public AttackAction(Actor target, String direction, Weapon weapon) {
        this.target = target;
        this.direction = direction;
        this.weapon = weapon;
    }

    /**
     * Constructor with intrinsic weapon as default
     *
     * @param target    the actor to attack
     * @param direction the direction where the attack should be performed (only used for display purposes)
     */
    public AttackAction(Actor target, String direction) {
        this.target = target;
        this.direction = direction;
    }

    /**
     * Execute the attack action performed by the actor on a specific map using Instrinsic Weapon or any specific weapon.
     * If the attack misses, a miss message is returned. If the attack hits, it calculates the damage, applies it to the target,
     * and constructs a result string that describes the action outcome.
     * If the damage inflicted causes the target to lose consciousness,then it will perform the unconscious method on the target.
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return  A string that shows the result of the attack action that has been performed, whether damage is inflicted or the
     * actor misses the target or the actor is dead.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        if (weapon == null) {
            weapon = actor.getIntrinsicWeapon();
        }

        if (!(rand.nextInt(100) <= weapon.chanceToHit())) {
            return actor + " misses " + target + ".";
        }

        int damage = weapon.damage();
        String result = actor + " " + weapon.verb() + " " + target + " for " + damage + " damage.";

        target.hurt(damage);
        if (!target.isConscious()) {
            result += "\n" + target.unconscious(actor, map);
        }

        return result;
    }

    /**
     * Provides a menu description for the player to choose whether to attack the target with a specific weapon or with no weapon.
     *
     * @param actor The actor performing the action.
     * @return A string showing the attack action performed by the actor with the chosen weapon.
     */
    @Override
    public String menuDescription(Actor actor) {
//        return actor + " attacks " + target + " at " + direction + " with " + (weapon != null ? weapon : "Intrinsic Weapon");
        if (weapon != actor.getIntrinsicWeapon()) {
            return actor + " attacks " + target + " at " + direction + " with " + weapon;
        }
        return actor + " attacks " + target + " at " + direction + " with bare hand";
    }
}
