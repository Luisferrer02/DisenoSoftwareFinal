package Final;

public class ArmorStrategy implements CombatStrategy {

	@Override
	public void execute(Character attacker, Character defender) {
		/*if (attacker instanceof Warrior) {
            ((Warrior)attacker).fortifyArmor();
        }*/
		//La comprobacion ya se hace en el gamemanager con el instanceof
		((Warrior)attacker).fortifyArmor();
	}

}
