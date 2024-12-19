package textadventure.logic;

import java.util.Arrays;
import java.util.List;

/**
 * Parses the player's input command into a Command object.
 * This class is responsible for interpreting the text input
 * from the player and converting it into a valid action and target.
 * 
 * <p>The parser splits the input into an action and target and checks whether
 * the action is valid. If valid, it creates a Command object to be executed.</p>
 * 
 * @author qaffqa
 */
public class CommandParser {

    // List of valid actions that the player can issue
    private static final List<String> ACTIONS = Arrays.asList("go", "pick", "use", "inventory", "look");

    /**
     * Parses a raw input command into a Command object.
     * 
     * <p>This method splits the input string into an action (such as "go", "pick", or "use")
     * and a target (such as a direction or item name). If the command is valid, it returns
     * a Command object representing the player's intent. If the input is invalid, it returns null.</p>
     * 
     * @param input The raw input string from the player (e.g., "go north" or "pick sword")
     * @return A Command object with the parsed action and target, or null if the input is invalid
     */
    public Command parseCommand(String input) {
        input = input.trim().toLowerCase(); // Normalize input

        // Handle the case of inventory command which does not require a target
        if (input.equals("inventory")) {
            return new Command("inventory", null);  // Inventory action with no target
        }

        // Handle multi-word action like "look around"
        if (input.startsWith("look ")) {
            return new Command("look", input.substring(5).trim()); // Everything after "look " is the target
        }

        String[] parts = input.split(" ", 2); // Split the input into action and target

        // Handle case where there is no target (e.g., "go north")
        if (parts.length < 2) {
            if (Arrays.asList("go", "pick", "use").contains(parts[0])) {
                return null; // Invalid command if the action needs a target
            }
            return new Command(parts[0], null); // Look command or inventory can be valid without target
        }

        String action = parts[0].toLowerCase();  // First word is the action
        String target = parts[1].toLowerCase();  // Second word is the target

        // Check if action is valid
        if (!ACTIONS.contains(action)) {
            return null; // Invalid action
        }

        return new Command(action, target);
    }
}
