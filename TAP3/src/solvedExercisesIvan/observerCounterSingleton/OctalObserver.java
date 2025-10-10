package solvedExercisesIvan.observerCounterSingleton;

import solvedExercisesIvan.counterSingleton.CounterSingleton;

/**
 * Created by pedro on 10/7/16.
 */
public class OctalObserver implements Observer {

    public OctalObserver() {
        CounterSingleton.getInstance().increment(1);
    }

    @Override
    public void update(int newState) {
        System.out.println( "Octal String: " + Integer.toOctalString(newState) );
    }
}
