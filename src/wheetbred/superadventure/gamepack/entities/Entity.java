package wheetbred.superadventure.gamepack.entities;
/*
 * Base class to hold basic methods for moving and locating non player characters
 */
abstract class Entity {
    public static int X, Y;


    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    private void setY(int newY) {
        Entity.Y = newY;
    }
    private void setX(int newX) {
        this.X = newX;
    }

    public abstract void move();
    
}
