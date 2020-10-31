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

    public static void main(String[] args) {

        //Skapa en array med plats för bullets
        Bullet[] bullets = new Bullet[10];

        /*
        for (Bullet b:bullets)
            System.out.println(b);
        null
        null
        null
        null
        null
        null
        null
        null
        null
        null
        */

        //Skapa bullets
        for (int i = 0; i < bullets.length; i++) {
            bullets[i] = new Bullet();
        }
/*
        for (Bullet b:bullets)
            System.out.println(b);
Bullet@5f184fc6
Bullet@3feba861
Bullet@5b480cf9
Bullet@6f496d9f
Bullet@723279cf
Bullet@10f87f48
Bullet@b4c966a
Bullet@2f4d3709
Bullet@4e50df2e
Bullet@1d81eb93
 */

        //1. Olika sätt att skapa Bullet med värden
        //1A. Manuellt
        int i = 0;
        bullets[i] = new Bullet();
        bullets[i].type = Bullet.TASK;
        bullets[i].description = "Tvätta";
        bullets[i].weekday = Bullet.MON;

        //Skriv ut
        skrivUt(bullets[i], i);
        //

        //1B. Genom getInstance och kommaseparerade värden
        i = 1;
        bullets[i] = Bullet.getInstance(Bullet.TASK, "Mata katterna", Bullet.MON);
        skrivUt(bullets[i], i);

        //1C. Genom getInstance och string
        i = 3;
        bullets[i] = Bullet.getInstance("1 kattmat 5");
        skrivUt(bullets[i], i);

        for (int j = 0; j < bullets.length; j++) {
            skrivUt(bullets[j], j);
        }

        //1D. Läs in från dialogruta //TODO: Gör om till metod
        //TODO: Bättre felhantering inmatningsruta
        i = 4;
        String s = JOptionPane.showInputDialog("Skriv en Bullet [typnr beskrivning veckodagnr]");
        if (!s.isEmpty()) { //Hoppar över om tomt inmatningsfält
            bullets[i] = Bullet.getInstance(s);
            //TODO: Skriv bättre mottagningsmeddelande
            JOptionPane.showMessageDialog(null, "Tack! Sparat punkten");
            skrivUt(bullets[i], i);
        }

        //1E. Läs in från fil
        //TODO felhantering surround w try-catch
        String fileName = "bullets.txt";
        //Läs in med scanner
        //Scanner file = new Scanner(new File(fileName));

        //Skapa bullets från textfil          // OBS! Kan inte använda hasNextLine

        //Separera med ;

        //Hitta nästa lediga index

        //Skriv värden till

    }

    public static void skrivUt(Bullet bullet, int i) {
        System.out.print("i=" + i + ", " + bullet + ":\t");
        Bullet.getPrintln(bullet);
    }
}