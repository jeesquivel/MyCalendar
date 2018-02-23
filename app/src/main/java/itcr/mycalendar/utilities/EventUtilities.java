package itcr.mycalendar.utilities;

/**
 * Created by Monserrath on 22/2/2018.
 */

public class EventUtilities {
    public static final String eventsTable = "eventTable";
    public static final String userFullname = "eUserFullname";
    public static final String eventName ="eventName";
    public static final String date = "eventDate";
    public static final String place = "eventPlace";
    public static final String time = "eventTime";

    public static final String createEventTable = "CREATE TABLE "+eventsTable+" ("+userFullname+" TEXT, "
            +eventName+" TEXT, "+date+" TEXT, "+place+" TEXT" +time+"TEXT)";


}
