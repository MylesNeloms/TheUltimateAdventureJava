package wheetbred.superadventure.gamepack.entities;

import java.lang.reflect.Array;

import wheetbred.superadventure.gamepack.items.Inventory;
import wheetbred.superadventure.gamepack.items.ItemGenerator;
import wheetbred.superadventure.gamepack.map.GameMap;

/*
 * Base class to hold basic methods for moving and locating non player characters
 */
public class Player extends Entity{

    // Vars for player position
    private int X, Y;
    private int health;
    private int maxHealth;

    private int stepCount;
    private int stepsFromStart;

    // Vars for setting player tile to appropriate character
    private static String previousTile;
    private static String playerTile;

    public Inventory inventory;
    

    // Vars for compass calculations
    private static String northOrSouth;
    private static String eastOrWest;
    public Player() {
        // Initialize player position. May change to add some variance
        X = 25;
        Y = 25;

        // Set health and begin counting steps. Possible that wandering could span events in game
        health = 100;
        stepCount = 0;
        stepsFromStart = 0;


        // initialize the players inventory
        inventory = ItemGenerator.initPlayerInventory(this);



        // Default player tile facing north. Replace init tile with "." May use this later for story
        playerTile = "  ^  ";
        previousTile = "  .  ";


        // Compass initially pointing north. Will likely add this functionality to an item
        northOrSouth = "NORTH";
        eastOrWest = "EAST";
    }




    // Setters
    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public void setHealth(int health) {
        if (this.health + health > this.maxHealth) {
            this.health = maxHealth;
        } else {
            this.health += health;
        }
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
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
    public Inventory getInventory() {
        return inventory;
    }

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
        // System.out.println(northOrSouth);
        // System.out.println(eastOrWest);
        // System.out.println(cross);

        // Set new player direction and tile
        this.setX(newX);
        this.setY(newY);
        this.setPlayerTile(tile);
        stepCount++;
        stepsFromStart++;
        if (stepCount > 3) {
            stepCount = 0;
            health -= (int)(Math.random() * 6);
        }

        System.out.println("Health:  " + health);
        // return old tile position previous tile to gamemap
        return(oldPosition);
    }



    @Override
    public void move() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'move'");
    }
    
}
