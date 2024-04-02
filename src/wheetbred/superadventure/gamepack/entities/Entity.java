package wheetbred.superadventure.gamepack.entities;
/*
 * Base class to hold basic methods for moving and locating non player characters
 */
abstract class Entity {
    public static int entityX, entityY;


    public static int getEntityX() {
        return entityX;
    }

    public static int getEntityY() {
        return entityY;
    }

    abstract void move();
    
}
