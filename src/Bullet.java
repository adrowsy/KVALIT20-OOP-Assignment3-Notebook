import java.io.File;
import java.io.FileNotFoundException;
import java.io.OptionalDataException;
import java.util.Scanner;

/**
 * Project:
 * Created by: Annika Rengfelt
 * Created:
 */
public class Bullet {

    //Egenskaper hos bullet (instansvariabler)
    String description; //Tvätta 60 grader
    int type; // TASK, EVENT, NOTE
    int weekday; //monday, tuesday...

    //Konstanter för type och utskrift
    public static final int
            MON = 1, TUE = 2, WED = 3, THUR = 4, FRI = 5, SAT = 6, SUN = 7;
    public static final int TASK = 1, SCHEDULED = 2, MIGRATED = 3, DONE = 3, IGNORE = 5;
    public static final int EVENT = 6;
    public static final int NOTE = 7;

    public static final String[] TYPES = {null, "[ ]", "[<]", "[>]", "[x]", "[-]", " o ", " - "};

    public static final String[] DESCRIPTION =
            {null, "monday", "tuesday", "wednesday", "thursday", "friday", "saturday", "sunday",
                    "[ ]", "[<]", "[>]", "[x]", "[-]", " o ", " - "};

    public static final String[] WEEKDAYS =
            {null, "monday", "tuesday", "wednesday", "thursday", "friday", "saturday", "sunday"};

    /**
     * Klassmetod för att skapa en bullet
     */
    public static Bullet getInstance() {
        return new Bullet();
    }

    //Metoder för att manipulera bullet (instansmetoder)

    /**
     * Manipulate one bullet from comma separated entry
     *
     * @param type
     * @param description
     * @param weekday
     */
    public void setBullet(int type, String description, int weekday) { //Bullet.TASK,"Tvätta 60 grader",7
        this.type = type;
        this.description = description;
        this.weekday = weekday;
    }

    /**
     * Manipulate one bullet from string entry
     *
     * @param bullet type description weekday
     */
    public void setBullet(String bullet) { //13 Tvätta 60 grader 7
        this.type = Integer.parseInt(bullet.substring(0, bullet.indexOf(' ')));
        this.description = bullet.substring((bullet.indexOf(' ') + 1), bullet.lastIndexOf(' '));
        this.weekday = Integer.parseInt(bullet.substring(bullet.lastIndexOf(' ') + 1));
    }

    /**
     * Print one bullet
     *
     * @param b Bullet
     */
    public static void print(Bullet b) {
        System.out.println(Bullet.DESCRIPTION[b.type] + " " + b.description + " @ " + Bullet.WEEKDAYS[b.weekday]);
    }

    /**
     * Deleting one bullet entry by resetting values to null
     */
    public void clearBullet() {
        this.type = 0;
        this.description = null;
        this.weekday = 0;
        System.out.println(Message.CLEARED + "1 bullet");
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

    @Override
    public String toString() {
        return type + " " + description + " " + Bullet.DESCRIPTION[weekday];
    }
}


