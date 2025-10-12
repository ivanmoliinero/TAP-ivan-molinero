package solvedExercisesIvan.filesystemVisitor;

public interface FileSystemVisitor<R> {
    public void visit(Directory dir);
    public void visit(File file);
    public R getResult();
}
