package player;

/**
 *
 * @author daniel
 */
public class Player {
    private String husk;
    private int level;
    private int flesh;
    private int resilience;
    private int wanderlust;
    private int guile;
    private int zealotry;
    private int mind;
  //private Inventory inventory;

    public Player() {
        this.husk = "";
        this.level = 1;
        this.flesh = 1;
        this.resilience = 1;
        this.wanderlust = 1;
        this.guile = 1;
        this.zealotry = 1;
        this.mind = 1;
    }
    
    public Player(String husk, int level, int flesh, int resilience, int wanderlust, int guile, int zealotry, int mind) {
        this.husk = husk;
        this.level = level;
        this.flesh = flesh;
        this.resilience = resilience;
        this.wanderlust = wanderlust;
        this.guile = guile;
        this.zealotry = zealotry;
        this.mind = mind;
    }
    
    public Player(String husk, int level) {
        this.husk = husk;
        this.level = level;
    }

    public String getHusk() {
        return husk;
    }

    public void setHusk(String husk) {
        this.husk = husk;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getFlesh() {
        return flesh;
    }

    public void setFlesh(int flesh) {
        this.flesh = flesh;
    }

    public int getResilience() {
        return resilience;
    }

    public void setResilience(int resilience) {
        this.resilience = resilience;
    }

    public int getWanderlust() {
        return wanderlust;
    }

    public void setWanderlust(int wanderlust) {
        this.wanderlust = wanderlust;
    }

    public int getGuile() {
        return guile;
    }

    public void setGuile(int guile) {
        this.guile = guile;
    }

    public int getZealotry() {
        return zealotry;
    }

    public void setZealotry(int zealotry) {
        this.zealotry = zealotry;
    }

    public int getMind() {
        return mind;
    }

    public void setMind(int mind) {
        this.mind = mind;
    }
    
    public void setWarrior(Player player) {
        this.husk = "Warrior";
        this.level = 1;
        this.flesh = 7; // Fuerza
        this.resilience = 6; // Resistencia
        this.wanderlust = 3; // Exploración
        this.guile = 2; // Astucia
        this.zealotry = 4; // Devoción
        this.mind = 2; // Mente
    }

    public void setScholar(Player player) {
        this.husk = "Scholar";
        this.level = 1;
        this.flesh = 2; // Fuerza
        this.resilience = 3; // Resistencia
        this.wanderlust = 3; // Exploración
        this.guile = 4; // Astucia
        this.zealotry = 4; // Devoción
        this.mind = 8; // Mente
    }

    public void setDevotee(Player player) {
        this.husk = "Devotee";
        this.level = 1;
        this.flesh = 4; // Fuerza
        this.resilience = 5; // Resistencia
        this.wanderlust = 3; // Exploración
        this.guile = 3; // Astucia
        this.zealotry = 7; // Devoción
        this.mind = 2; // Mente
    }

    public void setStray(Player player) {
        this.husk = "Stray";
        this.level = 1;
        this.flesh = 5; // Fuerza
        this.resilience = 4; // Resistencia
        this.wanderlust = 6; // Exploración
        this.guile = 4; // Astucia
        this.zealotry = 2; // Devoción
        this.mind = 3; // Mente
    }

}
