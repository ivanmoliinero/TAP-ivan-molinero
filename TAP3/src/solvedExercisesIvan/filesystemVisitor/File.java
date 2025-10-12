package solvedExercisesIvan.filesystemVisitor;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public class File implements SystemComponent {
    private String name;
    private SystemComponent father;

    public File(String name, SystemComponent father) {
        this.name = name;
        this.father = father;
    }

    public List<String> collect() {
        LinkedList<String> list = new LinkedList<>();
        list.add(name);
        return list;
    }

    public List<SystemComponent> toList() {
        LinkedList<SystemComponent> list = new LinkedList<>();
        list.add(this);
        return list;
    }

    public List<SystemComponent> search(String name) {
        if(this.name.equals(name)) {
            LinkedList<SystemComponent> list = new LinkedList<>();
            list.add(this);
            return list;
        }

        return Collections.emptyList();
    }

    public List<SystemComponent> search(Predicate<SystemComponent> op) {
        if(op.test(this)) {
            LinkedList<SystemComponent> list = new LinkedList<>();
            list.add(this);
            return list;
        }

        return Collections.emptyList();
    }

    @Override
    public void accept(FileSystemVisitor vis) {
        vis.visit(this);
    }

    @Override
    public String getName() {
        return name;
    }

    public String toString() {
        return father + "/" + name;
    }

}
