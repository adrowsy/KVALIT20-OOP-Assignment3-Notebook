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
    private int type; // TASK, EVENT, NOTE
    private String description; //Tvätta 60 grader
    private int weekday; //monday, tuesday...

    //Konstruktor
    Bullet(int type, String description, int weekday) {
        setBullet(type, description, weekday);
    }

    Bullet(String bullet) {
        setBullet(bullet);
    }

    //Konstanter för type och utskrift
    public static final int
            MON = 1, TUE = 2, WED = 3, THUR = 4, FRI = 5, SAT = 6, SUN = 7;
    public static final int TASK = 1, DONE = 2, MIGRATED = 3;

    public static final String[] SYMBOLS = {null, "[*]", "[x]", "[>]"};

    public static final String[] WEEKDAYS =
            {null, "@ monday", "@ tuesday", "@ wednesday", "@ thursday", "@ friday", "@ saturday", "@ sunday"};

    /**
     * Create bullet from comma separated entry
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
     * Creates bullet from string entry
     *
     * @param bullet type description weekday
     */
    public void setBullet(String bullet) { //13 Tvätta 60 grader 7
        this.type = Integer.parseInt(bullet.substring(0, bullet.indexOf(' ')));
        this.description = bullet.substring((bullet.indexOf(' ') + 1), bullet.lastIndexOf(' '));
        this.weekday = Integer.parseInt(bullet.substring(bullet.lastIndexOf(' ') + 1));
    }

    public Bullet migrate(int newWeekday) {
        this.type = MIGRATED;

        Bullet b = new Bullet(TASK, this.description, newWeekday);
        return b;
    }

    @Override
    public String toString() {
        return SYMBOLS[type] + " " + description + " " + Bullet.WEEKDAYS[weekday];
    }
}


