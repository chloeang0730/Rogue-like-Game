package game.actions;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;

/**
 * An action class that manages the consume action. Once the item is consumed by an actor, a specific number of health point will
 * be added to the actor to restore health and the item will be removed from the actor's inventory.
 *
 * @author Chloe Ang
 * @since 02-04-2024
 * @version 1.0
 */
public class ConsumeAction extends Action {

    private Item item;
    private int healPoint;

    /**
     * Constructs a ConsumeAction with a specified item and healpoints.
     *
     * @param item Item to be consumed
     * @param healPoint The healpoint of the food provided for the actor after it is consumed
     */
    public ConsumeAction(Item item, int healPoint) {
        this.item = item;
        this.healPoint = healPoint;
    }

    /**
     * Executes the action of consuming the item by the specified actor within a given game map.
     * The item is removed from the actor's inventory and the actor's health is increased/decreased by the heal points of the item.
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return A string describing effects after consuming an item on the actor, specifically noting the increase in health points
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        actor.removeItemFromInventory(item);
        actor.heal(healPoint);
        return actor + " consumed " + item + " and " + item +" heals " + actor + " by " + healPoint +" point(s).";
    }

    /**
     * Provides a menu description for the player to choose to perform a consume action for an item
     *
     * @param actor The actor performing the action.
     * @return A string describing the actor consuming the item.
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " eats " + item;


    }
}
