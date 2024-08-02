package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import game.enums.Status;

/**
 * A class that represents the floor inside a building.
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by:
 * @author Chloe Ang
 */
public class Floor extends Ground {
    /**
     * Construct a Dirt object with specific display character.
     */
    public Floor() {
        super('_');
    }

    /**
     * A method to check whether the actor is permitted to enter the location or not. Only actor who has
     * the status of hostile to enemy is allowed to step onto this ground type
     * @param actor the Actor to check
     * @return True if the actor has capability of hostile to enemy, false otherwise
     */
    @Override
    public boolean canActorEnter(Actor actor) {
        if (!actor.hasCapability(Status.HOSTILE_TO_ENEMY)){
            return false;
        }
        return true;
    }
}
