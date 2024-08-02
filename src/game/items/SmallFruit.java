package game.items;

/**
 * A concrete class that represents small fruit.
 * @author Chloe Ang
 * @since 02-04-2024
 * @version 1.0
 */
public class SmallFruit extends Fruit {

    private final static int HEALPOINT = 1;

    /**
     * Constructs a small fruit with specified name, character, portability and heal points.
     */
    public SmallFruit(){
        super("Small Fruit", 'o',true,HEALPOINT);
    }

}
