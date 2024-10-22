package Final;

public class PoisonStrategy implements CombatStrategy {
	
	public void execute(Character attacker, Character defender) {
		((Mage)attacker).castPoisonSpell(defender);
    }
}
