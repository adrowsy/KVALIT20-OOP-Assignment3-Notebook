/**
 * Project:
 * Created by: Annika Rengfelt
 * Created:
 */
public class Bullet {
//TODO Dokumentera

    //Konstant värde för hur många bullets som kan sparas i array
    public static final int BULLETS_MAX = 10;

    //Instansvariabler
    int type; // TASK = 1, EVENT = 2, NOTE = 3
    String description;
    int weekday;

    //Konstanter för type och utskrift
    public static final int
            TASK = 1, EVENT = 2, NOTE = 3;
    public static final int
            MON = 1, TUE = 2, WED = 3, THUR = 4, FRI = 5, SAT = 6, SUN = 7;
    public static final String[] TASK_SYMBOL = {null, "[*]", "[o]", "[-]"};
    public static final String[] WEEKDAYS = {null, "monday", "tuesday", "wed", "thur", "fri", "sat", "sun"};




    /**
     * Klassmetod för att skriva ut Bullet
     *
     * @param b Bullet
     * @return message
     */
    public static void getPrintln(Bullet b) {
        String message = (TASK_SYMBOL[b.type] + " " + b.description + " @ " + WEEKDAYS[b.weekday]);
        System.out.println(message);
        //return message;
    }

    /**
     * Klassmetod för att skapa Bullet
     *
     * @param type
     * @param description
     * @param weekday
     * @return b bullet
     */
    public static Bullet getInstance(int type, String description, int weekday) {
        Bullet b = new Bullet();
        b.type = type;
        b.description = description;
        b.weekday = weekday;
        return b;
    }

    /**
     * Klassmetod för att skapa Bullet från String
     *
     * @param s Sträng enligt format type description weekday
     * @return b bullet
     */
    public static Bullet getInstance(String s) {
        Bullet b = new Bullet();
        b.type = Integer.parseInt(s.substring(0, s.indexOf(' ')));
        b.description = s.substring((s.indexOf(' ') + 1), s.lastIndexOf(' '));
        b.weekday = Integer.parseInt(s.substring(s.lastIndexOf(' ') + 1));
        return b;
    }

    //TODO: Tillåt inmatning av formatet TASK Description monday
}
