package textadventure.logic;

import java.util.List;
import java.util.Map;
import textadventure.entities.Item;

/**
 * Represents the data structure for a room in the game, including its 
 * name, description, items, and exits. This class is used for parsing 
 * room data from external sources like JSON files.
 * 
 * @author qaffqa
 */
public class RoomData {
    public String name;
    public String description;
    public String enhacedDescription;
    public List<Item> items;
    public Map<String, String> exits;
    public String npc;
    //public Shop shop; 

}
