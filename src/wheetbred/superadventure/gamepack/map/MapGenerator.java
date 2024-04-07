package wheetbred.superadventure.gamepack.map;

import java.util.Arrays;

import wheetbred.superadventure.gamepack.entities.Player;
import wheetbred.superadventure.gamepack.map.geography.*;

/*
 * This Class will implement the methods for map generation which will create important landmarks in random locations.
 */
public class MapGenerator {
        // Map for game
        final static int MAP_HEIGHT = 500;
        final static int MAP_WIDTH = 500;

        private static String[][] grid = new String[MAP_HEIGHT][MAP_WIDTH];
        final static Grass grass = new Grass();
        final static House house = new House();
        final static Rock rock = new Rock();
        final static Sand sand = new Sand();
        final static WaterBody water = new WaterBody();
        final static Teleporter teleporter = new Teleporter();
        WaterBody waterBody = new WaterBody();
        
    
    // Basic methods for maps to testing Jframe refresh
        public static String[][] generateBaseMap() {
            for (int i = 0; i < grid.length; i++) {
                if ((i%2) == 0) {
                for (int j = 0; j < grid[i].length; j++) {
                    if ((j%2) == 0) {
                        grid[i][j] = "  -  ";
                    } else {
                        grid[i][j] = "  .  ";
                    }
                }
            } else {
                for (int j = 0; j < grid[i].length; j++) {
                    if ((j%2) == 0) {
                        grid[i][j] = "  #  ";
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

        public static String[][] addLandMarks(GameMap gameMap) {
            String[][] ammendedMap = gameMap.gameMap;
            ammendedMap = grass.draw(0, ammendedMap, null);
            ammendedMap = sand.draw(0, ammendedMap, null);
            ammendedMap = rock.draw(0, ammendedMap, null);
            ammendedMap = water.draw(0, ammendedMap, null);

            return ammendedMap;
        }
        // test func for early map creation.... removing soon
        public String[][] generateAlternateMap(String x) {
            String newGrid[][] = new String[MAP_WIDTH][MAP_HEIGHT];
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    newGrid[i][j] = x;
                }
            }
            return newGrid;
        }
    
    
        
}
