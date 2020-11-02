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

        System.out.println("Skriv i loggen");
        Journal.log("12 Gör saker 2", firstLog);
        Journal.log(Bullet.TASK, "Gör saker", Bullet.SUN, firstLog);
        Journal.migrate("bullets.txt", firstLog);
        Journal.display(firstLog);

        System.out.println("Ändra första radens dag");
        Bullet.changeDay(firstLog, 1, Bullet.MON);
        Journal.display(firstLog);

        System.out.println("Ändra första radens typ");
        Bullet.changeStatus(firstLog, 1, Bullet.DONE);
        Journal.display(firstLog);

        System.out.println("Ändra andra radens beskrivning");
        Bullet.changeDescription(firstLog, 2, "Gör roliga saker");
        Journal.display(firstLog);
    }
}