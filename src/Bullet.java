/**
 * Project: Assignment 3
 * Created by: Annika Rengfelt
 * Due: 2020-11-11
 */

public class Bullet {
    //Egenskaper hos Bullet (instansvariabler)
    private int type; //Typ - använder konstanter
    private int weekday; //Veckodag - använder konstanter
    private String description; //Beskrivning (fritext)

    //Konstanter (klassvariabler)
    public static final int TASK = 1;
    public static final int DONE = 2;
    public static final int MIGRATED = 3;
    public static final int INFO = 4;

    public static final int MONDAY = 1;
    public static final int TUESDAY = 2;
    public static final int WEDNESDAY = 3;
    public static final int THURSDAY = 4;
    public static final int FRIDAY = 5;
    public static final int SATURDAY = 6;
    public static final int SUNDAY = 7;

    //Arrayer för utskrift
    public static final String[] SYMBOLS = {null,
            "\u2022", "\u00D7", "\u003E", "\u2139"};
    //  • task
    //  × done
    //  > migrated
    //  ℹ information
    public static final String[] WEEKDAYS = {null, "@ monday", "@ tuesday",
            "@ wednesday", "@ thursday", "@ friday", "@ saturday", "@ sunday"};

    /**
     * instansmetod som skriver ut bullet
     */
    public void print() {
        System.out.println(this);
    }

    /**
     * Instansmetod som ger bullet värden
     *
     * @param description
     * @param weekday
     */

    public void setBullet(String description, int weekday) {
        this.type = TASK;
        this.description = description;
        if (weekday >= 1 && weekday <= 7)
            this.weekday = weekday;
        else
            throw new IllegalArgumentException("Weekday must be numbered 1-7");
    }

    @Override
    public String toString() {
        return SYMBOLS[type] + " " +
                description + " " + WEEKDAYS[weekday];
    }

    /**
     * Klassmetod som instansierar och deklarerar en bullet
     *
     * @param description
     * @param weekday
     * @return
     */
    public static Bullet getInstance(String description, int weekday) {
        Bullet b = new Bullet();
        b.setBullet(description, weekday);
        return b;
    }

    /**
     * Klassmetod som markerar en bullet som klar
     */
    public static void setDone(Bullet bullet) {
        bullet.type = DONE;
    }

}
