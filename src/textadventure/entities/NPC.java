package textadventure.entities;
/**
 * Represents a Non-Playable Character (NPC) in the game world.
 * NPCs can interact with the player and provide additional functionality.
 * @author danieL
 */
import java.util.List;

public class NPC {
    private String name;
    private String description;
    private List<String> dialogues; // Cambiado de String a List<String>
    private String room;

    public NPC(String name, String description, List<String> dialogues, String room) {
        this.name = name;
        this.description = description;
        this.dialogues = dialogues;
        this.room = room;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getDialogues() {
        return dialogues; // Devuelve la lista de diálogos
    }

    public void interact() {
        // Mostrar todos los diálogos o solo uno aleatorio
        dialogues.forEach(System.out::println);
    }

    public String getRoom() {
        return room;
    }
}
