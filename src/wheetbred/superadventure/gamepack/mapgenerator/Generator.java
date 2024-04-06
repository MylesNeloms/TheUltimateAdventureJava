package wheetbred.superadventure.gamepack.mapgenerator;

import java.util.Arrays;

import wheetbred.superadventure.gamepack.entities.Player;

/*
 * This Class will implement the methods for map generation which will create important landmarks in random locations.
 */
public class Generator {
        // Map for game
        final static int MAP_HEIGHT = 50;
        final static int MAP_WIDTH = 50;
        String[][] grid = new String[MAP_HEIGHT][MAP_WIDTH];
    
    // Basic methods for maps to testing Jframe refresh
        public String[][] generateBaseMap() {
            for (int i = 0; i < grid.length; i++) {
                if ((i%2) == 0) {
                for (int j = 0; j < grid[i].length; j++) {
                    if ((j%2) == 0) {
                        grid[i][j] = "  -  ";
                    } else {
                        grid[i][j] = "  #  ";
                    }
                }
            } else {
                for (int j = 0; j < grid[i].length; j++) {
                    if ((j%2) == 0) {
                        grid[i][j] = "  +  ";
                    } else {
                        grid[i][j] = "  |  ";
                    }
                }
            }
            }

            // return generated map
            System.out.println(Arrays.deepToString(grid));
            return grid;
        }

        // test func for early map creation.... removing soon
        public String[][] generateAlternateMap(String x) {
            String newGrid[][] = new String[MAP_WIDTH][MAP_HEIGHT];
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    newGrid[i][j] = "  "+x+"  ";
                }
            }
            return newGrid;
        }
    
    
        
}
