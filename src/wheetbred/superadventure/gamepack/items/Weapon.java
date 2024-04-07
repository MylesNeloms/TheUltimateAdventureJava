package wheetbred.superadventure.gamepack.items;

public abstract class Weapon extends Drop {
    private static int attack;
    private int durability;
    private static int accuracy;


    public static int getAttack() {
        return attack;
    }

    public static int getAccuracy() {
        return accuracy;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }



    
}
