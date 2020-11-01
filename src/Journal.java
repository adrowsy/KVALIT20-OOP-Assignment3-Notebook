import java.io.*;
import java.util.Scanner;

/**
 * Project:
 * Created by: Annika Rengfelt
 * Created:
 */
public class Journal {

    public static Bullet[] createLog() {
        //Lagra instanser av bullet i array
        Bullet[] log = new Bullet[Bullet.BULLETS_MAX];
        for (int i = 0; i < log.length; i++) {
            log[i] = new Bullet();
        }
        return log;
    }

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
                    System.out.print("### WARNING: Not enough memory in " + b + ". Last successful entry @ row #" + row + ": ");
                    Bullet.print(log[beginIndex - 1]);
                    break;
                }
            }
            System.out.println("*** SUCCESSFULLY ADDED " + row + " BULLETS FROM [" + fileName + "] *** ");
        } catch (Exception e) {
            System.out.println("### ERROR: Character out of place on row #" + row + " or immediately after. Please revise [" + fileName + "]");
        }
    }


    /**
     * Display full log. Bullets appear in default or chosen order
     *
     * @param log    to display
     * @param sortBy Sort by default (null), day of week or type of task
     */
    @SuppressWarnings("StatementWithEmptyBody")
    public static void display(Bullet[] log, String sortBy) {
        String order;

        if (sortBy == null) {
            order = "DEFAULT";
            System.out.println("*** PRINTING LOG: " + log + " BY " + order + " ***");
            for (Bullet bullet : log) {
                if ((bullet.type == 0) && (bullet.description == null)) ;

                    //Printing all non empty bullets
                else Bullet.print(bullet);
            }
        }

        if (sortBy.equals("day")) {
            order = "DAY OF WEEK";
            System.out.println("*** PRINTING LOG: " + log + " BY " + order + " ***");
            for (int weekday = 0; weekday <= 7; weekday++) {
                for (Bullet bullet : log) {
                    if ((bullet.type == 0) && (bullet.description == null)) ;
                    else if (bullet.weekday == weekday)
                        Bullet.print(bullet);
                    else ;
                }
            }
        }
        if (sortBy.equals("type")) {
            order = "TYPE";
            System.out.println("*** PRINTING LOG: " + log + " BY " + order + " ***");
            for (int type = 0; type < Bullet.TYPES.length; type++) {
                for (Bullet bullet : log) {
                    if ((bullet.type == 0) && (bullet.description == null)) ;
                    else if (bullet.type == type)
                        Bullet.print(bullet);
                    else ;
                }
            }
        }
        System.out.println("*** END OF LOG");
    }
}
