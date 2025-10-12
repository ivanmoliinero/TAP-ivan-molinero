package solvedExercisesIvan.oberverList;

public class Main {
    public static void main(String[] args) {
        ObserverList<String> names = new ObserverList<>();
        PrintObserver<String> test = new PrintObserver<>();
        names.subscribe(test);
        names.subscribe(new BackupObserver<>());

        try {
            names.subscribe(test);
        } catch (AlreadyExistsObserver e) {
            System.out.println("Exception catched succesfully, continuing normally, element not added.");
        }

        names.add("IVÁN");
        names.add("ERIC");
        names.add("JAVI");
        names.add("PEDRO");

        names.remove("IVÁN");
    }
}
