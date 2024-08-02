package game.grounds;

import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.items.Fruit;

import java.util.List;
import java.util.Random;

/**
 *
 * An abstract base class for different types of trees in the game environment. This class provides a blueprint for tree behaviors,
 * including periodic growth and fruit production based on specific game ticks. Each type of tree can have different characteristics
 * in terms of growth and fruit production chance which are defined by extending this base class.
 * @author Chloe Ang
 * @since 02-04-2024
 * @version 1.0
 */

public abstract class Tree extends Ground {

    private Random rand = new Random();
    private int counter;
    private double chance;
    private int period;
    private String name;

    /**
     * Constructs a Tree with specified display character, growth period, and fruiting chance.
     * @param name name of tree
     * @param displayChar character to display for this type of terrain
     * @param chance chance probability that the tree will produce a fruit each tick
     * @param period period interval in ticks between each growth event of the tree
     */
    public Tree(String name, char displayChar,double chance, int period) {
        super(displayChar);
        this.name = name;
        this.chance = chance;
        this.period = period;
        this.counter = 0;
    }

    /**
     * Abstract method to define tree growth behavior.This method should be implemented to specify
     * how the tree changes state as it grows.
     * @param location The location of the tree
     */
    public abstract void grow(Location location);

    /**
     * Abstract method to define how the tree produces fruit. This method must be implemented to specify
     * the type of fruit produced by the tree.
     * @return A fruit object representing the fruit produced by the tree
     */
    public abstract Fruit produce();

    /**
     * Handles the periodic actions of the tree, such as growth and fruit production.
     * This method is called every tick and manages the tree's internal counter to determine when it should grow.
     * It also randomly decides based on the specified chance whether to produce fruit, and if so, places the fruit
     * at a random exit from the tree's location.
     * @param location The location of the tree
     */
    @Override
    public void tick(Location location){
        counter++;
        if (counter == period){
            this.grow(location);
        }
        List<Exit> exits = location.getExits();
        Exit nextExit = exits.get(rand.nextInt(exits.size()));
        if(Math.random() <= chance){
            nextExit.getDestination().addItem(this.produce());
        }
    }
}
