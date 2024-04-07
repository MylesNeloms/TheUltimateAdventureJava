package wheetbred.superadventure.gamepack.items;

import javax.swing.text.html.parser.Entity;

public abstract class Drop {
    public static String name;
    public static String dropTile;
    private Entity owner;
    private int dropRate;

    public Entity getOwner() {
        return owner;
    }

    public void setOwner(Entity owner) {
        this.owner = owner;
    }

    public int getDropRate() {
        return dropRate;
    }
    public void setDropRate(int dropRate) {
        this.dropRate = dropRate;
    }

    public static String getName() {
        return name;
    }

    public abstract void attain(Inventory inventory);

}
