package wheetbred.superadventure.gamepack.mapgenerator;

/* 

The map will be an array of characters, intended to be organized by a grid. Map will be generated to hold 

*/ 

public class GameMap {

    // Map for game
    final static int MAP_HEIGHT = 30;
    final static int MAP_WIDTH = 25;
    final String grid[][] = new String[MAP_WIDTH][MAP_HEIGHT];

    public String[][] generateBaseMap() {
        String newGrid[][] = new String[MAP_WIDTH][MAP_HEIGHT];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                newGrid[i][j] = "  .  ";
            }
        }
        return newGrid;
    }
    
}
