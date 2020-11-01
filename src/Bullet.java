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
     * Log one bullet from string entry
     *
     * @param s Log (type description weekday)
     * @return b bullet
     */
    public static Bullet log(String s) {
        Bullet b = new Bullet();
        b.type = Integer.parseInt(s.substring(0, s.indexOf(' ')));
        b.description = s.substring((s.indexOf(' ') + 1), s.lastIndexOf(' '));
        b.weekday = Integer.parseInt(s.substring(s.lastIndexOf(' ') + 1));
        return b;
    }

    /**
     * Log one bullet from comma separated values
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
     * Logging from file
     *
     * @param fileName
     * @param log      to recieve bullets
     * @param i        where in log to start typing
     * @throws FileNotFoundException
     */
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
     * Display one bullet
     *
     * @param b Bullet
     */
    public static void display(Bullet b) {
        System.out.println(TASK_SYMBOL[b.type] + " " + b.description + " @ " + WEEKDAYS[b.weekday]);
    }

    /**
     * Display full log. Bullets appear in the order they were written
     *
     * @param log to display
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

    /**
     * Deleting one bullet entry by resetting values to null
     *
     * @param log
     * @param bullet to b cleared
     */
    public static void clear(Bullet[] log, int bullet) {
        log[bullet].type = 0;
        log[bullet].description = null;
        log[bullet].weekday = 0;

        System.out.println("*** SUCCESSFULLY CLEARED BULLET FROM [" + log + "] *** ");
    }

    /**
     * Deleting range of bullet entries by resetting values to null
     *
     * @param log
     * @param firstBullet to b cleared
     * @param lastBullet  to be cleared
     */
    public static void clear(Bullet[] log, int firstBullet, int lastBullet) {
        for (int j = firstBullet; j <= lastBullet; j++) {
            log[j].type = 0;
            log[j].description = null;
            log[j].weekday = 0;
        }
        System.out.println("*** SUCCESSFULLY CLEARED " + (lastBullet - firstBullet) + " BULLETS FROM [" + log + "] *** ");
    }

    /**
     * Deleting all bullets in one log by resetting values to null
     *
     * @param log
     */
    public static void clear(Bullet[] log) {
        //TODO: Warning message and corfirmation if used in interface

        for (int j = 0; j < log.length; j++) {
            log[j].type = 0;
            log[j].description = null;
            log[j].weekday = 0;
        }
        System.out.println("*** SUCCESSFULLY CLEARED ALL BULLETS FROM [" + log + "] *** ");
    }
}
