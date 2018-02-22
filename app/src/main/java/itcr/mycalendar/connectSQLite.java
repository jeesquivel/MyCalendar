package itcr.mycalendar;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import itcr.mycalendar.utilities.Utilities;

/**
 * Created by Monserrath on 22/2/2018.
 * En esta seccion se crea una base de datos
 * para tener guardada la informacion de la aplicacion
 * o sea los eventos
 */

public class connectSQLite extends SQLiteOpenHelper {


    /** Aqui se define la tabla y todos los atributos que va a tener
     */

    public connectSQLite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase dataBase) {
        /** Aqui se crea la tabla, se puede decir que aqui se inicializa*/
        dataBase.execSQL(Utilities.createUserTable);

    }

    /**
     *Esto verifica si la tabla existe y si existe, que la borre, sobre
     * escriba la que se tiene en ese momento
     */

    @Override
    public void onUpgrade(SQLiteDatabase dataBase, int oldVersion, int newVersion) {
        dataBase.execSQL("DROP TABLE IF EXISTS users");
        onCreate(dataBase);
    }
}
