package game.core;

import java.util.Arrays;
import java.util.List;


import edu.monash.fit2099.engine.displays.Display;

import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;
import game.grounds.*;
import game.items.Bolt;
import game.items.MetalPipe;
import game.items.MetalSheet;
import game.grounds.Crater;
import game.npc.HuntsmanSpider;
import game.npc.SpawnCreature;

/**
 * The main class to start the game.
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 * @author Chloe
 * @since 02-04-2023
 * @version :2.0
 */
public class Application {
    /**
     * The entry point of the application
     * @param args Command-line arguments passed to the application.
     */
    public static void main(String[] args) {

        World world = new World(new Display());

        FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(),
                new Wall(), new Floor(), new Puddle(), new Inheritree(), new BigInheritree());

        List<String> map = Arrays.asList(
                        "...~~~~.........~~~...........",
                        "...~~~~.......................",
                        "...~~~........................",
                        "..............................",
                        ".............#####............",
                        ".............#___#...........~",
                        ".............#___#..........~~",
                        ".............##_##.........~~~",
                        "...........T....~~..t......~~~",
                        "................~~~~.......~~~",
                        ".............~~~~~~~........~~",
                        "......~.....~~~~~~~~.........~",
                        ".....~~~...~~~~~~~~~..........",
                        ".....~~~~~~~~~~~~~~~~........~",
                        ".....~~~~~~~~~~~~~~~~~~~....~~");

        GameMap gameMap = new GameMap(groundFactory, map);


        world.addGameMap(gameMap);

        for (String line : FancyMessage.TITLE.split("\n")) {
            new Display().println(line);
            try {
                Thread.sleep(200);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }

        // MetalSheet and Bolt
        gameMap.at(3,4).addItem(new MetalSheet());
        gameMap.at(10,7).addItem(new Bolt());

        // Crater
        SpawnCreature creature = new HuntsmanSpider();
        gameMap.at(7, 7).setGround(new Crater(creature));

        // Metal Pipe
        gameMap.at(3,8).addItem(new MetalPipe());

        // Player
        Player player = new Player("Intern", '@', 4);
        world.addPlayer(player, gameMap.at(15, 6));

        world.run();

        // Game Over Fancy Message
        if(!player.isConscious()){
            for (String line : FancyMessage.YOU_ARE_FIRED.split("\n")) {
                new Display().println(line);
                try {
                    Thread.sleep(200);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }

        }
        gameMap.tick();

    }
}
