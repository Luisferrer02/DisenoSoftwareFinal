package Final;

public class FireMage extends Mage {
	public FireMage(int health, int defense) {
        super(health, defense);
    }

    @Override
    public void attack(Character target) {
        System.out.println(getType() + " lanza una bola de fuego a " + target.getType() + ".");
        target.decreaseHealth(20); // Daño de ejemplo, puede ser ajustado
    }

    @Override
    public String getType() {
        return "Mago de Fuego";
    }
}
