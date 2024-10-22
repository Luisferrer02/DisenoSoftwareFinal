package Final;

public class ShieldWarrior extends Warrior {

	public ShieldWarrior(int health, int defense) {
        super(health, defense);
    }

    @Override
    public void attack(Character target) {
        System.out.println(getType() + " embiste con su escudo a " + target.getType() + ".");
        target.decreaseHealth(15); // Daño de ejemplo, menor debido al enfoque defensivo
    }

    @Override
    public String getType() {
        return "Guerrero con Escudo";
    }

}
