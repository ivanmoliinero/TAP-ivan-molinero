package solvedExercisesIvan.observerCounterSingleton;

import solvedExercisesIvan.counterSingleton.CounterSingleton;

/**
 * Created by pedro on 10/7/16.
 */
public class BinaryObserver implements Observer {

    public BinaryObserver() {
        CounterSingleton.getInstance().increment(1);
    }

    @Override
    public void update(int newState) {
        System.out.println( "Binary String: " + Integer.toBinaryString(newState));
    }
}
