import java.io.*;
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
     * Instansmetod som döper journalen
     *
     * @param name döp loggen
     */
    public void setTitle(String name) {
        this.name = name;
    }

    /**
     * Klassmetod som skapar en "tom" journal
     * (journalen innehåller en array av bullets där alla komponenter är null
     *
     * @return en journal (en instans av klassen Journal)
     */
    public static Journal createJournal(String name) {
        Journal journal = new Journal();
        journal.name = name;
        System.out.println(Message.ADDED + "New journal " + journal);
        return journal;
    }

    /**
     * En klassmetod som skriver ut alla bullets i en log
     *
     * @param j
     */
    public static void print(Journal j) {
        try {
            for (Bullet bullet : j.log)
                Bullet.print(bullet);
        } catch (Exception e) {
            System.out.println(Message.EMPTY_LOG);
        }
    }


    /**
     * Log one bullet from input
     *
     * @param type    task, event or note
     * @param weekday what day
     * @param log     where to write
     */

    public static void log(int type, String description, int weekday, Bullet[] log) {
        boolean emptySpot = false;
        int firstEmpty = 0;
        //Look at the log and see if there is an empty space
        for (int i = 0; i < log.length; i++) {
            //Save log to first empty space
            if (log[i].description == null) {
                emptySpot = true;
                firstEmpty = i;

                if (emptySpot) {
                    log[i].type = type;
                    log[i].description = description;
                    log[i].weekday = weekday;
                    System.out.println(Message.ADDED + "1 bullet on row " + (i + 1));
                    break;
                }
            }
        }
        if (!emptySpot) System.out.println(Message.ERROR + "Log is full.");
    }


    /**
     * Log one bullet from input
     *
     * @param input string
     * @param log   where to write
     */

    public static void log(String input, Bullet[] log) {
        boolean emptySpot = false;
        int firstEmpty = 0;
        //Look at the log and see if there is an empty space
        for (int i = 0; i < log.length; i++) {
            //Save log to first empty space
            if (log[i].description == null) {
                emptySpot = true;
                firstEmpty = i;

                if (emptySpot) {
                    log[i].type = Integer.parseInt(input.substring(0, input.indexOf(' ')));
                    log[i].description = input.substring((input.indexOf(' ') + 1), input.lastIndexOf(' '));
                    log[i].weekday = Integer.parseInt(input.substring(input.lastIndexOf(' ') + 1));
                    System.out.println(Message.ADDED + "1 bullet on row " + (i + 1));
                    break;
                }
            }
        }
        if (!emptySpot) System.out.println(Message.ERROR + "Log is full.");
    }




    /**
     * Logging from file
     *
     * @param fileName
     * @param log        to recieve bullets
     * @param beginIndex where in log to start typing
     * @throws FileNotFoundException if no file
     */
    public static void log(String fileName, Bullet[] log, int beginIndex) throws FileNotFoundException {


        Scanner file = new Scanner(new File(fileName));
        int row = 0;
        try {
            while (file.hasNextLine()) {
                Bullet b = new Bullet();
                b.type = file.nextInt();
                b.description = file.next();
                while (!file.hasNextInt()) {
                    b.description += " " + file.next();
                }
                b.weekday = file.nextInt();
                log[beginIndex] = b;
                beginIndex++;
                row++;
                if (beginIndex == log.length) {
                    System.out.print(Message.WARNING + "Not enough memory in " + b + ". Last successful entry @ row #" + row + ": ");
                    Bullet.print(log[beginIndex - 1]);
                    break;
                }
            }
            System.out.println(Message.ADDED + row + " bullets from [" + fileName + "]");
        } catch (Exception e) {
            System.out.println(Message.ERROR + "Character out of place on row #" + row + " or immediately after. Please revise [" + fileName + "]");
        }
    }


    /**
     * Display full log. Bullets appear in default order
     *
     * @param log to display
     */
    public static void display(Bullet[] log) {
        int emptyIndex = 0;
        System.out.println(Message.PRINT + log);
        for (int j = 0; j < log.length; j++) {
            if ((log[j].type != 0) && (log[j].description != null)) {
                Bullet.print(log[j]); //Printing all non empty bullets
            } else emptyIndex++;

            if (emptyIndex >= log.length) System.out.println(Message.EMPTY_LOG);
        }
        System.out.println(Message.EOP);

    }

    public static void display(Bullet[] log, String sorted) {
        System.out.println(Message.PRINT + log + " " + sorted);

        if (sorted == JournalDemo.DAYS) {
            for (int weekday = 0; weekday < Bullet.DESCRIPTION.length; weekday++) {
                for (int j = 0; j < log.length; j++) {
                    if ((log[j].type != 0) && (log[j].description != null) && (log[j].weekday == weekday))
                        Bullet.print(log[j]); //Printing all non empty bullets
                }
            }
        }
        if (sorted == JournalDemo.TYPE) {
            for (int type = 0; type < Bullet.DESCRIPTION.length; type++) {
                for (int j = 0; j < log.length; j++) {
                    if ((log[j].type != 0) && (log[j].description != null) && (log[j].type == type))
                        Bullet.print(log[j]);
                }
            }
        }
        System.out.println(Message.EOP);
    }

    public static void display(int filter, Bullet[] log) {
        System.out.println(Message.PRINT + log + " only showing " + Bullet.DESCRIPTION[filter]);

        if (filter == Bullet.TASK) {
            for (int j = 0; j < log.length; j++) {
                if ((log[j].type != 0) && (log[j].description != null) && (log[j].type == filter))
                    Bullet.print(log[j]);
            }
        } else
            for (int j = 0; j < log.length; j++) {
                if ((log[j].description != null) && (log[j].weekday == filter))
                    Bullet.print(log[j]); //Printing all non empty bullets
            }
        System.out.println(Message.EOP);
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
            Journal j1 = Journal.createJournal(input);

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