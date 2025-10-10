package solvedExercisesIvan.messageDecorator;

// this will be the last "decorator" of the decorator chain/pipe.
// implements is used so as to allow the final class to be a decorator,
// but we could do that this message class is the final class itself
// and the decorators inherit from it.
public class Message implements MessageDecorator {
    private String text;

    public Message() {}

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
