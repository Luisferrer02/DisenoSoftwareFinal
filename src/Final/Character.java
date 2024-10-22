package Final;

public abstract class Character {
	private int health;
    private int defense;
    private CharacterState state = new NormalState(); // Comenzamos con el estado normal
    private CombatStrategy strategy;
    
    public Character(int health, int defense) {
        this.health = health;
        this.defense = defense;
    }
    
    public abstract void attack(Character target);
    public abstract void defend();
    
    public abstract String getType();
    
    public void setState(CharacterState state) {
        this.state = state;
    }
    
    public void processTurn() {
        state.handle(this); // El estado actual maneja su comportamiento cada turno
    }
    
    public void decreaseHealth(int amount) {
        this.health -= amount;
        if (this.health < 0) this.health = 0;
        System.out.println(getType() + " pierde " + amount + " puntos de salud, salud restante: " + this.health);
    }
    
    public void increaseHealth(int amount) {
    	this.health += amount;
    }
    
    public void increaseDefense(int amount) {
        this.defense += amount;
        System.out.println(getType() + " aumenta su defensa en " + amount + ".");
    }
    
    public int getHealth() {
        return health;
    }

    public int getDefense() {
        return defense;
    }
    
    public void setStrategy(CombatStrategy strategy) {
        this.strategy = strategy;
    }

    public void action(Character target) {
        if (strategy != null) {
            strategy.execute(this, target);
        }
    }
}
