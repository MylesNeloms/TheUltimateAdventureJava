package wheetbred.superadventure.gamepack.mapgenerator;

import java.util.Random;

import wheetbred.superadventure.gamepack.entities.Player;

/* 

The map will be an array of characters, intended to be organized by a grid. Map will be generated to hold 

*/ 

public class GameMap {
    private final static Generator mapGen = new Generator();
    public String[][] visibleMap = new String[12][25];;
    public String[][] gameMap;
    private int mapDimensionX, mapDimensionY;
    public GameMap(Player player) {
        this.gameMap = mapGen.generateBaseMap();
        mapDimensionX = this.gameMap.length - 1;
        mapDimensionY = this.gameMap[0].length - 1;
        setPlayerInit(player);
        this.visibleMap = getVisibleMap(player.getX(),player.getY(), player.getplayerDirection("NOS"),player.getplayerDirection("EOW"));
        // System.out.println(visibleMap[7][22]);
    }

    public void setPlayer(Player player, int X, int Y) {
        // int Y = player.getY();
        // int X = player.getX();
        this.gameMap[Y][X] = player.getPreviousTile();
        player.setPreviousTile(this.gameMap[player.getY()][player.getX()]);
        this.gameMap[player.getY()][player.getX()] = player.getPlayerTile(); 
        System.out.println(player.getplayerDirection("NOS"));
        this.visibleMap = getVisibleMap(X, Y, player.getplayerDirection("NOS"),player.getplayerDirection("EOW"));
    }
    private void setPlayerInit(Player player) {
        int Y = player.getY();
        int X = player.getX();
        
        this.gameMap[Y][X] = player.getPlayerTile();
        this.visibleMap = getVisibleMap(X, Y, player.getplayerDirection("NOS"),player.getplayerDirection("EOW") );
    }
// Full game map is larger than visible map. While all object exist in the game map
// Visible map is 25x12 while game map si 150x101. 
// The visible map always has player @index 6,3 (lower middle of screen),
// as they move, map moves instead of player and loops on edges
    public String[][] getVisibleMap(int X, int Y, String nOS, String eOW) {
        int firstIndex = 0;
        int secondIndex = 0;
        // String topLeftEOW, topRightEOW, bottomLeftEOW, bottomRightEOW;
        // String topLeftNOS, topRightNOS, bottomLeftNOS, bottomRightNOS;
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
                // switch (nOS) {
                //     default:
                //     case("NORTH"):
                //         topLeftNOS = "N";
                //         topRightNOS = "N";
                //         bottomLeftNOS = "S";
                //         bottomRightNOS = "S";
                //         break;
                //     case("SOUTH"):
                //         topLeftNOS = "S";
                //         topRightNOS = "S";
                //         bottomLeftNOS = "N";
                //         bottomRightNOS = "N";
                //         break;
                // }
                // switch (eOW) {
                //     default: 
                //     case("EAST"):
                //         topLeftEOW = "W";
                //         topRightEOW = "E";
                //         bottomLeftEOW = "W";
                //         bottomRightEOW = "E";
                //         break;
                //     case("WEST"):
                //         topLeftEOW = "E";
                //         topRightEOW = "W";
                //         bottomLeftEOW = "E";
                //         bottomRightEOW = "W";
                //         break;
                //     }

                // // logging to understand where this visible map is located
                // if (secondIndex == 0 && firstIndex == 0) {
                //     //  System.out.println("top Left");
                //     //  System.out.println("X: " + gameMapXIndex);
                //     //  System.out.println("Y: " + gameMapYIndex);
                //     visibleMap[secondIndex][firstIndex] = topLeftNOS + topLeftEOW;
                //     //  System.out.println("------------");
                // } else if (secondIndex == 0 && firstIndex == 24) {
                //     //  System.out.println("bottom Left");
                //     //  System.out.println("X: " + gameMapXIndex);
                //     //  System.out.println("Y: " + gameMapYIndex);
                //     visibleMap[secondIndex][firstIndex]  = bottomLeftNOS + bottomLeftEOW;;
                //     //  System.out.println("------------");
                // } else if (secondIndex == 11 && firstIndex == 0) {
                //     //  System.out.println("top Right");
                //     //  System.out.println("X: " + gameMapXIndex);
                //     //  System.out.println("Y: " + gameMapYIndex);
                //     visibleMap[secondIndex][firstIndex] = topRightNOS + topRightEOW;
                //     //  System.out.println("------------");
                // } else if (secondIndex == 11 && firstIndex == 24) {
                //     //  System.out.println("bottom Right");
                //     //  System.out.println("X: " + gameMapXIndex);
                //     //  System.out.println("Y: " + gameMapYIndex);
                //     visibleMap[secondIndex][firstIndex] = bottomRightNOS + bottomLeftEOW;
                //     //  System.out.println("------------");
                // } else {
                visibleMap[secondIndex][firstIndex] = this.gameMap[gameMapYIndex][gameMapXIndex];
                // }
                secondIndex++;

            }
            secondIndex = 0;
            firstIndex++;
        }
        return visibleMap;
    }

    public void setameMap(Player player) {
}
}