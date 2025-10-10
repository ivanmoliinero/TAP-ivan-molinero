package solvedExercisesIvan.observerCounterSingleton;

/**
 * Created by pedro on 10/7/16.
 */
@FunctionalInterface
 interface Observer {
     void update(int newValue);
}