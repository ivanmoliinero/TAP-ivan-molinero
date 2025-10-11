package solvedExercisesIvan.filesystem;

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

        // System.out.println(home.ls());
        // System.out.println(home.collect());
        // System.out.println(home.toList());
        // System.out.println(home.search("paper2.pdf"));
        // System.out.println(home.search((elem) -> elem.getName().equals("general_notes.txt")));
        System.out.println(paper2);
    }
}
