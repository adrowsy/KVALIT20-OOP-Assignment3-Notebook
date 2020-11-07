import java.io.File;
import java.io.FileNotFoundException;
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

    /**
     * Klassmetod för att hitta första lediga index i journal
     *
     * @return nextAvailableIndex -1 indicates no available spot
     */
    public int nextAvailableIndex() {
        int nextAvailableIndex = 0;
        boolean emptySpot = false;
        for (int i = 0; i < this.journal.length; i++) {
            if (this.journal[i] == null) {
                nextAvailableIndex = i;
                emptySpot = true;
                break;
            }
        }
        if (!emptySpot) {
            nextAvailableIndex = -1;
        }
        return nextAvailableIndex;
    }

    public static void scanTo(Journal journal) {
        String userDescription;
        int userWeekday;
        Scanner sc = new Scanner(System.in);
        System.out.println("Add new bullet followed by n (\"buy candy 1\"). Save with E-O-F");
        while (sc.hasNext()) {
            try {
                String bullet = sc.nextLine();
                userDescription = bullet.substring(0, bullet.lastIndexOf(' '));
                userWeekday = Integer.parseInt(bullet.substring(bullet.lastIndexOf(' ') + 1));

                journal.journal[journal.nextAvailableIndex()] =
                        Bullet.getInstance(userDescription, userWeekday);

            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
        }
        sc.close();
    }

    /**
     * Klassmetod som skapar bullets från textfil
     *
     * @param journal
     * @throws FileNotFoundException
     */
    public static void importFromFile(Journal journal) throws FileNotFoundException {
        String userDescription;
        int userWeekday;
        String fileName = "list.txt";
        Scanner file = new Scanner(new File(fileName));
        try {
            while (file.hasNextLine()) {
                userDescription = file.next();
                while (!file.hasNextInt()) {
                    userDescription += " " + file.next();
                }
                userWeekday = file.nextInt();
                journal.journal[journal.nextAvailableIndex()] =
                        Bullet.getInstance(userDescription, userWeekday);
            }
        } catch (Exception e) {
            System.out.print("Warning: " + e + '\n');
        }
    }

    @Override
    public String toString() {
        int empty = 0;
        String s = "\nJournal entries:";
        for (int i = 0; i < this.journal.length; i++) {
            if (journal[i] != null)
                s += "\n" + journal[i];
            else
                empty++;
        }
        if (empty >= this.journal.length)
            s += " No entries";
        return s + '\n';
    }
}
