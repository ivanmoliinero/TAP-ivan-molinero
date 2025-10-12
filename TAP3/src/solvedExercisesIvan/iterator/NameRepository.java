package solvedExercisesIvan.iterator;

import java.util.Iterator; // new operator interface of java.util.

public class NameRepository implements Iterable<String> {
    public String[] names = {"Robert" , "John" ,"Julie" , "Lora"};

    @Override
    public Iterator<String> iterator() {
        return new NameIterator();
    }

    private class NameIterator implements Iterator<String> {

        int index = 0; // or define it in the constructor.

        @Override
        public boolean hasNext() {

            if(index < names.length){
                return true;
            }
            return false;
        }

        @Override
        public String next() {

            if(this.hasNext()){
                return names[index++];
            }
            return null;
        }
    }
}