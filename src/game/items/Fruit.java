package game.items;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.*;
import game.actions.ConsumeAction;

/**
 * An abstract class that act as a base class for fruit item which has name, character, portability and heal points.
 * @author Chloe Ang
 * @since 02-04-2024
 * @version 1.0
 */
public abstract class Fruit extends Item {

    private int healPoint;

    /***
     * Constructs a new fruits with name, characteristic, portability, heal point.
     * @param name the name of this Item
     * @param displayChar the character to use to represent this item if it is on the ground
     * @param portable true if and only if the Item can be picked up
     * @param healPoint the healpoints provided by the fruit
     */
    public Fruit(String name, char displayChar, boolean portable,int healPoint) {
        super(name, displayChar, portable);
        this.healPoint = healPoint;
    }

    /**
     * Provides the list of actions that other actors can perform on this fruit, primarily to consume it.
     * @param owner the actor that owns the item
     * @return A list of actions that can be performed on this fruit, specifically consumption.
     */
    @Override
    public ActionList allowableActions(Actor owner){
        ActionList actions = new ActionList();
        actions.add(new ConsumeAction(this,healPoint));
        return actions;
    }
}
