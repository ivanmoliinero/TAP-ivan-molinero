package solvedExercisesIvan.messageDecorator;

public class main {
    public static void main(String[] args) {
        Message text = new Message();

        // set the initial message.
        text.setText("buenos días, me llamo iván molinero y esta es mi carta de presentación.");

        // stablish the pipe/chain of decorators.
        UpperCaseDecorator upperCase = new UpperCaseDecorator(text);
        InsultDecorator insultDecorator = new InsultDecorator(upperCase);
        FilterDecorator filterDecorator = new FilterDecorator(insultDecorator);

        // let the show begin.
        System.out.println(filterDecorator.getText());
    }
}
