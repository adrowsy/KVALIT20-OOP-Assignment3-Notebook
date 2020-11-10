import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Project:
 * Created by: Annika Rengfelt
 * Created:
 */
public class Notebook {

    //Egenskaper hos journal
    private Note[] notebook; //En array av typen Note

    /**
     * Creating Notebooks with room for size number of notes
     *
     * @param size
     */
    public static Notebook getInstance(int size) {
        Notebook notebook = new Notebook();
        notebook.notebook = new Note[size];
        return notebook;
    }

    //TODO: Fixa
    public static void exportToFile(Notebook notebook, String fileName) {
        try {
            PrintWriter export = new PrintWriter(
                    new BufferedWriter(new FileWriter(fileName, true)));
            for (int i = 0; i < notebook.notebook.length; i++) {
                export.println(notebook.notebook[i].toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Writes new entry to next available index in array
     *
     * @return nextAvailableIndex -1 indicates no available spot
     */
    public int nextAvailableIndex() {
        int nextAvailableIndex = 0;
        boolean emptySpot = false;
        for (int i = 0; i < this.notebook.length; i++) {
            if (this.notebook[i] == null) {
                nextAvailableIndex = i;
                emptySpot = true;
                break;
            }
        }
        if (!emptySpot) {
            nextAvailableIndex = -1;
        }
        return nextAvailableIndex;
    }


    /**
     * Creates a Notebook instance with Notes from File
     *
     * @param notebook
     * @throws FileNotFoundException
     */
    public static void importFromFile(Notebook notebook, String fileName) throws FileNotFoundException {
        String userDescription = "";
        int nr = 0;
        try {
            Scanner file = new Scanner(new File(fileName));
            while (file.hasNext()) {
                userDescription += file.nextLine();
                notebook.notebook[notebook.nextAvailableIndex()] =
                        Note.getInstance(userDescription);
                nr++;
                userDescription = ""; //Nollställer userDescription inför nästa bullet
            }
        } catch (Exception e) {
            System.out.print("Warning: " + e + '\n');
            //Warning: java.util.NoSuchElementException: No line found
        }
        System.out.println("\nImporting " + nr + " notes" + " from " + fileName);
    }

    /**
     * Prints notebook entries together with index
     *
     * @return boolean true if notebook is completely empty
     */
    public boolean printWithIndex() {
        //Skriv ut varje index i journal
        //Börja med radnummer (index+1)
        int empty = 0;
        boolean emptyNotebook = false;

        for (int i = 0; i < this.notebook.length; i++) {
            int row = i + 1;
            if (notebook[i] != null)
                System.out.println(row + " " + this.notebook[i]);
            else
                empty++;
        }
        if (empty >= this.notebook.length) {
            System.out.println("\nYou can't complete tasks in an empty notebook\n");
            emptyNotebook = true;
        }
        return emptyNotebook;
    }

    public void setDone(int index) {
        try {
            if (index >= 0 && index <= notebook.length) {
                this.notebook[index].setDone();
                System.out.println("Good job with '" + this.notebook[index].getDescription().toLowerCase() + "'");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e + ". Try again.");
        }
    }

    @Override
    public String toString() {
        /*String s;
        s = ("Notebook{");
        s += ("notebook=") + (Arrays.toString(notebook));
        s += ('}');
        return s;*/
        String s = "Notebook: ";
        int empty = 0;

        for (int i = 0; i < this.notebook.length; i++) {
            if (notebook[i] != null)
                s += "\n" + " " + this.notebook[i];
            else
                empty++;
        }
        if (empty >= this.notebook.length) {
            s = "\nNotebook is empty";
        }
        return s + "\n";
    }
}

