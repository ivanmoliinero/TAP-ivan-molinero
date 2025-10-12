package solvedExercisesIvan.oberverList;

public interface Observer<T> {
    public void updateAdd(T elem);
    public void updateRemove(T elem);
}
