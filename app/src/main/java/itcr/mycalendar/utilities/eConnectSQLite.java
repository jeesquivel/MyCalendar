package itcr.mycalendar.utilities;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Monserrath on 22/2/2018.
 */

public class eConnectSQLite extends SQLiteOpenHelper {


    /**
     * Aqui se define la tabla y todos los atributos que va a tener
     */

    public eConnectSQLite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase Database) {
        Database.execSQL(EventUtilities.createEventTable);


    }

    @Override
    public void onUpgrade(SQLiteDatabase Database, int i, int i1) {
        Database.execSQL("DROP TABLE IF EXISTS event");
        onCreate(Database);

    }
}
