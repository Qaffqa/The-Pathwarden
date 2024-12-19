package textadventure.entities;

/**
 * Represents items that the player can interact with in the game.
 * Each item has a name and a description.
 * 
 * <p>Items can be anything from weapons to key items, and could be extended
 * for specific types (e.g., consumables, tools, etc.) if necessary.</p>
 * 
 * @author qaffqa
 */
public class Item {
    private String name;        // The name of the item
    private String description; // A brief description of the item
    
    /**
     * Constructs an Item with the specified name and description.
     * 
     * @param name        The name of the item.
     * @param description A description of the item.
     */
    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // Getter and Setter methods

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Item: " + name + " - " + description;
    }
}
