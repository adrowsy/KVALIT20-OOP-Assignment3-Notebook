import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Project: OOP - Assignment 3
 * Created by: Annika Rengfelt
 * Created:
 */
public class BulletJournal {

    public static void main(String[] args) throws FileNotFoundException {

        //0. Lagring av Bullets sker i array
        Bullet[] bullets = new Bullet[Bullet.BULLETS_MAX];

        //När man skapar en Bullet måste en inparameter vara i vilket index av Bullet[]
        //Nästa index på tur är första nullvärdet så jag måste skapa en variabel
        //räkna index som inte innehåller null, sätt index för ifyllnad till sista+1

        int x = 0;
        bullets[x] = Bullet.getInstance("2 Städa 3");

        //TODO Utskrift
        for (int i = 0; i < bullets.length; i++) {
            System.out.println(Bullet.getPrintln(bullets[i]));
        }
        

        //1. Olika sätt att skapa Bullet med värden
        //1A. Manuellt
        /*
        Bullet b1 = new Bullet();
        //Skriv värden
        b1.type = Bullet.TASK;
        b1.description = "Tvätta";
        b1.weekday = Bullet.MON;
        //Skriv ut
        System.out.print(b1 + ":\t\t");
        Bullet.getPrintln(b1);
         */

        //TODO: Tillåt inmatning av formatet TASK Description monday
        //1B. Genom getInstance och kommaseparerade värden
        Bullet b2 = Bullet.getInstance(1, "Töm kattlådor", 3);
        System.out.print(b2 + ":\t\t");
        Bullet.getPrintln(b2);

        //1C. Genom getInstance och substring
        Bullet b3 = Bullet.getInstance("2 Städa 3");
        System.out.print(b3 + ":\t\t");
        Bullet.getPrintln(b3);

        //1D. Läs in från dialogruta //TODO: Gör om till metod
        //TODO: Bättre felhantering inmatningsruta
        String s = ""; //JOptionPane.showInputDialog("Skriv en Bullet [typnr beskrivning veckodagnr]");
        if (!s.isEmpty()) { //Hoppar över om tomt inmatningsfält
            Bullet b4 = Bullet.getInstance(s);
            //TODO: Skriv bättre mottagningsmeddelande
            JOptionPane.showMessageDialog(null, "Tack! Sparat punkten");
            System.out.print(b4 + ":\t\t");
            Bullet.getPrintln(b4);
        }

        //1E. Läs in från fil
        //TODO felhantering surround w try-catch
        String fileName = "bullets.txt";
        //Läs in med scanner
        Scanner file = new Scanner(
                new File(fileName));

        //Skapa bullets från textfil          // OBS! Kan inte använda hasNextLine

        //Separera med ;

        //Hitta nästa lediga index

        //Skriv värden till

    }
}