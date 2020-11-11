/**
 * Project: Assignment 3
 * Created by: Annika Rengfelt
 * Due: 2020-11-11
 */

public class Note {

    //Instans variables
    private int type; //Task or Done
    private String description; //Various values

    //Konstanter
    public static final int TASK = 1;
    public static final int DONE = 2;

    //Array för utskrift
    public static final String[] SYMBOLS = {null,
            "\u2022", "\u00D7", "\u2139"};
    //  • task
    //  × done
    //  ℹ information


    /**
     * Instantiating and initializes one note
     *
     * @param description what to be done
     * @return note
     */
    public static Note getInstance(String description) {
        Note n = new Note();
        n.setNote(description);
        return n;
    }

    /**
     * Returns note description
     *
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Initializes a note
     *
     * @param description what to be done
     */
    public void setNote(String description) {
        this.type = TASK; //All new instances are tasks
        this.description = description;
    }

    /**
     * Marking a note as done by changing its type to DONE
     */
    public void setDone() {
        this.type = DONE;
    }

    /**
     * Marking a note as done by changing its values to default
     */
    public void clearNote() {
        this.type = 0;
        this.description = null;
    }

    @Override
    public String toString() {
        return SYMBOLS[type] + " " + description;
    }

}
