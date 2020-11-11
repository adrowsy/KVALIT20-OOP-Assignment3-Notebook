import java.util.Scanner;

/**
 * Project: Assignment 3
 * Created by: Annika Rengfelt
 * Due: 2020-11-11
 */

public class Main {

    //Constant values used for guiding user and presenting user choice
    public static final String OPEN = "1";
    public static final String IMPORT = "2";
    public static final String DONE = "3";
    public static final String EXIT = "x";

    /**
     * The Main method allows user to enter choice, do an operation, and then return to list of alternatives
     */
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
                case IMPORT -> {
                    Notebook.importFromFile(notebook, "galilei.txt");
                    System.out.println(notebook);
                }
                case DONE -> {
                    //Present journal with index
                    boolean emptyNotebook = notebook.printWithIndex();

                    if (!emptyNotebook) { //Check if notebook is empty
                        //Allow user to enter value of completed tasks
                        System.out.print("What did you complete?\n".toUpperCase()
                                + Note.SYMBOLS[Note.INFO] + "Enter [row] to mark as done:");
                        try {
                            Scanner mark = new Scanner(System.in);
                            while (mark.hasNextInt()) { //Allow user to complete more tasks
                                notebook.setDone(mark.nextInt() - 1);
                                System.out.print("Did you do something else?\n".toUpperCase()
                                        + Note.SYMBOLS[Note.INFO] + "Enter [row] or any non-numeric key to exit: ");
                            }
                        } catch (Exception e) {
                            System.out.print("Error: " + e);
                        }
                    }
                }
            }
        } while (true);
    }
}
