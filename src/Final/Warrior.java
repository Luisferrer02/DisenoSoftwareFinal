package Final;

public abstract class Warrior extends Character {
	public Warrior(int health, int defense) {
        super(health, defense);
    }

    @Override
    public void defend() {
        System.out.println(getType() + " usa su armadura para minimizar el daño recibido.");
    }
    
    public void fortifyArmor() {
        System.out.println(getType() + " se fortalece con armadura adicional.");
        setState(new FortifiedState(2, 10));  // Fortalece la defensa durante 2 turnos, aumentando la defensa en 10
    }
}
