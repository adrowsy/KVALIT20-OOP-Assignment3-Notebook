import java.util.Scanner;

/**
 * Project: OOP - Assignment 3
 * Inspired by the Bullet Journal method.
 * Learn more by visiting https://bulletjournal.com/pages/learn
 * Created by: Annika Rengfelt
 * Created:
 */
public class BulletJournal {

    public static final String DAYS = "by days";

    public static void main(String[] args) {

        //Welcome
        //Create new journal

        //Create bullets to journal
        //Save

        //Print bullets (journal)

        //Mark task as done
        //Migrate task
    }

    public static final int NEW = 1,
            MIG = 3, OPEN = 2;

    public static void options() {
        System.out.println("Here are your options");
        System.out.println(NEW + ": Create_new_log".toUpperCase());
        System.out.println(OPEN + ": Open_existing_log".toUpperCase());
        System.out.println(MIG + ": Migrate_from_file".toUpperCase());

        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter value: ");

        int choice = sc.nextInt();
        String input;
        if (choice == NEW) {
            System.out.print("Name log: ");
            input = sc.next(); //TODO: Tillåt blanksteg i namnet

            //Skapa log
            Journal j1 = new Journal(input);

            //Lägg till bullets
            System.out.println("Type your bullets. Save with End of file-command");


            System.out.print("Open log? [Y/N] \t");
            input = sc.next();
            if (input.equals("y")) {
                System.out.println(Message.OPEN);
                Journal.print(j1);

            }
        } else if (choice == OPEN) {

        } else
            options();
    }

    private static void journalOptions() {
        //TODO: Översätt string > Bullet[] namn
        //TODO: Överväg att lagra Bullets i textfil för enklare hantering
        //TODO: Write options for journal after display
        System.out.println("Journal Options");
        System.out.println("... Work in progress ...");
        options();

    }
}