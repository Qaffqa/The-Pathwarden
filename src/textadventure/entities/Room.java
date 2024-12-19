package textadventure.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import textadventure.entities.NPC;

/**
 * Represents a room in the game world, containing items and exits to other rooms.
 * 
 * @author qaffqa
 */
public class Room {
    
    private String name;
    private String description;
    private String enhacedDescription;
    private List<Item> items;
    private Map<String, Room> exits;
    private List<NPC> npcs = new ArrayList<>();

    public Room(String name, String description, String enhacedDescription1) {
        this.name = name;
        this.description = description;
        this.items = new ArrayList<>();
        this.exits = new HashMap<>();
    }

    // Getter and setter methods

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
    
    public String getEnhacedDescription(){
        return enhacedDescription;
    }
    
    public void setEnhacedDescription(String enhacedDescription) {
        this.enhacedDescription = enhacedDescription;
    }
    
    public List<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }
    
    public void addExit(String direction, Room room) {
        exits.put(direction, room);
    }
    public void setExits(String direction, Room room) {
        exits.put(direction, room);
    }

    public Room getExit(String direction) {
        return exits.get(direction);
    }

    public String getExits() {
        return String.join(", ", exits.keySet());
    }
    
    public void addNPC(NPC npc) {
        npcs.add(npc);
}

    public List<NPC> getNPCs() {
        return npcs;
    }
}
