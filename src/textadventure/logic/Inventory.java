package textadventure.logic;

import java.util.ArrayList;
import java.util.List;
import textadventure.entities.Item;

/**
 * Manages the player's inventory, allowing items to be added, removed, and viewed.
 * This class provides methods for interacting with the player's collection of items.
 * 
 * <p>The inventory stores items the player collects during the game. It allows the player to add items,
 * remove items, and view the current contents of the inventory.</p>
 * 
 * @author qaffqa
 */
public class Inventory {
    private List<Item> items; // List of items in the inventory

    /**
     * Constructs an empty inventory.
     * Initializes the list of items the player can collect.
     */
    public Inventory() {
        this.items = new ArrayList<>();
    }

    /**
     * Adds an item to the player's inventory.
     * 
     * @param item The item to be added to the inventory.
     */
    public void addItem(Item item) {
        items.add(item);
        System.out.println("You have collected: " + item.getName());
    }

    /**
     * Removes an item from the player's inventory if it exists.
     * 
     * @param item The item to be removed from the inventory.
     */
    public void removeItem(Item item) {
        if (items.contains(item)) {
            items.remove(item);
            System.out.println("You have removed: " + item.getName());
        } else {
            System.out.println("Item not found in inventory.");
        }
    }

    /**
     * Displays the current contents of the player's inventory.
     * If the inventory is empty, it will notify the player that the inventory is empty.
     */
    public void showInventory() {
        if (items.isEmpty()) {
            System.out.println("Your inventory is empty.");
        } else {
            System.out.println("Inventory:");
            for (Item item : items) {
                System.out.println("- " + item.getName());
            }
        }
    }

    /**
     * Gets the list of items currently in the inventory.
     * 
     * @return The list of items in the inventory.
     */
    public List<Item> getItems() {
        return items;
    }
}
