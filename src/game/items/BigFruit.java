package game.items;


/**
 * A concrete class that represents big fruit.
 * @author Chloe Ang
 * @since 02-04-2024
 * @version 1.0
 */
public class BigFruit extends Fruit {

    private final static int HEALPOINT = 2;

    /**
     * Constructs a big fruit with specified name, character, portability and heal points.
     */
    public BigFruit(){
        super("Big Fruit",'O',true,HEALPOINT);
    }



}
