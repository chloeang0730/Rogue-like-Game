package game.grounds;


import edu.monash.fit2099.engine.positions.Location;
import game.items.Fruit;
import game.items.SmallFruit;

/**
 * Represent a sapling, a younger version of tree in the game, capable of producing small fruits.
 * It will grow further into a BigInheritree
 * @author Chloe Ang
 * @since 02-04-2024
 * @version 1.0
 */
public class Inheritree extends Tree {

    private static final double CHANCE = 0.3;
    private static final int PERIOD = 5;

    /**
     * Construct an Inheritree object with specific name, display character, chance of fruiting, growth period.
     */
    public Inheritree() {
        super("Small Inheritree",'t', CHANCE,PERIOD);
    }

    /**
     * This method is overridden to simulate the mature state of the tree.
     * After a certain period of time, the Inheritree will grow into a BigInheritree.
     * @param location The current location of the tree
     */
    @Override
    public void grow(Location location) {
        location.setGround(new BigInheritree());
    }

    /**
     * This method would generate a production of a new Small Fruit which can be picked up and consumed by the actor.
     * @return A new Small Fruit object
     */
    @Override
    public Fruit produce() {
        return new SmallFruit();
    }


}

