package wheetbred.superadventure.gamepack.items;

import wheetbred.superadventure.gamepack.entities.Player;

public abstract class Food extends Drop {
    private int healthGain;
    private int expiration;

    public int getHealthGain() {
        return healthGain;
    }

    public int getExpiration() {
        return expiration;
    }

    public void setExpiration(int expiration) {
        this.expiration = expiration;
    }

    public void setHealthGain(int healthGain) {
        this.healthGain = healthGain;
    }

    public void use(Player player) {
        player.setHealth(healthGain);
        player.inventory.dropItem(this);
    }
}
