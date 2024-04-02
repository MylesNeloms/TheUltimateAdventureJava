package wheetbred.superadventure.gamepack.mapgenerator;

/*
 * This Class will implement the methods for map generation which will create important landmarks in random locations.
 */
public class Generator {
        // Map for game
        final static int MAP_HEIGHT = 25;
        final static int MAP_WIDTH = 15;
        final String grid[][] = new String[MAP_WIDTH][MAP_HEIGHT];
    
    // Basic methods for maps to testing Jframe refresh
        public String[][] generateBaseMap() {
            String newGrid[][] = new String[MAP_WIDTH][MAP_HEIGHT];
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    newGrid[i][j] = "  .  ";
                }
            }
            return newGrid;
        }
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
