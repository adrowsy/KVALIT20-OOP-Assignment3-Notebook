import java.io.FileNotFoundException;
import java.util.Random;

/**
 * Project: OOP - Assignment 3
 * Inspired by the Bullet Journal method.
 * Learn more by visiting https://bulletjournal.com/pages/learn
 * Created by: Annika Rengfelt
 * Created:
 */
public class BulletJournal {

    public static void main(String[] args) throws FileNotFoundException {

        //Lagra instanser av bullet i array
        Bullet[] firstLog = new Bullet[Bullet.BULLETS_MAX];
        for (int i = 0; i < firstLog.length; i++) {
            firstLog[i] = new Bullet();
        }

        //Deklarera variabler
        int i;
        i = 1;

        Bullet.log("bullets.txt", firstLog, i);
        Bullet.display(firstLog);
        System.out.println("-----------");
        Bullet.display(firstLog, "day");

    }





    /**
     * Utskrift för enhetstestning
     *
     * @param bullet
     * @param i
     */
    public static void testPrint(Bullet bullet, int i) {
        System.out.print("i=" + i + ", " + bullet + ":\t");
        Bullet.display(bullet);
    }
}