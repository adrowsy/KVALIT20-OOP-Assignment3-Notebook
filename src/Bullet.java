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
    public static final String[] TYPES = {null, "[*]", "[o]", "[-]"};
    public static final int
            TASK = 1, EVENT = 2, NOTE = 3;

    public static final String[] WEEKDAYS =
            {null, "monday", "tuesday", "wednesday", "thursday", "friday", "saturday", "sunday"};
    public static final int
            MON = 1, TUE = 2, WED = 3, THUR = 4, FRI = 5, SAT = 6, SUN = 7;

    /**
     * Print one bullet
     *
     * @param b Bullet
     */
    public static void print(Bullet b) {
        System.out.println(Bullet.TYPES[b.type] + " " + b.description + " @ " + Bullet.WEEKDAYS[b.weekday]);
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