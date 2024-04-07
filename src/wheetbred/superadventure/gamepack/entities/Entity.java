package wheetbred.superadventure.gamepack.entities;

import wheetbred.superadventure.gamepack.items.ItemGenerator;

/*
 * Base class to hold basic methods for moving and locating non player characters
 */
abstract class Entity {
    public static int X, Y;
    private String previousTile;


    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    private void setY(int newY) {
        Y = newY;
    }
    private void setX(int newX) {
        X = newX;
    }

    public String getPreviousTile() {
        return previousTile;
    }

    public void setPreviousTile(String previousTile) {
        this.previousTile = previousTile;
    }

    public abstract void move();
    
}
