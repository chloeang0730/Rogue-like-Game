package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;

/**
 * A class representing wall object which cannot be entered by any actor
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by:
 * @author Chloe Ang
 */
public class Wall extends Ground {
    /**
     * Construct a Dirt object with specific display character.
     */
    public Wall() {
        super('#');
    }

    /**
     * A method to check whether the actor is permitted to enter the location or not.
     * None of the actor is allowed to step onto this ground type.
     * @param actor the Actor to check
     * @return False if any actor try to enter
     */
    @Override
    public boolean canActorEnter(Actor actor) {
        return false;
    }
}
