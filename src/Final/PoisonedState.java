package Final;

public class PoisonedState implements CharacterState {

	private int duration;
    private int poisonDamage;

    public PoisonedState(int duration, int poisonDamage) {
        this.duration = duration;
        this.poisonDamage = poisonDamage;
    }

    @Override
    public void handle(Character character) {
        if (duration > 0) {
            System.out.println(character.getType() + " est� envenenado y pierde " + poisonDamage + " puntos de salud.");
            character.decreaseHealth(poisonDamage);
            duration--;
        } else {
            character.setState(new NormalState());  // Revertir al estado normal despu�s que el veneno se agote
        }
    }

}
