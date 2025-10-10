package solvedExercisesIvan.messageDecorator;

public class UpperCaseDecorator implements MessageDecorator{
    private MessageDecorator fatherDecorator;

    public UpperCaseDecorator(MessageDecorator fatherDecorator) {
        this.fatherDecorator = fatherDecorator;
    }

    @Override
    public String getText() {
        return fatherDecorator.getText().toUpperCase(); // first modification applied.
    }
}
