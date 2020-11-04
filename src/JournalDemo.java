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

    public static void main(String[] args) {

        //scenario();
        Message.welcome(); // *** Welcome to Digby - A digital notebook inspired by the Bullet Journal method ***
        Journal.options();

        //Journal j1 = Journal.createJournal("title"); //* SUCCECSSFULLY ADDED: New journal title
        //System.out.println(j1); //title


    }
}