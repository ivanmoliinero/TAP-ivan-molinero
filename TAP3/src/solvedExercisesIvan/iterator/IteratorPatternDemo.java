package solvedExercisesIvan.iterator;

import java.util.Iterator;

/**
 * http://www.tutorialspoint.com/design_pattern/iterator_pattern.htm
 */
public class IteratorPatternDemo {

    public static void main(String[] args) {
        NameRepository namesRepository = new NameRepository();

        // for loop could be changed in order to adapt to the for-Each syntax of Iterable collections.
        for(Iterator<String> iter = namesRepository.iterator(); iter.hasNext();){
            String name = (String)iter.next();
            System.out.println("Name : " + name);
        }
    }
}
