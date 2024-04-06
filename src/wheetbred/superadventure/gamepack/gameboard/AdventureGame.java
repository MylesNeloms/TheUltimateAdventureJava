package wheetbred.superadventure.gamepack.gameboard;

import wheetbred.superadventure.gamepack.entities.Player;
import wheetbred.superadventure.gamepack.gameboard.Gamestate.State;
import wheetbred.superadventure.gamepack.mapgenerator.GameMap;

public class AdventureGame {
    // may be necessary later when implementing a starting screen
    public State state = State.INIT;
    public static void main(String[] args) throws Exception {
        /// generate game map on start. TODO: Add functionality for continuing from savepoint with "fromExistingMap() method"
        Player player = new Player();
        GameMap gameMap = new GameMap(player);
        // System.out.println(gameMap.visibleMap[7][22]);
        new GameFrame(gameMap);
    }
}
