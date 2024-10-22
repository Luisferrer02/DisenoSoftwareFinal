package Final;

public class FortifiedState implements CharacterState {
    private int duration;
    private int defenseBoost;

    public FortifiedState(int duration, int defenseBoost) {
        this.duration = duration;
        this.defenseBoost = defenseBoost;
    }

    @Override
    public void handle(Character character) {
        if (duration > 0) {
            System.out.println(character.getType() + " está fortificado y su defensa aumenta en " + defenseBoost + ".");
            character.increaseDefense(defenseBoost);  // Aplica el aumento de defensa
            duration--;
        } else {
            character.setState(new NormalState());  // Revertir al estado normal después de la duración
        }
    }
}