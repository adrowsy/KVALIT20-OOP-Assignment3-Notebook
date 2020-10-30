import javax.swing.*;
import java.io.FileNotFoundException;

/**
 * Project: OOP - Assignment 3
 * Created by: Annika Rengfelt
 * Created:
 */
public class BulletJournal {

    public static void main(String[] args) {

        //1. Olika sätt att skapa Bullet med värden
        //1A. Manuellt
        Bullet b1 = new Bullet();
        //Skriv värden
        b1.type = Bullet.TASK;
        b1.description = "Tvätta";
        b1.weekday = Bullet.MON;
        //Skriv ut
        System.out.print(b1 + ":\t\t");
        Bullet.getPrintln(b1);

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
        String s = JOptionPane.showInputDialog("Skriv en Bullet [typnr beskrivning veckodagnr]");
        if (!s.isEmpty()) { //Hoppar över om tomt inmatningsfält
            Bullet b4 = Bullet.getInstance(s);
            //TODO: Skriv bättre mottagningsmeddelande
            JOptionPane.showMessageDialog(null, "Tack! Sparat punkten");
            System.out.print(b4 + ":\t\t");
            Bullet.getPrintln(b4);
        }
/*
        //1E. Läs in från fil
        //TODO felhantering surround w try-catch
        String fileName = "bullets.txt";
        //Läs in med scanner
        Scanner file = new Scanner(
                new File(fileName));
        String line = file.nextLine();

        //Skapa bullets från rader
        //Kan inte använda hasNextLine

        //Separera med ;

        //Skriv värden till
*/
    }
}