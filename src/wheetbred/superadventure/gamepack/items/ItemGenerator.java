package wheetbred.superadventure.gamepack.items;

import java.util.ArrayList;
import java.util.List;

import wheetbred.superadventure.gamepack.entities.Player;

public class ItemGenerator {

    public static Inventory initPlayerInventory(Player player) {
        Compass compass = new Compass();
        List<Drop> inventoryItems = new ArrayList<Drop>();
        inventoryItems.add(compass);

        // Maybe give food to start.

        Inventory playerInventory = new Inventory(player, inventoryItems);

        return playerInventory;
    }

}
