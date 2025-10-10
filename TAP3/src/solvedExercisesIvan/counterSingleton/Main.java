package solvedExercisesIvan.counterSingleton;

public class Main {
    public static void main(String[] args) {
        CounterSingleton counter1 = CounterSingleton.getInstance();
        counter1.increment(10);
        System.out.println(counter1);

        CounterSingleton counter2 = CounterSingleton.getInstance();
        counter2.decrement(15);
        System.out.println(counter1);
    }
}
