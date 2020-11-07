/**
 * Project: Assignment 3
 * Created by: Annika Rengfelt
 * Due: 2020-11-11
 */
public class Bullet {
    //Egenskaper hos Bullet (instansvariabler)
    int type; //Typ - använder konstanter
    int weekday; //Veckodag - använder konstanter
    String description; //Beskrivning (fritext)

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
    public static final String[] SYMBOLS = {null, "\u2022", "\u00D7", "\u003E", "\u2139"};
    //  • task
    //  × done
    //  > migrated
    //  ℹ information
    public static final String[] WEEKDAYS = {null, "@ monday", "@ tuesday", "@ wednesday", "@ thursday", "@ friday", "@ saturday", "@ sunday"};


    /**
     * Klassmetod som skriver ut bullet
     *
     * @param b bullet (referensvariabel)
     */
    public static void print(Bullet b) {
        System.out.println(Bullet.SYMBOLS[b.type] + " " + b.description + " " + Bullet.WEEKDAYS[b.weekday]);
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
     * Instansmetod som ger bullet värden
     *
     * @param description
     * @param weekday
     */

    public void setBullet(String description, int weekday) {
        this.type = TASK;
        this.description = description;
        this.weekday = weekday;
    }

    /**
     * Klassmetod som markerar en bullet som klar
     */
    public static void setDone(Bullet bullet) {
        bullet.type = DONE;
    }

    public static void main(String[] args) {

        String userDescription;
        int userWeekday;

        Journal journal = Journal.getJournal();

        Journal.scanTo(journal);
        print(journal.journal);

    }

    public static void print(Bullet[] journal) {
        for (int i = 0; i < journal.length; i++) {
            if (journal[i] != null) {
                print(journal[i]);
            }
        }
    }

}
