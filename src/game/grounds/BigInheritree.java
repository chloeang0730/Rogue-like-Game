package game.grounds;

import edu.monash.fit2099.engine.positions.Location;
import game.items.BigFruit;
import game.items.Fruit;

/**
 * Represent a mature tree variant in the game, capable of producing large fruits.
 * This tree will not grow further, it remains the mature tree state.
 * @author Chloe Ang
 * @since 02-04-2024
 * @version 1.0
 */
public class BigInheritree extends Tree {

    private static final double CHANCE = 0.2;
    private static final int PERIOD = 0;

    /**
     * Construct a BigInheritree object with specific name,display character, chance of fruiting, growth period.
     */
    public BigInheritree() {
        super("Big Inheritree",'T',CHANCE,PERIOD);
    }

    /**
     * This method is overridden to simulate the mature state of the tree.
     * Since the BigInheritree is already at its final stage of growth, this method does not change
     * the state of the tree but ensures it remains a BigInheritree.
     * @param location The location of the tree
     */
    @Override
    public void grow(Location location) {
        location.setGround(new BigInheritree());
    }

    /**
     * This method would generate a production of a new Big Fruit which can be picked up and consumed by the actor.
     * @return A Big Fruit object
     */
    @Override
    public Fruit produce() {
        return new BigFruit();
    }

}
