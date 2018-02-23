package itcr.mycalendar;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;


/**
 * Created by Monserrath on 22/2/2018.
 */

public class Tab1CalendarActivity  extends  Fragment  {

    Button btnSaveEvent;
    DatePicker datePicker;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab1calendario, container, false);
        btnSaveEvent = (Button) rootView.findViewById(R.id.btn_AddEvent);
        datePicker = (DatePicker) rootView.findViewById(R.id.dp_Calendary);


        btnSaveEvent.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getActivity(),AddEventActivity.class);
                String month = Integer.toString(datePicker.getMonth()+1);
                String year = Integer.toString(datePicker.getYear());
                String day = Integer.toString(datePicker.getDayOfMonth());
                intent.putExtra("DATE_KEY",day+"/"+month+"/"+year);
                startActivity(intent);
            }
        });

        return rootView;
    }






}
