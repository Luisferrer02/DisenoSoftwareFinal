package Final;

public class HealingStrategy implements CombatStrategy{
	@Override
	public void execute(Character attacker, Character defender) {
		
		((Mage)attacker).heal();
	}
}
