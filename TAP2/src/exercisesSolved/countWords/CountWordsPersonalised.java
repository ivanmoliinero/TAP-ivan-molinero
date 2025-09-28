package exercisesSolved.countWords;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CountWordsPersonalised {
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
        // Note that for this exercise I will not use any given Collectors implementation, meaning that
        // a new GroupBy will be implemented from scratch with an anonymous class of the Collector interface.
        System.out.println("Init of grouping by operation");
        long millis = System.currentTimeMillis();
        result = words.stream()
                .collect(new Collector<String, HashMap<String, Long>, Map<String, Long>>() {
                    @Override
                    public Supplier<HashMap<String, Long>> supplier() {
                        return HashMap::new; // creation of the container that will include all our data.
                    }

                    @Override
                    public BiConsumer<HashMap<String, Long>, String> accumulator() {
                        return (HashMap<String, Long> hm, String newWord) -> {
                            newWord = newWord.toLowerCase();
                           if (!hm.containsKey(newWord)) {
                               // the string was not added to the hashmap, therefore we will initialise it.
                               hm.put(newWord, 1L);
                           } else {
                               hm.put(newWord, hm.get(newWord) + 1L);
                           }
                        };
                    }

                    @Override
                    public BinaryOperator<HashMap<String, Long>> combiner() {
                        // NOT USED IN SEQUENTIAL IMPLEMENTATION!!!!!
                        return (HashMap<String, Long> hm1, HashMap<String, Long> hm2) -> {
                            hm1.forEach((String s, Long l) -> {
                                s = s.toLowerCase();
                                if(hm2.containsKey(s)) {
                                    // put all does NOT merge the contents of the second hashmap,
                                    // it just replaces it. To avoid this, we will need to
                                    // combine the entries manually.
                                    hm1.put(s, l + hm2.get(s));
                                }
                                else {
                                    hm1.put(s, l); // if the value is not into the first hashmap, just put it in.
                                }
                            });
                            return hm1;
                        };
                    }

                    @Override
                    public Function<HashMap<String, Long>, Map<String, Long>> finisher() {
                        return (HashMap<String, Long> hm) -> hm;
                    }

                    @Override
                    public Set<Characteristics> characteristics() {
                        return Collections.emptySet(); // not important in this case for an anonymous class, it won't be needed by any method.
                    }
                });

        // Set an example
        System.out.println(result.get("el"));
        System.out.println("\nTotal time spent: " + (System.currentTimeMillis() - millis));

    }

}
