package functional;

import java.util.stream.IntStream;

/**
 * Created by pedro on 9/20/17.
 */
public class TestParallel {

    public static void main (String[] args) {

        long start = System.currentTimeMillis();

        /* PARALLEL EXECUTION */
        IntStream s = IntStream.range(0, 20);
     //   System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "20");
        s.parallel().forEach(i -> {
            try {
                Thread.sleep(100);
            } catch (Exception ignore) {
            }
            System.out.println((System.currentTimeMillis() - start) + ": Thread num " + i);
        });

        System.out.println("\n------------");

        /* SEQUENTIAL EXECUTION */
        IntStream s2 = IntStream.range(0, 20);
        s2.forEach(i -> {
            try {
                Thread.sleep(100);
            } catch (Exception ignore) {
            }
            System.out.println((System.currentTimeMillis() - start) + ": Thread num " + i);
        });

    }
}
