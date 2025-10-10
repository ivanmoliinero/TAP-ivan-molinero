package solvedExercisesIvan.counterSingleton;

public class CounterSingleton {
    private static CounterSingleton counter; // the global variable

    private int number;

    // Private constructor so as not to allow the liberal creation
    // of this instance.
    private CounterSingleton() {
        number = 0;
    }

    public static CounterSingleton getInstance() {
        if(counter == null)                     // if no instance has been required up to this point ...
            counter = new CounterSingleton();   // ... generate the global instance ...
        return counter;                         // and return the instance.
    }

    public void increment(int byMuch) {
        number += byMuch;
    }

    public void decrement(int byMuch) {
        number -= byMuch;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

}
