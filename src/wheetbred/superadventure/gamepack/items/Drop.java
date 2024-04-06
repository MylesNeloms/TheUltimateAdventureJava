package wheetbred.superadventure.gamepack.items;

import javax.swing.text.html.parser.Entity;

public abstract class Drop {
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
    
    public abstract void attain(Inventory inventory);

}
