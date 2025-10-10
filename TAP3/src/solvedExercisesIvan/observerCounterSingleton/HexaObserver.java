package solvedExercisesIvan.observerCounterSingleton;

import solvedExercisesIvan.counterSingleton.CounterSingleton;

/**
 * Created by pedro on 10/7/16.
 */
public class HexaObserver implements Observer {

    public HexaObserver() {
        CounterSingleton.getInstance().increment(1);
    }

    @Override
    public void update(int newState) {
        System.out.println( "Hex String: " + Integer.toHexString( newState ).toUpperCase() );
    }
}