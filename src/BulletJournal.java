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

        clear(firstLog, 1);
        Bullet.display(firstLog);

    }
//TODO: Flytta till Bullet

    public static void clear(Bullet[] log, int firstBullet, int lastBullet) {
        for (int j = firstBullet; j <= lastBullet; j++) {
            log[j].type = 0;
            log[j].description = null;
            log[j].weekday = 0;
        }
        System.out.println("*** SUCCESSFULLY CLEARED " + (lastBullet - firstBullet) + " BULLETS FROM [" + log + "] *** ");
    }

    public static void clear(Bullet[] log, int bullet) {
        log[bullet].type = 0;
        log[bullet].description = null;
        log[bullet].weekday = 0;

        System.out.println("*** SUCCESSFULLY CLEARED BULLET FROM [" + log + "] *** ");
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