package solvedExercisesIvan.filesystem;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class File implements SystemComponent {
    @Override
    public String ls() {
        return "";
    }

    @Override
    public List<String> collect() {
        return Collections.emptyList();
    }

    @Override
    public List<SystemComponent> toList() {
        return Collections.emptyList();
    }

    @Override
    public List<SystemComponent> search(String name) {
        return Collections.emptyList();
    }

    @Override
    public List<SystemComponent> search(Predicate<SystemComponent> op) {
        return Collections.emptyList();
    }
}
