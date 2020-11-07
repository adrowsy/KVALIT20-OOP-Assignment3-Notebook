import java.util.Arrays;
import java.util.Scanner;

/**
 * Project:
 * Created by: Annika Rengfelt
 * Created:
 */
public class Journal {

    //Egenskaper hos journal
    Bullet[] journal; //En array av typen Bullet

    public static final int STANDARD_SIZE = 10;

    /**
     * Klassmetod för att skapa en "tom" journal
     * Alla komponenter är null
     */
    public static Journal getJournal() {
        int size = STANDARD_SIZE;
        Journal journal = new Journal();
        journal.journal = new Bullet[size];
        System.out.println("Created new journal with room for " + size + " bullets");
        return journal;
    }

    /**
     * Klassmetod för att skapa en "tom" journal med valfritt antal platser
     * Alla komponenter är null
     */
    public static Journal getJournal(int count) {
        int size = count;
        Journal journal = new Journal();
        journal.journal = new Bullet[size];
        System.out.println("Created new journal with room for " + size + " bullets");
        return journal;
    }

    public int nextAvailableSpot() {
        int nextAvailableSpot = 0;
        boolean emptySpot = false;
        for (int i = 0; i < this.journal.length; i++) {
            if (this.journal[i] == null) {
                nextAvailableSpot = i;
                emptySpot = true;
                break;
            }
        }
        if (!emptySpot) {
            nextAvailableSpot = -1;
        }
        return nextAvailableSpot;
    }

    public static void scanTo(Journal journal) {
        String userDescription;
        int userWeekday;
        Scanner sc = new Scanner(System.in);
        System.out.println("Add new bullet followed by n (\"buy candy 1\"). Save with Ctrl+D");
        while (sc.hasNext()) {
            try {
                String bullet = sc.nextLine();
                userDescription = bullet.substring(0, bullet.lastIndexOf(' '));
                userWeekday = Integer.parseInt(bullet.substring(bullet.lastIndexOf(' ') + 1));

                journal.journal[journal.nextAvailableSpot()] =
                        Bullet.getInstance(userDescription, userWeekday);

            } catch (Exception e) {
                System.out.println("Error: Wrong format " + e);
            }
        }
    }
}
