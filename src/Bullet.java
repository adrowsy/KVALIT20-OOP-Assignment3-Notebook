/**
 * Project: OOP - Assignment 3
 * Inspired by the Bullet Journal method.
 * Learn more by visiting https://bulletjournal.com/pages/learn
 * Created by: Annika Rengfelt
 * Submitted: 2020-11-11
 */

public class Bullet {

    //Egenskaper hos bullet (instansvariabler)
    private int type; // TASK, EVENT, NOTE
    private String description; //Tvätta 60 grader
    private int weekday; //monday, tuesday...

    //Konstruktor
    Bullet(String description, int weekday) {
        setSingleBullet(description, weekday);
    }

    Bullet(String bullet) {
        Single(bullet);
    }

    //Konstanter för type och utskrift
    public static final int
            MON = 1, TUE = 2, WED = 3, THUR = 4, FRI = 5, SAT = 6, SUN = 7;
    public static final int TASK = 1, DONE = 2, MIGRATED = 3;

    //TODO: Unicode och korrekta BuJO-symboler
    public static final String[] SYMBOLS = {null, "[*]", "[x]", "[>]"};

    public static final String[] WEEKDAYS =
            {null, "@ monday", "@ tuesday", "@ wednesday", "@ thursday", "@ friday", "@ saturday", "@ sunday"};

    /**
     * Create bullet from comma separated entry
     *
     * @param description
     * @param weekday
     */
    public void setSingleBullet(String description, int weekday) {
        this.type = TASK;
        this.description = description;
        this.weekday = weekday;
    }

    /**
     * Creates bullet from string entry
     *
     * @param bullet type description weekday
     */
    public void Single(String bullet) {
        this.type = TASK; //Integer.parseInt(bullet.substring(0, bullet.indexOf(' ')));
        this.description = bullet.substring(0, bullet.lastIndexOf(' ')); //this.description = bullet.substring((bullet.indexOf(' ') + 1), bullet.lastIndexOf(' '));
        this.weekday = Integer.parseInt(bullet.substring(bullet.lastIndexOf(' ') + 1));
    }

    public Bullet migrate(int newWeekday) {
        this.type = MIGRATED;
        return new Bullet(this.description, newWeekday);
    }

    @Override
    public String toString() {
        return SYMBOLS[type] + " " + description + " " + Bullet.WEEKDAYS[weekday];
    }
}


