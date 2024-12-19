package textadventure.entities;

import java.util.List;

/**
 *
 * @author danie
 */
public class Shop {
    private String name;
    private List<Item> inventory;

    public Shop(String name, List<Item> inventory) {
        this.name = name;
        this.inventory = inventory;
    }

    public void displayItems() {
        System.out.println("Items available for purchase:");
        for (Item item : inventory) {
            System.out.println(item.getName() + " - " + item.getDescription());
        }
    }

    public boolean buyItem(String itemName, Player player) {
        Item item = inventory.stream()
                             .filter(i -> i.getName().equalsIgnoreCase(itemName))
                             .findFirst()
                             .orElse(null);
        if (item != null) {
            inventory.remove(item);
            player.addItemToInventory(item);
            System.out.println("You bought " + itemName + ".");
            return true;
        } else {
            System.out.println("Item not found in the shop.");
            return false;
        }
    }
}
