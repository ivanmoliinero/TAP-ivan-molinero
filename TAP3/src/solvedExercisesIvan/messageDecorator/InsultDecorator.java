package solvedExercisesIvan.messageDecorator;

public class InsultDecorator implements MessageDecorator {
    private MessageDecorator fatherDecorator;

    public InsultDecorator(MessageDecorator fatherDecorator) {
        this.fatherDecorator = fatherDecorator;
    }

    @Override
    public String getText() {
        return fatherDecorator.getText() + " Para que te enteres tonto del bote.";
    }


}
