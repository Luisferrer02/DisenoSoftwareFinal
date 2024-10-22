package Final;

public class ShieldWarriorFactory implements CharacterFactory{

	public Character createCharacter() {
		return new ShieldWarrior(120, 70);
	}
}
