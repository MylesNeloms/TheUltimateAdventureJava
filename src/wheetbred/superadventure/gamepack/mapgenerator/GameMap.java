package wheetbred.superadventure.gamepack.mapgenerator;

import java.lang.reflect.Array;

import wheetbred.superadventure.gamepack.entities.Player;

/* 

The map will be an array of characters, intended to be organized by a grid. Map will be generated to hold 

*/ 

public class GameMap {
    // Create generator for Constructor to create game map
    private final static Generator mapGen = new Generator();
    // visible map is populated with the subset of the gameMap surrounding player
    public String[][] visibleMap = new String[12][25];
    public String[][] gameMap;
    private int mapDimensionX, mapDimensionY;
    private Player playerRef;
    private int[] initLocation = new int[2];


    public GameMap(Player player) {
        // Generate Game map on creation
        this.gameMap = mapGen.generateBaseMap();
        // Set map dimensions
        mapDimensionX = this.gameMap.length - 1;
        mapDimensionY = this.gameMap[0].length - 1;

        // add player's character to map
        setPlayerInit(player);
        playerRef = player;
        // use player location to set visible map
        this.visibleMap = getVisibleMap(player.getX(),player.getY(), 
            player.getplayerDirection("NOS"),player.getplayerDirection("EOW"));
    }

    // Set player takes in the player and its old position
    // Updates the map then visible map based on the new player position
    public void setPlayer(Player player, int X, int Y) {
        // Reset old tile
        this.gameMap[Y][X] = player.getPreviousTile();

        // Before moving player, save the tile that will be replaced. After moving player move visible map
        player.setPreviousTile(this.gameMap[player.getY()][player.getX()]);
        this.gameMap[player.getY()][player.getX()] = player.getPlayerTile(); 
        System.out.println(player.getplayerDirection("NOS"));
        this.visibleMap = getVisibleMap(X, Y, 
            player.getplayerDirection("NOS"),player.getplayerDirection("EOW"));
    }

    // Used initially when player is in init location save init location, may use later in game
    private void setPlayerInit(Player player) {
        int Y = player.getY();
        int X = player.getX();
        Array.setInt(initLocation, 0, X);
        Array.setInt(initLocation,1, Y);

        this.gameMap[Y][X] = player.getPlayerTile();
        this.visibleMap = getVisibleMap(X, Y, 
            player.getplayerDirection("NOS"),player.getplayerDirection("EOW") );
    }

    // Getter for player object
    public static Player getPlayer(GameMap gameMap) {
        return gameMap.playerRef;
    }


// Full game map is larger than visible map. While all object exist in the game map
// Visible map is 25x12 while game map si 150x101. 
// The visible map always has player @index 6,3 (lower middle of screen),
// as they move, map moves instead of player and loops on edges
    public String[][] getVisibleMap(int X, int Y, String nOS, String eOW) {
        // Visible map indexes
        int firstIndex = 0;
        int secondIndex = 0;
        String topLeftEOW, topRightEOW, bottomLeftEOW, bottomRightEOW;
        String topLeftNOS, topRightNOS, bottomLeftNOS, bottomRightNOS;
        
        String trueNorth = nOS;
        String north = new String("NORTH");
        boolean nOSBool = trueNorth.equals(north);
        String east = new String("EAST");
        String trueEast = new String(eOW);
        boolean eOWBool = trueEast.equals(east);


        // Setting Compass Will likely remove and add this functionality to an item
        if (nOSBool) {
            System.out.println("TrueNorth");
            topLeftNOS = "N";
            topRightNOS = "N";
            bottomLeftNOS = "S";
            bottomRightNOS = "S";
        } else {
            System.out.println("TrueSOUTH" + nOSBool + "  " + nOS + "  " + eOW);
            topLeftNOS = "S";
            topRightNOS = "S";
            bottomLeftNOS = "N";
            bottomRightNOS = "N";
        }

        if (eOWBool) {
            topLeftEOW = "W";
            topRightEOW = "E";
            bottomLeftEOW = "W";
            bottomRightEOW = "E";
        } else {
            topLeftEOW = "E";
            topRightEOW = "W";
            bottomLeftEOW = "E";
            bottomRightEOW = "W";
        }

    // loading visible map array from top to bottom and left to right.
    for (int j =(Y + 21); j > (Y - 4); j--) {
        for (int i = (X-6); i < (X + 6); i++) {
                int gameMapXIndex;
                int gameMapYIndex;
                if (i < 0) {
                    gameMapXIndex = mapDimensionX + i;
                } else if (i > mapDimensionX - 1) {
                    gameMapXIndex = i - mapDimensionX;
                } else {
                    gameMapXIndex = i;
                }
                if (j < 0) {
                    gameMapYIndex = mapDimensionY + j;
                } else if (j > mapDimensionY - 1) {
                    gameMapYIndex = j - mapDimensionY;
                } else {
                    gameMapYIndex = j;
                }

                // set compass and logging for vismap debugging
                if (secondIndex == 0 && firstIndex == 0) {
                    //  System.out.println("top Left");
                    //  System.out.println("X: " + topLeftNOS );
                    //  System.out.println("Y: " + topLeftEOW);
                    visibleMap[secondIndex][firstIndex] = topLeftNOS + topLeftEOW;

                     System.out.println("TopLeft :"+visibleMap[secondIndex][firstIndex]);
                } else if (secondIndex == 0 && firstIndex == 24) {
                    //  System.out.println("bottom Left");
                    //  System.out.println("X: " + gameMapXIndex);
                    //  System.out.println("Y: " + gameMapYIndex);
                    visibleMap[secondIndex][firstIndex]  = bottomLeftNOS + bottomLeftEOW;;
                    //  System.out.println("------------");
                } else if (secondIndex == 11 && firstIndex == 0) {
                    //  System.out.println("top Right");
                    //  System.out.println("X: " + gameMapXIndex);
                    //  System.out.println("Y: " + gameMapYIndex);
                    visibleMap[secondIndex][firstIndex] = topRightNOS + topRightEOW;
                    //  System.out.println("------------");
                } else if (secondIndex == 11 && firstIndex == 24) {
                    //  System.out.println("bottom Right");
                    //  System.out.println("X: " + gameMapXIndex);
                    //  System.out.println("Y: " + gameMapYIndex);
                    visibleMap[secondIndex][firstIndex] = bottomRightNOS + bottomRightEOW;
                    //  System.out.println("------------");
                } else {
                    // Add visible subset to visible map
                visibleMap[secondIndex][firstIndex] = this.gameMap[gameMapYIndex][gameMapXIndex];
                }
                secondIndex++;
            }
            secondIndex = 0;
            firstIndex++;
        }
        return visibleMap;
    }

}