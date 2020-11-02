import java.io.*;
import java.util.Scanner;

/**
 * Project:
 * Created by: Annika Rengfelt
 * Created:
 */
public class Journal {

    public static final int BULLETS_MAX = 10;

    public static Bullet[] createLog() {
        //Lagra instanser av bullet i array
        Bullet[] log = new Bullet[Journal.BULLETS_MAX];
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
        System.out.println(Message.PRINT + log);
        for (int j = 0; j < log.length; j++) {
            if ((log[j].type != 0) && (log[j].description != null))
                Bullet.print(log[j]); //Printing all non empty bullets
        }
        System.out.println(Message.EOL);
    }

    public static void display(Bullet[] log, String sorted) {
        System.out.println(Message.PRINT + log + " " + sorted);

        if (sorted == BulletJournal.DAYS) {
            for (int weekday = 0; weekday < Bullet.DESCRIPTION.length; weekday++) {
                for (int j = 0; j < log.length; j++) {
                    if ((log[j].type != 0) && (log[j].description != null) && (log[j].weekday == weekday))
                        Bullet.print(log[j]); //Printing all non empty bullets
                }
            }
        }
        if (sorted == BulletJournal.TYPE) {
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
}