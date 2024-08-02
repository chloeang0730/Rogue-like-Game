package game.npc;

import edu.monash.fit2099.engine.actors.Actor;

/**
 * A class responsible for handling the creation of actors, the actors who can be spawned are intended to implement this interface.
 * The actor class that implements this interface will have particular method for the production and initialisation of new actor,
 * it also allows customising the spawning process to fit the particulars of the creature it represents.
 */
public interface SpawnCreature {
    /**
     * Spawns a new actor into the game environment.
     *
     * @return A new actor object
     */
    public Actor spawn();

}
