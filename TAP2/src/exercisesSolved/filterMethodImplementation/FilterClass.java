package exercisesSolved.filterMethodImplementation;

import java.util.LinkedList;
import java.util.function.Predicate;
import java.util.List;

public class FilterClass {
    public static <T> List<T> filter(List<T> dataStr, Predicate<T> filter) {
        List<T> newList = new LinkedList<>();
        for(T elem : dataStr) {
            if(filter.test(elem))
                newList.add(elem);
        }

        return newList;
    }
}
