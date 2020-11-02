/**
 * Project:
 * Created by: Annika Rengfelt
 * Created:
 */
public class Bullet {
//TODO Dokumentera


    //Instansvariabler
    //TODO: Lägg till String date;
    int type; // TASK = 1, EVENT = 2, NOTE = 3
    String description;
    int weekday;

    //Konstanter för type och utskrift
    public static final int TASK = 8;
    public static final int SCHEDULED = 9;
    public static final int MIGRATED = 10;
    public static final int DONE = 11;
    public static final int IGNORE = 12;
    public static final int EVENT = 13;
    public static final int NOTE = 14;
    public static final int
            MON = 1, TUE = 2, WED = 3, THUR = 4, FRI = 5, SAT = 6, SUN = 7;

    public static final String[] DESCRIPTION =
            {null, "monday", "tuesday", "wednesday", "thursday", "friday", "saturday", "sunday",
                    "[ ]", "[<]", "[>]", "[x]", "[-]", " o ", " - "};

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
     * Print one bullet
     *
     * @param b Bullet
     */
    public static void print(Bullet b) {
        System.out.println(Bullet.DESCRIPTION[b.type] + " " + b.description + " @ " + Bullet.DESCRIPTION[b.weekday]);
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

        System.out.println(Message.CLEARED + "1 bullet from [" + log + "]");
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
        System.out.println(Message.CLEARED + (lastBullet - firstBullet) + " bullets from [" + log + "]");
    }

    /**
     * Deleting all bullets in one log by resetting values to null
     *
     * @param log
     */
    public static void clear(Bullet[] log) {
        for (int j = 0; j < log.length; j++) {
            log[j].type = 0;
            log[j].description = null;
            log[j].weekday = 0;
        }
        System.out.println(Message.CLEARED + "all bullets from [" + log + "]");
    }

    public static void changeStatus(Bullet[] log, int row, int newStatus) {
        log[row - 1].type = newStatus;
    }

    public static void changeDay(Bullet[] log, int row, int newDay) {
        log[row - 1].weekday = newDay;
    }

    public static void changeDescription(Bullet[] log, int row, String newDescription) {
        log[row - 1].description = newDescription;
    }
}