package game.grounds;

import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.npc.SpawnCreature;

import java.util.List;
import java.util.Random;

/**
 * Represents a crater on the game map which can spawn a type of creature. Each crater has the ability to spawn
 * one type of predefined creature.
 * @author Chloe Ang
 * @since 02-04-2024
 * @version 1.0
 */
public class Crater extends Ground {

    private Random rand = new Random();
    private SpawnCreature creature ;
    private static final double CHANCE = 0.05;
    /**
     * Constructs a Crater with a list of creatures that it can spawn.
     * @param creature A list of creatures that this Crater can spawn
     */
    public Crater(SpawnCreature creature){
        super('u');
        this.creature = creature;
    }

    /**
     * Handles the periodic actions of the crater,if the random exit is not occupied,
     * there is a 5% chance to spawn a random creature at a random nearby exit.
     * @param location The location of the Ground
     */
    public void tick(Location location){
        List<Exit> exits = location.getExits();
        // Randomly select an exit
        Exit nextExit = exits.get(rand.nextInt(exits.size()));
        // Spawn the selected creature at selected exit with 5% chance
        if (!nextExit.getDestination().containsAnActor() && Math.random() <= CHANCE) {
            nextExit.getDestination().addActor(creature.spawn());
        }
    }





}
