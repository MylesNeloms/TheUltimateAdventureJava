package wheetbred.superadventure.gamepack.entities;

import java.lang.reflect.Array;

import wheetbred.superadventure.gamepack.mapgenerator.GameMap;

/*
 * Base class to hold basic methods for moving and locating non player characters
 */
public class Player {
    // Vars for player position
    private static int X, Y;

    // Vars for setting player tile to appropriate character
    private static String previousTile;
    private static String playerTile;

    // Vars for compass calculations
    private static String northOrSouth;
    private static String eastOrWest;
    public Player() {
        // Initialize player position. May change to add some variance
        X = 25;
        Y = 25;

        // Default player tile facing north. Replace init tile with "." May use this later for story
        playerTile = "  ^  ";
        previousTile = "  .  ";

        // Compass initially pointing north. Will likely add this functionality to an item
        northOrSouth = "NORTH";
        eastOrWest = "EAST";
    }



    // Setters
    private void setX(int playerX) {
        X = playerX;
    }

    private void setY(int playerY) {
        Y = playerY;
    }

    public void setPlayerTile(String newTile) {
        playerTile = newTile;
    }

    public void setPreviousTile(String oldTile) {
        previousTile = oldTile;
     }

    public void setplayerDirection(int direction) {
        switch(direction) {
            case(1):
                northOrSouth = "SOUTH";
                break;
            case(2):
                northOrSouth = "NORTH";
                break;
            case(3):
                eastOrWest = "EAST";
                break;
            case(4):
                eastOrWest = "WEST";
                break;
            // default:
            //     northOrSouth = "NORTH";
            //     eastOrWest = "EAST";
        }
     }

    // Getters for static vars
    public int getX() {
        return X;
    }
    public int getY() {
        return Y;
    }

    public String getPlayerTile() {
       return playerTile;
    }

    public String getPreviousTile() {
        return previousTile;
     }

    

    public String getplayerDirection(String direction) {
        switch(direction) {
            case("NOS"):
                return northOrSouth;
            case("EOW"):
                return eastOrWest;
            default:
                return "N/a";
        }
     }
    
    // Change player position and direction
    public int[] move(int newX, int newY, int cross, String tile) {
        // Get Old position to reset old map tile
        int[] oldPosition = new int[2];
        Array.setInt(oldPosition, 0,getX());
        Array.setInt(oldPosition, 1,getY());
        
        // Switch triggered when a player crosses map boundarys. 
        // Compass item must change based on player's direction, this will keep track of the player direction.
        switch(cross) {
            case(1):
                northOrSouth = "SOUTH";
                break;
            case(2):
                northOrSouth = "NORTH";
                break;
            case(3):
                eastOrWest = "EAST";
                break;
            case(4):
                eastOrWest = "WEST";
                break;
        }
        System.out.println(northOrSouth);
        System.out.println(eastOrWest);
        System.out.println(cross);

        // Set new player direction and tile
        this.setX(newX);
        this.setY(newY);
        this.setPlayerTile(tile);

        // return old tile position previous tile to gamemap
        return(oldPosition);
    }
    
}
