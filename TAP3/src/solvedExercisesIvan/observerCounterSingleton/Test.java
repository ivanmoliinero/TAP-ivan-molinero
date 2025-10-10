package solvedExercisesIvan.observerCounterSingleton;

import solvedExercisesIvan.counterSingleton.CounterSingleton;

/**
 * Created by pedro on 10/7/16.
 */
public class Test {
    public static void main(String[] args) {
        Subject subject = new Subject();

        subject.attach(new HexaObserver());
        subject.attach(new OctalObserver());
        subject.attach(new BinaryObserver());

        // new observer
        subject.attach((value) -> {if(value % 2 != 0) System.out.println("Odd number: " + value);});


        System.out.println("First state change: 15");
        subject.setState(15);
        System.out.println("Second state change: 10");
        subject.setState(10);

        System.out.println("Number of observers: " + CounterSingleton.getInstance());
    }
}
