package textadventure.logic;

/**
 * Represents a command that the player can input in the game,
 * such as "go north" or "pick up sword". The command consists of 
 * an action (e.g., "go", "pick", "use") and a target (e.g., "north", "sword").
 * 
 * <p>This class is used to capture player inputs, breaking them down into 
 * actionable components for game processing.</p>
 * 
 * @author qaffqa
 */
public class Command {
    
    private String action;  // The main action (e.g., "go", "pick", "use")
    private String target;  // The target of the action (e.g., "north", "sword")

    /**
     * Constructs a new Command object with the specified action and target.
     * 
     * @param action The main action (e.g., "go", "pick", "use").
     * @param target The target of the action (e.g., "north", "sword").
     */
    public Command(String action, String target) {
        this.action = action;
        this.target = target;
    }

    // Getter and setter methods

    /**
     * Gets the action associated with the command.
     * 
     * @return The action of the command (e.g., "go").
     */
    public String getAction() {
        return action;
    }

    /**
     * Sets the action for the command.
     * 
     * @param action The action to set (e.g., "go").
     */
    public void setAction(String action) {
        this.action = action;
    }

    /**
     * Gets the target associated with the command.
     * 
     * @return The target of the command (e.g., "north", "sword").
     */
    public String getTarget() {
        return target;
    }

    /**
     * Sets the target for the command.
     * 
     * @param target The target to set (e.g., "north", "sword").
     */
    public void setTarget(String target) {
        this.target = target;
    }

    /**
     * Returns a string representation of the command.
     * 
     * @return A string in the format: "Command: action target" (e.g., "Command: go north").
     */
    @Override
    public String toString() {
        return "Command: " + action + " " + target;
    }
}
