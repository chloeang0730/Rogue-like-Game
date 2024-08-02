package game.items;

import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.enums.Ability;

/**
 * A class that represents a metal pipe object as a weapon item.
 * @author Chloe Ang
 * @since 02-04-2024
 * @version 1.0
 */
public class MetalPipe extends WeaponItem {

    /**
     * Construct a metal pipe object with specific name, characteristic, portability.
     * The Metal Pipe is set up with a specific damage rating and attack verb "punch", which describes the action performed
     * when using this weapon. It also adds a specific capability to this weapon, allowing actor who holding it to attack others with it.
     */
    public MetalPipe() {
        super("Metal Pipe",'!', 1, "punch",20);
        this.addCapability(Ability.ATTACK_WITH_METAL_PIPE);
    }

}
