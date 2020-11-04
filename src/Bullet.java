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
    public static final int TASK = 8, SCHEDULED = 9, MIGRATED = 10, DONE = 11, IGNORE = 12;
    public static final int EVENT = 13;
    public static final int NOTE = 14;

    public static final String[] DESCRIPTION =
            {null, "monday", "tuesday", "wednesday", "thursday", "friday", "saturday", "sunday",
                    "[ ]", "[<]", "[>]", "[x]", "[-]", " o ", " - "};

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
        System.out.println(Bullet.DESCRIPTION[b.type] + " " + b.description + " @ " + Bullet.DESCRIPTION[b.weekday]);
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

    //Klassmetoder

    /**
     * Klassmetod för att skapa en bullet
     */
    public static Bullet getInstance() {
        return new Bullet();
    }

    @Override
    public String toString() {
        return type + " " + description + " " + Bullet.DESCRIPTION[weekday];
    }
}


