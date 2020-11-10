import javax.xml.transform.Source;
import java.io.InputStream;
import java.sql.SQLOutput;
import java.util.Scanner;

/**
 * Project: Assignment 3
 * Created by: Annika Rengfelt
 * Due: 2020-11-11
 */

public class Main {

    public static final String OPEN = "1";
    public static final String IMPORT = "2";
    public static final String DONE = "3";
    public static final String CLEAR = "4";
    public static final String EXIT = "x";

    public static void main(String[] args) throws Exception {

        String userDescription;
        String userChoice = "";
        Scanner scanner;
        Notebook notebook = Notebook.getInstance(100);

        System.out.println("Welcome. These are your options".toUpperCase());

        do {
            System.out.println("[" + OPEN + "] " + "Open notebook".toUpperCase());
            System.out.println("[" + IMPORT + "] " + "Import tasks from file".toUpperCase());
            System.out.println("[" + DONE + "] " + "Mark tasks as completed".toUpperCase());
            System.out.println("[" + CLEAR + "] " + "Erase all entries".toUpperCase());
            System.out.println("[" + EXIT + "] " + "Exit program".toUpperCase());
            System.out.print("Your choice: ".toUpperCase());

            scanner = new Scanner(System.in);
            userChoice = scanner.next().toLowerCase();

            switch (userChoice) {
                case EXIT -> {
                    System.out.println("Bye bye!");
                    System.exit(0);
                }
                case OPEN -> {
                    System.out.println(notebook);
                }
                case CLEAR -> {
                    Notebook.erase(notebook);
                }
                case IMPORT -> {
                    Notebook.importFromFile(notebook, "galilei.txt");
                    System.out.println(notebook);
                }
                case DONE -> {
                    //Presentera journalen med index
                    boolean emptyNotebook = notebook.printWithIndex();

                    if (!emptyNotebook) { //Klarmarkera bara om anteckningsboken inte är tom
                        //Markera index som ska klarmarkeras
                        System.out.print("What did you complete?\n".toUpperCase()
                                + Note.SYMBOLS[Note.INFO] + "Enter [row] to mark as done:");
                        try {
                            Scanner mark = new Scanner(System.in);
                            while (mark.hasNextInt()) {
                                notebook.setDone(mark.nextInt() - 1);
                                System.out.print("Did you do something else?\n".toUpperCase()
                                        + Note.SYMBOLS[Note.INFO] + "Enter [row] or any non-numeric key to exit: ");
                            }
                        } catch (Exception e) {
                            System.out.printf("Error: " + e);
                        }
                    }
                }
            }
        } while (true);
    }

}
