/**
 * Project:
 * Created by: Annika Rengfelt
 * Created:
 */
public class Display {

    /**
     * Display one bullet
     *
     * @param b Bullet
     */
    public static void display(Bullet b) {
        System.out.println(Bullet.TYPES[b.type] + " " + b.description + " @ " + Bullet.WEEKDAYS[b.weekday]);
    }

    /**
     * Display full log. Bullets appear in default or chosen order
     *
     * @param log    to display
     * @param sortBy Sort by default (null), day of week or type of task
     */
    public static void sorted(Bullet[] log, String sortBy) {
        String order;

        if (sortBy == null) {
            order = "DEFAULT";
            System.out.println("*** PRINTING LOG: " + log + " BY " + order + " ***");
            for (int j = 0; j < log.length; j++) {
                if ((log[j].type == 0) && (log[j].description == null)) ;

                    //Printing all non empty bullets
                else display(log[j]);
            }
        }

        if (sortBy == "day") {
            order = "DAY OF WEEK";
            System.out.println("*** PRINTING LOG: " + log + " BY " + order + " ***");
            for (int weekday = 0; weekday <= 7; weekday++) {
                for (int j = 0; j < log.length; j++) {
                    if ((log[j].type == 0) && (log[j].description == null)) ;
                    else if (log[j].weekday == weekday)
                        display(log[j]);
                    else ;
                }
            }
        }
        if (sortBy == "type") {
            order = "TYPE";
            System.out.println("*** PRINTING LOG: " + log + " BY " + order + " ***");
            for (int type = 0; type < Bullet.TYPES.length; type++) {
                for (int j = 0; j < log.length; j++) {
                    if ((log[j].type == 0) && (log[j].description == null)) ;
                    else if (log[j].type == type)
                        display(log[j]);
                    else ;
                }
            }
        }
        System.out.println("*** END OF LOG");
    }
}
