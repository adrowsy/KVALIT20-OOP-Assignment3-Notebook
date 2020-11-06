/**
 * Project: OOP - Assignment 3
 * Inspired by the Bullet Journal method.
 * Learn more by visiting https://bulletjournal.com/pages/learn
 * Created by: Annika Rengfelt
 * Submitted: 2020-11-11
 */

public class Journal {

    //Egenskaper hos Journal
    private Bullet[] bullets;
    private String name;

    public static int SIZE = 2;

    //Tom konstruktor
    Journal() {
    }

    //Konstruktor
    Journal(String name) {
        this.bullets = new Bullet[SIZE];
        setName(name);
        System.out.println(Message.ADDED + "New journal named " + this.name);
        System.out.println(Message.EMPTY_LOG);
        System.out.println("Add bullets [Description WEEKDAYNR]. " +
                "Save with Ctrl+D");
        //--> Lägg till bullets
    }

    /**
     * Create bullet from string
     */
    public void setBullet(String bullet) {
        boolean emptySpot = false;

        for (int i = 0; i < this.bullets.length; i++) {
            if (this.bullets[i] == null) {
                emptySpot = true;
                this.bullets[i] = new Bullet(bullet);
                break;
            } else ;
        }
        if (!emptySpot) System.out.println("Reached max amount of bullets " + SIZE);
    }

    public static void getName(Journal j) {
        System.out.println(j.name);
    }

    /**
     * Change journal name
     *
     * @param name
     */
    public void setName(String name) {
        if (this.name != null)
            this.name = name;
        else
            System.out.println("Name must not be empty");
    }


    /**
     * En klassmetod som skriver ut alla bullets i en log
     *
     * @param j
     */
    public static void print(Journal j) {
        try {
            for (Bullet b : j.bullets)
                b.toString();
        } catch (Exception e) {
            System.out.println(Message.EMPTY_LOG);
        }
    }
}