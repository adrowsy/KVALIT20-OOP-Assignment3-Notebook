import java.util.Scanner;

/**
 * Project: OOP - Assignment 3
 * Inspired by the Bullet Journal method.
 * Learn more by visiting https://bulletjournal.com/pages/learn
 * Created by: Annika Rengfelt
 * Submitted: 2020-11-11
 */

public class BulletJournal {

    public static final String DAYS = "by days";
    public static final int NEW = 1, OPEN = 2;

    public static void main(String[] args) {

        int choice;

        //showOptions();

        //Användaren vill skapa en ny journal
        choice = NEW;
        if (choice == NEW) {
            //Skapa ny journal
            Journal j1 = new Journal();
            //Låt användaren döpa journalen
            //Scanner name = new Scanner(System.in);
            String name = "Annikas_Journal"; //Testkod
            System.out.print("Enter name of new journal: ".toUpperCase());
            j1.setName(name);

            //Skriv bullets
            //Öppna en ny scanner för bullets
            Scanner userInput = new Scanner(System.in);
            while (userInput.hasNext()) {
                String bullet = userInput.nextLine();
                j1.setBullet(bullet);
            }

            //--> open journal
            //Skriv ut när input är klar
            j1.toString();

            //Användaren vill öppna befintlig journal
        } else if (choice == OPEN) {

            //Låt användaren skriva vilken journal som ska öppnas
            System.out.print("What log do you want to open? Enter name of log: ");

            //Scanner name = new Scanner(System.in);
            String name = "Annikas_Journal"; //Testkod

            //Bläddra bland journals
            //Skriv ut den som har samma namn som vad användaren skrev

        } else ;


        //Create bullets to journal

        //Save

        //Print bullets (journal)

        //Mark task as done
        //Migrate task


        //Lägg till bullets
        //System.out.println("Type your bullets. Save with End of file-command");
    }

    public static void showOptions() {
        //Welcome
        System.out.println("Welcome to " + Message.NAME + " - " + Message.TAGLINE);
        //Present options to user
        System.out.println("Available options".toUpperCase());
        System.out.println(NEW + ": Create_new_log".toUpperCase());
        System.out.println(OPEN + ": Open_existing_log".toUpperCase());
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter choice: ".toUpperCase());
        int choice;
        choice = sc.nextInt();
    }
}