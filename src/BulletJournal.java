import javax.swing.*;

/**
 * Project: OOP - Assignment 3
 * Created by: Annika Rengfelt
 * Created:
 */
public class BulletJournal {

    public static void main(String[] args) {

        //1. Olika sätt att skapa Bullet med värden
        //1A. Manuellt
        Bullet b1 = new Bullet();
        //Skriv värden
        b1.type = Bullet.TASK;
        b1.description = "Tvätta";
        b1.weekday = Bullet.MON;
        //Skriv ut
        System.out.print(b1 + ":\t\t");
        Bullet.getPrintln(b1);

        //TODO: Tillåt inmatning av formatet TASK Description monday
        //1B. Genom getInstance och kommaseparerade värden
        Bullet b2 = Bullet.getInstance(1,"Töm kattlådor",3);
        System.out.print(b2 + ":\t\t");
        Bullet.getPrintln(b2);

        //1C. Genom getInstance och substring
        Bullet b3 = Bullet.getInstance("2 Städa 3");
        System.out.print(b3 + ":\t\t");
        Bullet.getPrintln(b3);

        //1D. Läs in från dialogruta //TODO: Gör om till metod
        //TODO: Bättre felhantering inmatningsruta
        String s = JOptionPane.showInputDialog("Skriv en Bullet [typnr beskrivning veckodagnr]");
        if (!s.isEmpty()) { //Hoppar över om tomt inmatningsfält
            Bullet b4 = Bullet.getInstance(s);
            //TODO: Skriv bättre mottagningsmeddelande
            JOptionPane.showMessageDialog(null, "Tack! Sparat punkten");
            System.out.print(b4 + ":\t\t");
            Bullet.getPrintln(b4);
        }
    }

}

class Bullet {
    //Instansvariabler
    int type; // TASK = 1, EVENT = 2, NOTE = 3
    String description;
    int weekday;

    //Konstanter för type och utskrift
    public static final int
            TASK = 1, EVENT = 2, NOTE = 3;
    public static final int
            MON = 1, TUE = 2, WED = 3, THUR = 4, FRI = 5, SAT = 6, SUN = 7;
    public static final String[] TASK_SYMBOL = {null, "[*]","[o]","[-]"};
    public static final String[] WEEKDAYS = {null, "monday", "tuesday", "wed", "thur", "fri", "sat", "sun"};

    
    /**
     * Klassmetod som skriver värden till en instans av Bullet
     * @param b Bullet
     * @param s Värden
     */
    public static void changeBullet(String s, Bullet b) {
        b.type = Integer.parseInt(s.substring(0,s.indexOf(' ')));
        b.description = s.substring((s.indexOf(' ')+1),s.lastIndexOf(' '));
        b.weekday = Integer.parseInt(s.substring(s.lastIndexOf(' ')+1));
    }

    /**
     * Klassmetod för att skriva ut Bullet
     * @param b Bullet
     * @return
     */
    public static String getPrintln(Bullet b) {
        String message = (TASK_SYMBOL[b.type] + " " + b.description + " @ " + WEEKDAYS[b.weekday]);
        System.out.println(message);
        return message;
    }

    /**
     * Klassmetod för att skapa Bullet
     * @param type
     * @param description
     * @param weekday
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
     * @param s Sträng enligt format type description weekday
     * @return
     */
    public static Bullet getInstance(String s) {
        Bullet b = new Bullet();
        b.type = Integer.parseInt(s.substring(0,s.indexOf(' ')));
        b.description = s.substring((s.indexOf(' ')+1),s.lastIndexOf(' '));
        b.weekday = Integer.parseInt(s.substring(s.lastIndexOf(' ')+1));
        return b;
    }
}
