package wheetbred.superadventure.gamepack.entities;
/*
 * Base class to hold basic methods for moving and locating non player characters
 */
public class Player {
    public static int playerX, playerY;
    public Player() {

    }

    public static void setPlayerX(int playerX) {
        Player.playerX = playerX;
    }

    public static void setPlayerY(int playerY) {
        Player.playerY = playerY;
    }

    public static int getplayerX() {
        return playerX;
    }

    public static int getplayerY() {
        return playerY;
    }

    
}
