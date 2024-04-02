package wheetbred.superadventure.gamepack.gameboard;

import wheetbred.superadventure.gamepack.mapgenerator.GameMap;

public class AdventureGame {
    public static void main(String[] args) throws Exception {
        /// generate game map on start. TODO: Add functionality for continuing from savepoint with "fromExistingMap() method"
        GameMap gameMap = new GameMap();
        new GameFrame(gameMap);
    }
}
