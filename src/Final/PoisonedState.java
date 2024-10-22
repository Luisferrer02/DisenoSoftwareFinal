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
            System.out.println(character.getType() + " está envenenado y pierde " + poisonDamage + " puntos de salud.");
            character.decreaseHealth(poisonDamage);
            duration--;
        } else {
            character.setState(new NormalState());  // Revertir al estado normal después que el veneno se agote
        }
    }

}
