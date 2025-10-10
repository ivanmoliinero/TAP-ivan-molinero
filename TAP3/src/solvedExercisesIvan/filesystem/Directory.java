package solvedExercisesIvan.filesystem;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public class Directory implements SystemComponent {
    private List<SystemComponent> subComponents; // no matter if they are files or directories.

    public Directory() {
        subComponents = new LinkedList<>();
    }

    @Override
    public String ls() {
        subComponents.stream().reduce("", (String result, SystemComponent next) -> result + next.ls());
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
