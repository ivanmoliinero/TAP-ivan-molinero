package solvedExercisesIvan.oberverList;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ObserverList<T> implements Iterable<T> {
    private LinkedList<T> list;
    private List<Observer<T>> subscriptors;

    public ObserverList() {
        list = new LinkedList<>();
        subscriptors = new LinkedList<>();
    }

    public void subscribe(Observer<T> obs) throws AlreadyExistsObserver {
        if(subscriptors.contains(obs))
            throw new AlreadyExistsObserver(obs);
        subscriptors.add(obs);
    }

    public void unSubscribe(Observer<T> obs) {
        subscriptors.remove(obs);
    }

    public void add(T elem) {
        list.add(elem);
        notifyAdd(elem);
    }

    public void remove(T elem) {
        list.remove(elem);
        notifyRemove(elem);
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }

    public void notifyAdd(T elem) {
        for(Observer<T> subs : subscriptors)
            subs.updateAdd(elem);
    }
    public void notifyRemove(T elem) {
        for(Observer<T> subs : subscriptors)
            subs.updateRemove(elem);
    }
}
