package Final;

public class ParalyzedState implements CharacterState {
    private int duration;

    public ParalyzedState(int duration) {
        this.duration = duration;
    }

    @Override
    public void handle(Character character) {
    	if (duration > 0) {
            System.out.println(character.getType() + " está paralizado y no puede moverse.");
            duration--;
        } else {
            character.setState(new NormalState());
        }
    }

}
