package solvedExercisesIvan.filesystemVisitor;

// interface of operations each node (whether it is a middle node or a leaf)
// will have to implement in order to treat them equally with recursion and DFS.
public interface SystemComponent {
//    public String ls();
//    public List<String> collect();
//    public List<SystemComponent> toList();
//    public List<SystemComponent> search(String name);
//    public List<SystemComponent> search(Predicate<SystemComponent> op);
//    public String toString();

    public void accept(FileSystemVisitor vis);

    public String getName();
}
