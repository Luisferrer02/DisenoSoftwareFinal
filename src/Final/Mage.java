package Final;

public abstract class Mage extends Character {

	public Mage(int health, int defense) {
        super(health, defense);
    }

	public void defend() {
		System.out.println(getType() + " crea una barrera mágica para protegerse.");
	}
	
	public void castPoisonSpell(Character target) {
	    System.out.println(getType() + " lanza un hechizo de veneno a " + target.getType() + ".");
	    target.setState(new PoisonedState(3, 5));  // Aplica veneno durante 3 turnos, haciendo 5 de daño cada turno
	}
	
	public void heal() {
		System.out.println(getType() + " se bebe una pócima de curación");
		this.increaseHealth(25);
	}
}
