package solvedExercisesIvan.oberverList;

import java.util.LinkedList;

public class BackupObserver<T> implements Observer<T>{
    private LinkedList<T> backup;

    public BackupObserver() {
        backup = new LinkedList<>();
    }

    @Override
    public void updateAdd(T elem) {
        backup.add(elem);
    }

    @Override
    public void updateRemove(T elem) {
        backup.remove(elem);
    }
}
