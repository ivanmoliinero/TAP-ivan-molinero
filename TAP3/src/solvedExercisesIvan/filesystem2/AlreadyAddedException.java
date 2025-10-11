package solvedExercisesIvan.filesystem2;


public class AlreadyAddedException extends RuntimeException {
    public AlreadyAddedException(SystemComponent comp) {
        super(comp + " was already added.");
    }
}
