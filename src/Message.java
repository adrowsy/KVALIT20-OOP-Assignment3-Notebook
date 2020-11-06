/**
 * Project: OOP - Assignment 3
 * Inspired by the Bullet Journal method.
 * Learn more by visiting https://bulletjournal.com/pages/learn
 * Created by: Annika Rengfelt
 * Submitted: 2020-11-11
 */

public class Message {

    public static final String NAME = "Digby";
    public static final String TAGLINE = "A digital notebook inspired by the Bullet Journal method";

    public static final String PRINT =
            "<Print: ".toUpperCase();

    public static final String OPEN = PRINT;

    public static final String CLEARED =
            "* Sucessfully cleared from log: ".toUpperCase();

    public static final String ADDED =
            "* Succecssfully added: ".toUpperCase();

    public static final String EOL =
            "</log>".toUpperCase();

    public static final String EOP =
            "</print> ".toUpperCase();

    public static final String WARNING =
            "! Warning: ".toUpperCase();

    public static final String ERROR =
            "# Error: ".toUpperCase();
    public static final String EMPTY_LOG =
            "! Log is empty";

    public static void welcome() {
        String welcome = "*** Welcome to " + NAME + " - " + TAGLINE + " ***";

        System.out.println(welcome);
    }

}

