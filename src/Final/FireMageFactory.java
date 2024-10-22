package Final;

public class FireMageFactory implements CharacterFactory{

	public Character createCharacter() {
		return new FireMage(100, 50);
	}
}
