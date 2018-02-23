package itcr.mycalendar.utilities;

/**
 * Created by Jeison on 22/02/2018.
 */

public class Utilities {

    public static final String UserTable    = "UserTable";                  // nombre de la tabla de usuarios

    public static final String idUser       = "idUser";                     // id de la tabla PRIMARY KEY
    public static final String UserNickname = "nickname";                   // USEA NAME que es un nickname
    public static final String UserFullname = "fullname";                   // Nombre completo del usuario
    public static final String Passwords    = "password";                   // contraseña del usuraio



    public static final String createUserTable = "CREATE TABLE "+UserTable+" ("+idUser+" INTEGER PRIMARY KEY, "+UserNickname+" TEXT, "+UserFullname+" TEXT, "+Passwords+" TEXT)";


}
