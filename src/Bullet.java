import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Project:
 * Created by: Annika Rengfelt
 * Created:
 */
public class Bullet {
//TODO Dokumentera

    //Konstant värde för hur många bullets som kan sparas i array
    public static final int BULLETS_MAX = 200;

    //Instansvariabler
    //TODO: Lägg till String date;
    int type; // TASK = 1, EVENT = 2, NOTE = 3
    String description;
    int weekday;

    //Konstanter för type och utskrift
    public static final int
            TASK = 1, EVENT = 2, NOTE = 3;
    public static final int
            MON = 1, TUE = 2, WED = 3, THUR = 4, FRI = 5, SAT = 6, SUN = 7;
    public static final String[] TASK_SYMBOL = {null, "[*]", "[o]", "[-]"};
    public static final String[] WEEKDAYS = {null, "monday", "tuesday", "wed", "thur", "fri", "sat", "sun"};


    /**
     * Klassmetod för att skriva ut Bullet
     *
     * @param b Bullet
     */
    public static void display(Bullet b) {
        System.out.println(TASK_SYMBOL[b.type] + " " + b.description + " @ " + WEEKDAYS[b.weekday]);
    }

    /**
     * Klassmetod för att skapa Bullet
     *
     * @param type
     * @param description
     * @param weekday
     * @return b bullet
     */
    public static Bullet log(int type, String description, int weekday) {
        Bullet b = new Bullet();
        b.type = type;
        b.description = description;
        b.weekday = weekday;
        return b;
    }

    /**
     * Klassmetod för att skapa Bullet från String
     *
     * @param s Sträng enligt format type description weekday
     * @return b bullet
     */
    public static Bullet log(String s) {
        Bullet b = new Bullet();
        b.type = Integer.parseInt(s.substring(0, s.indexOf(' ')));
        b.description = s.substring((s.indexOf(' ') + 1), s.lastIndexOf(' '));
        b.weekday = Integer.parseInt(s.substring(s.lastIndexOf(' ') + 1));
        return b;
    }

    public static void log(String fileName, Bullet[] log, int i) throws FileNotFoundException {
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
                log[i] = b;
                i++;
                row++;
                if (i == log.length) {
                    System.out.print("### WARNING: Not enough memory in " + b + ". Last successful entry @ row #" + row + ": ");
                    Bullet.display(log[i - 1]);
                    break;
                }
            }
            System.out.println("*** SUCCESSFULLY ADDED " + row + " BULLETS FROM [" + fileName + "] *** ");
        } catch (Exception e) {
            System.out.println("### ERROR: Character out of place on row #" + row + " or immediately after. Please revise [" + fileName + "]");
        }
    }

    /**
     * Klassmetod för att skriva alla bullets som inte är tomma
     *
     * @param log vilken array som skrivs
     */
    public static void display(Bullet[] log) {
        //Printing all non empty bullets
        System.out.println("*** PRINTING LOG: " + log + " ***");
        for (int j = 0; j < log.length; j++) {
            if ((log[j].type == 0) && (log[j].description == null)) ;
            else display(log[j]);
        }
        System.out.println("*** END OF LOG");
    }
}
