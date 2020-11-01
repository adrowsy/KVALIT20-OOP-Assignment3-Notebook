/**
 * Project:
 * Created by: Annika Rengfelt
 * Created:
 */
public class Test {
    /**
     * Utskrift för enhetstestning
     *
     * @param bullet
     * @param i
     */
    public static void print(Bullet bullet, int i) {
        System.out.print("i=" + i + ", " + bullet + ":\t");
        Bullet.print(bullet);
    }
}
