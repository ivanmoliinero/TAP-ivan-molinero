package exercisesSolved.countWords;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

public class CountWords {
    public static void main(String[] args) throws Exception {
        Map<String, Long> result = new HashMap<>();
        BufferedReader reader = new BufferedReader(new FileReader("src/exercisesSolved/countWords/enwik8.txt"));

        // First we will import the text into a List in order to work with it with streams.
        String line;
        List<String> words = new LinkedList<>();
        while((line = reader.readLine()) != null) {
            StringTokenizer tokens = new StringTokenizer(line, " "); // TODO: What about other symbols???
            while(tokens.hasMoreTokens()) {
                words.add(tokens.nextToken());
            }
        }

        reader.close();
        
        // Now we will perform a Stream operation to group by words and count all the instances of each group.
        System.out.println("Init of grouping by operation");
        long millis = System.currentTimeMillis();
        result = words.stream()
                .collect(Collectors.groupingBy(String::toLowerCase,
                        Collectors.counting()));

        // Set an example
        System.out.println(result.get("el"));
        System.out.println("\nTotal time spent: " + (System.currentTimeMillis() - millis));

    }

}
