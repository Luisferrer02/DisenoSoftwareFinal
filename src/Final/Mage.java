package Final;

public abstract class Mage extends Character {

	public Mage(int health, int defense) {
        super(health, defense);
    }

	public void defend() {
		System.out.println(getType() + " crea una barrera m�gica para protegerse.");
	}
	
	public void castPoisonSpell(Character target) {
	    System.out.println(getType() + " lanza un hechizo de veneno a " + target.getType() + ".");
	    target.setState(new PoisonedState(3, 5));  // Aplica veneno durante 3 turnos, haciendo 5 de da�o cada turno
	}
	
	public void heal() {
		System.out.println(getType() + " se bebe una p�cima de curaci�n");
		this.increaseHealth(25);
	}
}
