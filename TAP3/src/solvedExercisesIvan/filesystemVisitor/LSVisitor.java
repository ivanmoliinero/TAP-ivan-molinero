package solvedExercisesIvan.filesystemVisitor;

import java.util.Collections;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class LSVisitor implements FileSystemVisitor<String> {
    private StringBuilder intermediate;
    private String finalRes;

    @Override
    public void visit(Directory dir) {
        LSVisitor thisInst = this;
        intermediate = new StringBuilder();
        finalRes = dir.getSubComponents().stream().collect(new Collector<SystemComponent, StringBuilder, String>() {
            @Override
            public Supplier<StringBuilder> supplier() {
                return StringBuilder::new;
            }

            @Override
            public BiConsumer<StringBuilder, SystemComponent> accumulator() {
                return (StringBuilder accum, SystemComponent newElem) -> {
                    newElem.accept(thisInst);
                    accum.append(intermediate);
                    intermediate = new StringBuilder(); // for the next string.
                };
            }

            @Override
            public BinaryOperator<StringBuilder> combiner() {
                return null;
            }

            @Override
            public Function<StringBuilder, String> finisher() {
                return (result) -> {
                    String res = result.toString() + dir.getName() + "\n";
                    // before returning, we append the entry to the intermediate in order to generate the result ffor the directory.
                    intermediate = result;
                    intermediate.append(dir.getName()).append("\n");
                    return res;
                };
            }

            @Override
            public Set<Characteristics> characteristics() {
                return Collections.emptySet();
            }
        });
    }

    @Override
    public void visit(File file) {
        intermediate.append(file.getName()).append("\n");
    }

    public String getResult() {
        return finalRes;
    }
}
