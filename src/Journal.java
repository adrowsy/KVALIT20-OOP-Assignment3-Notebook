import java.util.Scanner;

/**
 * Project:
 * Created by: Annika Rengfelt
 * Created:
 */
public class Journal {

    //Egenskaper hos Journal
    private Bullet[] log;
    private String name;

    //Tom konstruktor
    Journal() {
    }

    //Konstruktor
    Journal(String name) {
        setTitle(name);
        System.out.println(Message.ADDED + "New journal " + name);
    }

    /**
     * Change journal name
     *
     * @param newName
     */
    public void setTitle(String newName) {
        this.name = newName;
    }

    /**
     * En klassmetod som skriver ut alla bullets i en log
     *
     * @param j
     */
    public static void print(Journal j) {
        try {
            for (Bullet b : j.log)
                b.toString();
        } catch (Exception e) {
            System.out.println(Message.EMPTY_LOG);
        }
    }

}