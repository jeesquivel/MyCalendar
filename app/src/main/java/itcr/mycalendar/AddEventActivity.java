package itcr.mycalendar;

import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class AddEventActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_Save, btn_SelectHour;
    private EditText etxt_Date, etxt_Hour, etxtUbication, etxtEvent;
    private int hour,minute,tipeHour;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);
        btn_Save= (Button) findViewById(R.id.btn_Save);
        btn_SelectHour = (Button) findViewById(R.id.btn_SelectHour);

        etxt_Date=(EditText) findViewById(R.id.etxt_Date);
        etxt_Hour = (EditText) findViewById(R.id.etxt_Time);
        etxtUbication= (EditText) findViewById(R.id.etxt_Ubication);
        etxtEvent = (EditText) findViewById(R.id.etxt_Event);

        btn_SelectHour.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
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

    }
}
