package Final;

public class SwordWarrior extends Warrior {

	public SwordWarrior(int health, int defense) {
        super(health, defense);
    }

    @Override
    public void attack(Character target) {
        System.out.println(getType() + " ataca con su espada a " + target.getType() + ".");
        target.decreaseHealth(25); // Daño de ejemplo, puede ser ajustado
    }

    @Override
    public String getType() {
        return "Guerrero con Espada";
    }

}
