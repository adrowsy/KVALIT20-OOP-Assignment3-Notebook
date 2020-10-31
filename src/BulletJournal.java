import javax.swing.*;
import java.io.FileNotFoundException;

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
        bullets[i] = new Bullet();
        bullets[i].type = Bullet.TASK;
        bullets[i].description = "Something to do";
        bullets[i].weekday = Bullet.MON;
        i++;

        bullets[i] = Bullet.getInstance(Bullet.EVENT, "Something that is happening", Bullet.TUE);
        i++;

        bullets[i] = Bullet.getInstance("3 Something noted 0");
        i++;

        Bullet.printNotNull(bullets);

        /** Läs in från dialogruta. Vet inte om jag vill ha den
         //TODO: Felhantering inmatningsruta
         i = 4;
         String s = "";
         //s = JOptionPane.showInputDialog("Skriv en Bullet [typnr beskrivning veckodagnr]");
         if (!s.isEmpty()) {
         bullets[i] = Bullet.getInstance(s);
         //TODO: Skriv bättre mottagningsmeddelande
         JOptionPane.showMessageDialog(null, "Tack! Sparat punkten");
         testPrint(bullets[i], i);
         }
         */

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
    public static void testPrint(Bullet bullet, int i) {
        System.out.print("i=" + i + ", " + bullet + ":\t");
        Bullet.getPrintln(bullet);
    }
}