package exercisesSolved.countWords;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountWordsParallelFromFileDirect {
    public static void main(String[] args) {
        Map<String, Long> result = new HashMap<>();
        long millis = System.currentTimeMillis();
        try(Stream<String> lines = Files.lines(Paths.get("src/exercisesSolved/countWords/enwik8.txt"))) {
            result = lines.parallel()
                    .flatMap(l -> Arrays.stream(l.split("[\\s]+")))
                    .collect(Collectors.groupingByConcurrent(String::toLowerCase, Collectors.counting()));
            System.out.println("\n\nTIME: " + (System.currentTimeMillis() - millis));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
