package textadventure.game;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import textadventure.entities.Room;
import textadventure.logic.CommandParser;
import textadventure.entities.Player;
import textadventure.logic.Command;
import textadventure.entities.Item;
import textadventure.util.TextFormatter;
import textadventure.logic.RoomData;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import textadventure.entities.NPC;


/**
 * The Game class handles the main game logic, including initializing the 
 * game world, processing player commands, and managing interactions 
 * between the player and the game world.
 * 
 * @author qaffqa
 */
public class Game {
    
    private Player player;
    private Room currentRoom;
    private CommandParser commandParser;
    private Map<String, Room> rooms;
    private Scanner sc;
    private Map<String, NPC> npcMap = new HashMap<>();

public Game() {
    this.player = new Player("The PathWarden");
    this.commandParser = new CommandParser();
    this.rooms = new HashMap<>();
    this.sc = new Scanner(System.in);

    // Primero carga las habitaciones
    loadRoomsFromJson();

    // Luego asigna la habitación inicial
    this.currentRoom = rooms.get("The Woods");
    
    // Verifica si la habitación inicial es válida
    if (this.currentRoom == null) {
        throw new IllegalStateException("Starting room not found in the map of rooms!");
    }

    // Luego carga los NPCs
    loadNPCsFromJson();
}


    public Room getCurrentRoom() {
        return currentRoom;
    }
    public Scanner getScanner() {
        return sc;  // Método para acceder al Scanner
    }
    
