import java.io.FileNotFoundException;

/**
 * Project: OOP - Assignment 3
 * Inspired by the Bullet Journal method.
 * Learn more by visiting https://bulletjournal.com/pages/learn
 * Created by: Annika Rengfelt
 * Created:
 */
public class BulletJournal {

    public static final String DAYS = "sorted by day";
    public static final String TYPE = "sorted by type";

    public static void main(String[] args) throws FileNotFoundException {

        Bullet[] firstLog = Journal.createLog();

        Journal.log("12 Gör saker 2", firstLog);
        Journal.log(Bullet.TASK, "Gör saker", Bullet.SUN, firstLog);
        Journal.migrate("bullets.txt", firstLog);

        Journal.display(firstLog);

    }
}