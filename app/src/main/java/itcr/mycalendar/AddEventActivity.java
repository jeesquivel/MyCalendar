package itcr.mycalendar;

import android.app.TimePickerDialog;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

import itcr.mycalendar.utilities.EventUtilities;
import itcr.mycalendar.utilities.eConnectSQLite;

public class AddEventActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_Save, btn_SelectHour;
    private EditText etxt_Date, etxt_Hour, etxtUbication, etxtEvent;
    private int hour,minute,tipeHour;

    connectSQLite consulConnect;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //consulConnect = new connectSQLite(getApplicationContext(),"bd_users",null,1);

        setContentView(R.layout.activity_add_event);
        btn_Save= (Button) findViewById(R.id.btn_Save);
        btn_SelectHour = (Button) findViewById(R.id.btn_SelectHour);

        etxt_Date=(EditText) findViewById(R.id.etxt_Date);
        etxt_Date.setText(getIntent().getExtras().getString("DATE_KEY"));
        etxt_Hour = (EditText) findViewById(R.id.etxt_Time);
        etxtUbication= (EditText) findViewById(R.id.etxt_Ubication);
        etxtEvent = (EditText) findViewById(R.id.etxt_Event);

        btn_SelectHour.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        eventRegister();
    }

    private void eventRegister (){
        eConnectSQLite connect =  new eConnectSQLite(this, "bd_event", null, 1 );
        //SQLiteDatabase db = connect.getWritableDatabase();

        final Calendar calendar=  Calendar.getInstance();
        hour= calendar.get(Calendar.HOUR_OF_DAY);
        minute= calendar.get(Calendar.MINUTE);
        tipeHour= calendar.get(Calendar.AM_PM);
        TimePickerDialog timePickerDialog= new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute){
                etxt_Hour.setText(hourOfDay+":"+minute+" ");
            }

        },hour,minute,false);
        timePickerDialog.show();

        ContentValues values = new ContentValues();
        values.put(EventUtilities.eventName, etxtEvent.toString());
        values.put(EventUtilities.date, etxt_Date.toString());
        values.put(EventUtilities.place, etxtUbication.toString());
        values.put(EventUtilities.time, etxt_Hour.toString());

    }
}
