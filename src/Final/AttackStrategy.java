package Final;

public class AttackStrategy implements CombatStrategy {

	@Override
	public void execute(Character attacker, Character defender) {
		attacker.attack(defender);
	}
}
