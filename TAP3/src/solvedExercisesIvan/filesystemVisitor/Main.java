package solvedExercisesIvan.filesystemVisitor;


// this package is a modification of the solvedExercisesIvan.filesystem package.
// it does not add new functionalities to the solvedExercisesIvna.filesystem2 package.

// TODO: FINISH THE CODE FOR THE REST, WITH COLLECT OR NORMALLY!!!!
public class Main {
    public static void main(String[] args) {
        // Create a simple structure of directories.
        Directory home = new Directory("home", null);
        Directory datosUni = new Directory("DatosUni", home);
        Directory thirdYear = new Directory("3r_curso", datosUni);
        File config = new File("cofiguration.config", home);
        File generalNotes = new File("general_notes.txt", datosUni);
        File paper = new File("paper.pdf", thirdYear);
        File paper2 = new File("paper2.pdf", thirdYear);

        home.addComponent(datosUni);
        home.addComponent(config);
        datosUni.addComponent(thirdYear);
        datosUni.addComponent(generalNotes);
        thirdYear.addComponent(paper);
        thirdYear.addComponent(paper2);

        FileSystemVisitor<String> vist = new LSVisitor();
        home.accept(vist);
        System.out.println(vist.getResult());
    }
}
