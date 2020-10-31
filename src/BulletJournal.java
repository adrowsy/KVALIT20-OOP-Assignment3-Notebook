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

        //Lagra instanser av bullet i array
        Bullet[] bullets = new Bullet[Bullet.BULLETS_MAX];
        for (int i = 0; i < bullets.length; i++) {
            bullets[i] = new Bullet();
        }

        //Deklarera variabler
        int i = 0;

        //Manipulera instansvariablernas värden
        int i = 1;
        bullets[i] = new Bullet();
        bullets[i].type = Bullet.TASK;
        bullets[i].description = "Tvätta";
        bullets[i].weekday = Bullet.MON;


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
            if (bullets[j].description == null) j = bullets.length - 1;
        }

        //TODO: Felhantering inmatningsruta
        i = 4;
        String s = "";
        //s = JOptionPane.showInputDialog("Skriv en Bullet [typnr beskrivning veckodagnr]");
        if (!s.isEmpty()) {
            bullets[i] = Bullet.getInstance(s);
            //TODO: Skriv bättre mottagningsmeddelande
            JOptionPane.showMessageDialog(null, "Tack! Sparat punkten");
            skrivUt(bullets[i], i);
        }
        /*
        i = 5;
        String fileName = "bullets.txt";
        Scanner file = new Scanner(new File(fileName));
        int row = 0;
        try {
            while (file.hasNextLine()) {
                Bullet b = new Bullet();
                b.type = file.nextInt();
                b.description = file.next();
                while (!file.hasNextInt()) {
                    b.description += " " + file.next();
                }
                b.weekday = file.nextInt();
                bullets[i] = b;
                skrivUt(bullets[i], i);
                i++;
                row ++;
            }
        } catch (Exception e) {
            System.out.print("\n### Error on row #"
                    + row + ". Please revise input or size of memory." +
                    "\n### Problem reading after: ");
            Bullet.getPrintln(bullets[i-1]);
            }
            */
    }

    /**
     * Utskrift för enhetstestning
     *
     * @param bullet
     * @param i
     */
    public static void skrivUt(Bullet bullet, int i) {
        System.out.print("i=" + i + ", " + bullet + ":\t");
        Bullet.getPrintln(bullet);
    }
}