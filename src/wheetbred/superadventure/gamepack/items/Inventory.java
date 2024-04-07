package wheetbred.superadventure.gamepack.items;

import java.util.List;

import javax.swing.text.html.parser.Entity;

import wheetbred.superadventure.gamepack.entities.Player;

public class Inventory {
    private List<Drop> InventoryItems;
    private Entity owner;

    Inventory(Player player, List<Drop> InventoryItems) {
        this.InventoryItems = InventoryItems;
    }

    public void dropItems(List<Drop> InventoryItems) {
        for (Drop d : InventoryItems) {
            this.InventoryItems.remove(d);
        }
        
    }
    public void dropItem(Drop InventoryItem) {
            this.InventoryItems.remove(InventoryItem);
        
    }
    

}
