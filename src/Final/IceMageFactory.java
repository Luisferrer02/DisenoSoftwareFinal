package Final;

public class IceMageFactory implements CharacterFactory{

	public Character createCharacter() {
		return new IceMage(100, 50);
	}
}
