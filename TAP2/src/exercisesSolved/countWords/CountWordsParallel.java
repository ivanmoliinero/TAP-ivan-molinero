package exercisesSolved.countWords;

import com.google.common.util.concurrent.AtomicLongMap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.concurrent.atomic.LongAdder;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CountWordsParallel {
    public static void main(String[] args) throws Exception {
        AtomicLongMap<String> result = AtomicLongMap.create();
        BufferedReader reader = new BufferedReader(new FileReader("src/exercisesSolved/countWords/enwik8.txt"));

        // First we will import the text into a List in order to work with it with streams.
        String line;
        Vector<String> words = new Vector<>();
        while((line = reader.readLine()) != null) {
            StringTokenizer tokens = new StringTokenizer(line, " "); // TODO: What about other symbols???
            while(tokens.hasMoreTokens()) {
                words.add(tokens.nextToken());
            }
        }

        reader.close();

        // Now we will perform a PARALLEL STREAM operation to group by words and count all the instances of each group.
        // Implemented with a custom collector in order to allow concurrent access. TODO: NOT ENOUGH SPEED !!!!
        System.out.println("Init of grouping by operation");
        long millis = System.currentTimeMillis();
        result = AtomicLongMap.create(words.stream().parallel()
                .collect(Collectors.groupingByConcurrent(String::toLowerCase,
                        new Collector<String, LongAdder, Long>() {

                            @Override
                            public Supplier<LongAdder> supplier() {
                                return LongAdder::new; // the supplier for each group of the groupBy will be an accumulator of each word encountered.
                            }

                            @Override
                            public BiConsumer<LongAdder, String> accumulator() {
                                return (LongAdder accum, String newElem) -> accum.add(1); // when given a string, add 1 into it.
                            }

                            @Override
                            public BinaryOperator<LongAdder> combiner() {
                                return (LongAdder l1, LongAdder l2) -> {
                                    l1.add(l2.longValue()); // put into l1 the quantity expressed by l2.
                                    return l1; // return l1 as the new adder to take into account.
                                };
                            }

                            @Override
                            public Function<LongAdder, Long> finisher() {
                                return LongAdder::longValue; // once everything is summed, return the long value.
                            }

                            @Override
                            public Set<Characteristics> characteristics() {
                                Set<Characteristics> chars = new HashSet<>();
                                chars.add(Characteristics.CONCURRENT);
                                return chars; // need to specify concurrency due to implementation of grouping by concurrent.
                            }
                        })));

        // Set an example
        System.out.println(result.get("el"));
        System.out.println("\nTotal time spent: " + (System.currentTimeMillis() - millis));

    }

}
