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
    }

}
