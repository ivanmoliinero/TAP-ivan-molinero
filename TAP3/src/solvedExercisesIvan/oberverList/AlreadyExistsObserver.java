package solvedExercisesIvan.oberverList;

public class AlreadyExistsObserver extends RuntimeException {
    public AlreadyExistsObserver(Observer obs) {
        super(obs + " was already subscribed to this list.");
    }
}
