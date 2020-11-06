import java.util.Scanner;

/**
 * Project:
 * Created by: Annika Rengfelt
 * Created:
 */
public class Journal {

    //Egenskaper hos Journal
    private Bullet[] log;
    private String name;

    //Tom konstruktor
    Journal() {
    }

    Journal(String name) {
        setTitle(name);
        System.out.println(Message.ADDED + "New journal " + name);
    }

    /**
     * Change journal name
     *
     * @param newName
     */
    public void setTitle(String newName) {
        this.name = newName;
    }

    /**
     * En klassmetod som skriver ut alla bullets i en log
     *
     * @param j
     */
    public static void print(Journal j) {
        try {
            for (Bullet b : j.log)
                b.toString();
        } catch (Exception e) {
            System.out.println(Message.EMPTY_LOG);
        }
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
            Journal j1 = Journal.getInstance(input);

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