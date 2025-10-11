package solvedExercisesIvan.filesystem2;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public class File implements SystemComponent {
    private String name;
    private SystemComponent father;

    public File(String name) {
        this.name = name;
    }


    @Override
    public String ls() {
        return name + "\n";
    }

    @Override
    public List<String> collect() {
        LinkedList<String> list = new LinkedList<>();
        list.add(name);
        return list;
    }

    @Override
    public List<SystemComponent> toList() {
        LinkedList<SystemComponent> list = new LinkedList<>();
        list.add(this);
        return list;
    }

    @Override
    public List<SystemComponent> search(String name) {
        if(this.name.equals(name)) {
            LinkedList<SystemComponent> list = new LinkedList<>();
            list.add(this);
            return list;
        }

        return Collections.emptyList();
    }

    @Override
    public List<SystemComponent> search(Predicate<SystemComponent> op) {
        if(op.test(this)) {
            LinkedList<SystemComponent> list = new LinkedList<>();
            list.add(this);
            return list;
        }

        return Collections.emptyList();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void addFather(SystemComponent father) {
        this.father = father;
    }

    public String toString() {
        return father + "/" + name;
    }

}
