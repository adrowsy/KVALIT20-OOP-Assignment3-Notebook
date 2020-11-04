import java.io.FileNotFoundException;

/**
 * Project: OOP - Assignment 3
 * Inspired by the Bullet Journal method.
 * Learn more by visiting https://bulletjournal.com/pages/learn
 * Created by: Annika Rengfelt
 * Created:
 */
public class JournalDemo {

    public static final String DAYS = "sorted by day";
    public static final String TYPE = "sorted by type";

    public static void main(String[] args) throws FileNotFoundException {

        //scenario();
        Message.welcome();
        Journal.options();

    }

    public static void scenario() throws FileNotFoundException {

    }
}