    /**
     * Initializes the rooms of the game, adds items, and sets the exits between rooms.
     */
private void loadRoomsFromJson() {
    Gson gson = new Gson();

    try (FileReader reader = new FileReader("c:\\Users\\danie\\Desktop\\textadventure\\roomItems.json")) {
        // Define el tipo de datos que estás deserializando
        Type roomListType = new TypeToken<List<RoomData>>() {}.getType();
        List<RoomData> roomDataList = gson.fromJson(reader, roomListType);

        // Crear las habitaciones y mapearlas por nombre
        for (RoomData roomData : roomDataList) {
            Room room = new Room(roomData.name, roomData.description, roomData.enhacedDescription);

            // Agregar los items a la habitación
            if (roomData.items != null) {
                for (Item item : roomData.items) {
                    room.addItem(item);
                }
            }

            // Guardar la habitación en el mapa
            rooms.put(roomData.name, room);
        }

        // Ahora que todas las habitaciones están creadas, conectar las salidas
        for (RoomData roomData : roomDataList) {
            Room room = rooms.get(roomData.name);

            if (roomData.exits != null) { // Verificar si hay salidas definidas
                for (Map.Entry<String, String> exit : roomData.exits.entrySet()) {
                    Room destination = rooms.get(exit.getValue());
                    if (destination != null) {
                        room.addExit(exit.getKey(), destination);
                    } else {
                        System.out.println("Exit leads to a non-existent room: " + exit.getValue());
                    }
                }
            } else {
                System.out.println("No exits defined for room: " + roomData.name);
            }
        }

    } catch (IOException e) {
        e.printStackTrace();
        System.out.println("Error loading rooms from JSON.");
    }
}

    
    private void loadNPCsFromJson() {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader("c:\\Users\\danie\\Desktop\\textadventure\\npcs.json")) {
            Type npcListType = new TypeToken<List<NPC>>() {}.getType();
            List<NPC> npcList = gson.fromJson(reader, npcListType);

            for (NPC npc : npcList) {
                npcMap.put(npc.getName(), npc);

                // Ensure NPC is assigned to the correct room
                Room room = rooms.get(npc.getRoom());
                if (room != null) {
                    room.addNPC(npc); // Add NPC to the correct room
                } else {
                    System.out.println("Room not found for NPC: " + npc.getName() + " (Room: " + npc.getRoom() + ")");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error loading NPCs from JSON.");
        }
    }

    public void start() {
        System.out.println("---[PATHWARDEN]---");
        System.out.println("Welcome, " + player.getName() + "!");
        System.out.println("Enter 'start' to begin or 'quit' to exit ...");

        // Wait for user input to start or quit
        boolean isPlaying = true;
        while (isPlaying) {
            System.out.print("Enter a command: ");
            String input = sc.nextLine().trim().toLowerCase();  // Normalize input

            if (input.equals("start")) {
                // Start the game after 'start' command
                System.out.println("The game has begun!");
                break;  // Exit the loop and proceed to game
            } else if (input.equals("quit")) {
                // Quit the game after 'quit' command
                System.out.println("Goodbye, " + player.getName() + "!");
                isPlaying = false;  // Exit the loop and stop the game
            } else {
                // Handle unknown commands
                System.out.println("Unknown command. Please enter 'start' to begin or 'quit' to exit.");
            }
        }

        // Once 'start' is entered, begin the game loop
        if (isPlaying) {
            playGame();
        }
    }

    private void playGame() {
        System.out.println("\n" + currentRoom.getDescription());
        System.out.println("Exits: " + currentRoom.getExits());

        // Main game loop to handle player commands
        while (true) {
            System.out.print("Enter a command: ");
            String input = sc.nextLine();
            Command command = commandParser.parseCommand(input);

            if (command == null) {
                System.out.println("Unknown command.");
            } else {
                executeCommand(command);
            }
        }
    }
    
    private void interactWithNPC(String npcName) {
        NPC npc = currentRoom.getNPCs().stream()
                            .filter(n -> n.getName().equalsIgnoreCase(npcName))
                            .findFirst()
                            .orElse(null);
        if (npc != null) {
            npc.interact();
        } else {
            System.out.println("No NPC with that name here.");
        }
    }
    private void executeCommand(Command command) {
        String action = command.getAction();
        String target = command.getTarget();

        System.out.println("Executing Command: Action = " + action + ", Target = " + target); // Debugging line

        switch (action) {
            case "go":
                move(target);
                break;
            case "pick":
                pickUpItem(target);
                break;
            case "use":
                useItem(target);
                break;
            case "inventory":
                showInventory();  
                break;
            case "look":
                if ("around".equals(target)) {
                    lookAround();
                } else {
                    System.out.println("Unknown target for look.");
                }
            case "talk":
                interactWithNPC(target);
                break;    
            default:
                System.out.println("Unknown action.");
        }
    }

    private void move(String direction) {
        Room nextRoom = currentRoom.getExit(direction);
        if (nextRoom != null) {
            currentRoom = nextRoom;
            String movementMessage = "You move " + direction + " and enter " + currentRoom.getName() + ".";
            String formattedMovementMessage = TextFormatter.formatText(movementMessage, true, 40);
            System.out.println(formattedMovementMessage);
            System.out.println(currentRoom.getDescription());  // Print the description of the new room
        } else {
            System.out.println("You can't go that way.");
        }
    }

    private void pickUpItem(String itemName) {
        Item item = findItemInCurrentRoom(itemName);
        if (item != null) {
            player.addItemToInventory(item);
            currentRoom.removeItem(item);
            System.out.println("You picked up a " + itemName + ".");
        } else {
            System.out.println("There is no " + itemName + " here.");
        }
    }

    private void useItem(String itemName) {
        // Code to use the item
        System.out.println("You used the " + itemName + ".");
    }

    private Item findItemInCurrentRoom(String itemName) {
        return currentRoom.getItems().stream()
                          .filter(item -> item.getName().equalsIgnoreCase(itemName))
                          .findFirst()
                          .orElse(null);
    }

    public void showInventory() {
        System.out.println("Your Inventory:");

        // Get inventory from player object
        if (player.getInventory().isEmpty()) {
            System.out.println("Your inventory is empty.");
        } else {
            for (Item item : player.getInventory()) {
                System.out.println(item.getName() + ": " + item.getDescription());  // Assuming Item class has a getName() method
            }
        }
    }

    public void lookAround() {
        // Print a detailed description of the current room
        System.out.println(currentRoom.getEnhacedDescription()); 

        // List items that can be picked up in the room
        System.out.println("Items here:");
        if (currentRoom.getItems().isEmpty()) {
            System.out.println("There are no items here.");
        } else {
            for (Item item : currentRoom.getItems()) {
                System.out.println(item.getName() + ": " + item.getDescription());  // Assuming Item class has getName() and getDescription()
            }
        }
    }
}
