package exercisesSolved.map2;


import map2.Imap;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

public class Map {

    public static <T, R> List<R> map(List<T> list, Function<T, R> function) {
        List<R> result = new LinkedList<R>();
        for (T elem : list)
            result.add(function.apply(elem));
        return result;

    }

}
