package Final;

public class SwordWarriorFactory implements CharacterFactory{

	public Character createCharacter() {
		return new SwordWarrior(120, 70);
	}
}
