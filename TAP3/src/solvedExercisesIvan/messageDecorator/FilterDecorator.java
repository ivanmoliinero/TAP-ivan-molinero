package solvedExercisesIvan.messageDecorator;

public class FilterDecorator implements MessageDecorator {
    private MessageDecorator fatherDecorator;

    public FilterDecorator(MessageDecorator fatherDecorator) {
        this.fatherDecorator = fatherDecorator;
    }

    @Override
    public String getText() {
        return fatherDecorator.getText().replace("tonto", "xxx");
    }
}
