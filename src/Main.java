import java.io.*;
import java.util.Scanner;

/**
 * Project: Assignment 3
 * Created by: Annika Rengfelt
 * Due: 2020-11-11
 */

public class Main {

    public static final String NEW = "1";
    public static final String OPEN = "2";
    public static final String ADD = "3";
    public static final String IMPORT = "4";
    public static final String CONTINUE = "0";

    public static void main(String[] args) throws Exception {

        String userDescription;
        int userWeekday;
        String userChoice = "";
        Scanner scanner = new Scanner(System.in);
        Journal journal = Journal.getJournal();

        System.out.println("Welcome. Available choices:");
        options();

        scanner = new Scanner(System.in);
        userChoice = scanner.next();

        switch (userChoice) {
            case NEW -> {
                journal = Journal.getJournal();
                System.out.println("New journal created");
                options();
                scanner = new Scanner(System.in);
                userChoice = scanner.next();
            }
            case OPEN -> {
                userChoice = "";
                System.out.println(journal);
                options();
                scanner = new Scanner(System.in);
                userChoice = scanner.next();
            }
            case ADD -> {
                userChoice = "";
                Journal.scanTo(journal);
                System.out.println(journal);
                options();
                userChoice = "";
                scanner = new Scanner(System.in);
                try {
                    userChoice = scanner.next();
                } catch (Exception e) {
                    System.out.println("Error: " + e);
                    //Exception in thread "main" java.util.NoSuchElementException
                }
            }
            case IMPORT -> {
                Journal.importFromFile(journal);
                System.out.println(journal);
                System.out.flush();
                scanner = new Scanner(System.in);
                userChoice = scanner.next();
            }
        }
    }

    public static void options() {
        System.out.println("[" + NEW + "] " + "Start new journal".toUpperCase());
        System.out.println("[" + OPEN + "] " + "Open journal".toUpperCase());
        System.out.println("[" + ADD + "] " + "Add entries".toUpperCase());
        System.out.println("[" + IMPORT + "] " + "Import from file".toUpperCase());
        System.out.print("Your choice: ".toUpperCase());
    }
}
