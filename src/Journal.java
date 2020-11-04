import java.util.Scanner;

/**
 * Project:
 * Created by: Annika Rengfelt
 * Created:
 */
public class Journal {

    /**
     * journal är en instansvariabel som lagrar ett godtyckligt antal bullets
     */
    Bullet[] log; //Varje instans av journal har en logg som är en bulletarray
    String name; //Varje instans av journal har också en titel

    /**
     * Klassmetod som skapar en "tom" journal
     * (journalen innehåller en array av bullets där alla komponenter är null
     *
     * @return en journal (en instans av klassen Journal)
     */
    public static Journal getInstance(String name) {
        Journal journal = new Journal();
        journal.name = name;
        System.out.println(Message.ADDED + "New journal " + journal);
        return journal;
    }

    /**
     * Instansmetod som döper journalen
     *
     * @param name döp loggen
     */
    public void setTitle(String name) {
        this.name = name;
    }

    /**
     * En klassmetod som skriver ut alla bullets i en log
     *
     * @param j
     */
    public static void print(Journal j) {
        try {
            for (Bullet b : j.log)
                Bullet.print(b);
        } catch (Exception e) {
            System.out.println(Message.EMPTY_LOG);
        }
    }

    public static void print(Journal j, String sorted) {
        System.out.println(Message.PRINT + j + " " + sorted);

        if (sorted == JournalDemo.DAYS) {
            for (int weekday = 1; weekday < Bullet.WEEKDAYS.length; weekday++) {
                try {
                    for (Bullet b : j.log) {
                        if (b.weekday == weekday)
                            Bullet.print(b);
                    }
                } catch (Exception e) {
                    //System.out.println("No posts for " + Bullet.WEEKDAYS[weekday]);
                }
            }
            System.out.println(Message.EOP);
        }
        if (sorted == JournalDemo.TYPE) {
            for (int type = 1; type <= Bullet.TYPES.length; type++) {
                try {
                    for (Bullet b : j.log) {
                        if (b.type == type)
                            Bullet.print(b);
                    }
                } catch (Exception e) {
                }
            }
            System.out.println(Message.EOP);
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

    @Override
    public String toString() {
        return name + "";
    }
}