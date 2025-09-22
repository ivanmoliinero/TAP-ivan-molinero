package filterMethodImplementation;

import java.util.LinkedList;
import java.util.List;

public class UseFilter {
    public static void main(String[] args) throws Exception {
        List<String> developers = new LinkedList<>();

        developers.add("Eric");
        developers.add("Iván");
        developers.add("Javi");
        developers.add("Manolo");
        developers.add("Pedro");

        System.out.println(FilterClass.filter(developers, (String elem) -> elem.charAt(0) == 'I'));

        // filter pedido en clase
        List<Integer> elems = new LinkedList<>();
        elems.add(1);
        elems.add(2);
        elems.add(3);
        elems.add(4);
        elems.add(5);

        System.out.println(FilterClass.filter(elems, (Integer i) -> i % 2 != 0));
    }

}
