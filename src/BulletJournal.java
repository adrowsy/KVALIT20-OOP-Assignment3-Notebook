import java.io.FileNotFoundException;

/**
 * Project: OOP - Assignment 3
 * Inspired by the Bullet Journal method.
 * Learn more by visiting https://bulletjournal.com/pages/learn
 * Created by: Annika Rengfelt
 * Created:
 */
public class BulletJournal {

    public static void main(String[] args) throws FileNotFoundException {

        Bullet[] firstLog = Journal.createLog();


        Journal.log("bullets.txt", firstLog, 0);
        Journal.display(firstLog); //OK

        Journal.displayByDay(firstLog); //NOK
        System.out.println("-----------");

        Journal.displayByType(firstLog);
    }
}