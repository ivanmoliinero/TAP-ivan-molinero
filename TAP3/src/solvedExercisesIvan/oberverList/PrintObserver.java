package solvedExercisesIvan.oberverList;

public class PrintObserver<T> implements Observer<T>{

    @Override
    public void updateAdd(T elem) {
        System.out.println(elem + " -- ADDED.");
    }

    @Override
    public void updateRemove(T elem) {
        System.out.println(elem + " -- REMOVED.");
    }
}
