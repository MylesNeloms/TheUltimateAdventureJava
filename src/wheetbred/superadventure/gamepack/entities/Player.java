package wheetbred.superadventure.gamepack.entities;

import java.lang.reflect.Array;

import wheetbred.superadventure.gamepack.mapgenerator.GameMap;

/*
 * Base class to hold basic methods for moving and locating non player characters
 */
public class Player {
    private static int X, Y;
    static String [][] gameMap = new String[50][50];
    private static String previousTile;
    private static String playerTile;
    private static String northOrSouth;
    private static String eastOrWest;
    public Player() {
        X = 25;
        Y = 25;
        playerTile = "  ^  ";
        previousTile = "  .  ";
        northOrSouth = "North";
        eastOrWest = "East";
    }


    private void setX(int playerX) {
        X = playerX;
    }

    private void setY(int playerY) {
        Y = playerY;
    }

    public void setPlayerTile(String newTile) {
        playerTile = newTile;
    }

    public String getPlayerTile() {
       return playerTile;
    }

    public String getPreviousTile() {
        return previousTile;
     }
     public void setPreviousTile(String oldTile) {
        previousTile = oldTile;
     }
    
    public String getplayerDirection(String direction) {
        switch(direction) {
            case("NOS"):
                return eastOrWest;
            case("EOW"):
                return eastOrWest;
            default:
                return "N/a";
        }
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
            default:
                northOrSouth = "NORTH";
                eastOrWest = "EAST";
        }
     }
     

    public int getX() {
        return X;
    }
    public int getY() {
        return Y;
    }

    
    public int[] move(int newX, int newY, int cross, String tile) {
        // TODO Auto-generated method stub
        int[] oldPosition = new int[2];
        Array.setInt(oldPosition, 0,getX());
        Array.setInt(oldPosition, 1,getY());
        
        // switch(cross) {
        //     case(1):
        //         northOrSouth = "SOUTH";
        //         break;
        //     case(2):
        //         northOrSouth = "NORTH";
        //         break;
        //     case(3):
        //         eastOrWest = "EAST";
        //         break;
        //     case(4):
        //         eastOrWest = "WEST";
        //         break;
        //     default:
        //         northOrSouth = "NORTH";
        //         eastOrWest = "EAST";
        // }
        // System.out.println(northOrSouth);
        // System.out.println(eastOrWest);
        // System.out.println(cross);
        this.setX(newX);
        this.setY(newY);
        this.setPlayerTile(tile);

        return(oldPosition);
    }
    
}
