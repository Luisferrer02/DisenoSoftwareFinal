package Final;

public class IceMage extends Mage {
	public IceMage(int health, int defense) {
        super(health, defense);
    }

    @Override
    public void attack(Character target) {
        System.out.println(getType() + " dispara una ráfaga de hielo a " + target.getType() + ".");
        target.decreaseHealth(15); // Daño de ejemplo, puede ser ajustado
    }

    @Override
    public String getType() {
        return "Mago de Hielo";
    }
}
