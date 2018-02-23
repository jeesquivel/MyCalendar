package itcr.mycalendar;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import itcr.mycalendar.utilities.Utilities;
import itcr.mycalendar.utilities.eConnectSQLite;

/**
 * Created by Monserrath on 22/2/2018.
 */

public class Tab3SettingsActivity  extends Fragment {
    connectSQLite conection;
    Button btnSearch,btnDelete,btnUpdate;
    EditText editText_IdUser,editText_FullName,editText_NickName,editText_Password1,editText_Password2;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.tab3settings, container, false);
        conection= new connectSQLite(getContext(), "bd_users",null,1);
        editText_IdUser = (EditText) rootView.findViewById(R.id.etxt_UserIdSettings);
        editText_FullName = (EditText) rootView.findViewById(R.id.etxt_NameUserSettings);
        editText_NickName = (EditText) rootView.findViewById(R.id.etxt_NickSettings);
        editText_Password1 =(EditText) rootView.findViewById(R.id.etxt_PassFirtsSettings);
        editText_Password2 =(EditText) rootView.findViewById(R.id.etxt_PassConfirmSettings);

        btnSearch= (Button) rootView.findViewById(R.id.btn_Search);
        btnUpdate= (Button) rootView.findViewById(R.id.btn_Update);
        btnDelete= (Button) rootView.findViewById(R.id.btn_Delete);


        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteOnClickButton();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateOnClickButton();
            }
        });







        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConsultOnClickButton();
            }
        });
        return rootView;

    }


    private void deleteOnClickButton(){
        try {
            SQLiteDatabase database = conection.getWritableDatabase();
            String[] parameter= {editText_IdUser.getText().toString()};
            database.delete(Utilities.UserTable,Utilities.idUser+"=?",parameter);
            clean();
            Toast.makeText(getContext(),"User deleted",Toast.LENGTH_LONG).show();
            database.close();
            clean();
        }catch (Exception e){
            Toast.makeText(getContext(),"Error delete User",Toast.LENGTH_LONG).show();

        }
    }


    private void updateOnClickButton(){
        try {
            SQLiteDatabase database = conection.getWritableDatabase();
            String[] parameter= {editText_IdUser.getText().toString()};
            ContentValues values= new ContentValues();
            values.put(Utilities.UserNickname,editText_NickName.getText().toString());
            values.put(Utilities.UserFullname,editText_FullName.getText().toString());
            values.put(Utilities.Passwords,editText_Password1.getText().toString());
            database.update(Utilities.UserTable,values,Utilities.idUser+"=?",parameter);
            Toast.makeText(getContext(),"Complete update",Toast.LENGTH_LONG).show();
            database.close();
        }catch (Exception e){
            Toast.makeText(getContext(),"Error in the update",Toast.LENGTH_LONG).show();

        }

    }


    private void ConsultOnClickButton(){
        SQLiteDatabase database= conection.getReadableDatabase();
        String[] parameter= {editText_IdUser.getText().toString()};
        String[] fields ={Utilities.UserNickname,Utilities.UserFullname,Utilities.Passwords};
        try {
            Cursor cursor = database.query(Utilities.UserTable,fields,Utilities.idUser+"=?",parameter,null,null,null);
            cursor.moveToFirst();
            editText_NickName.setText(cursor.getString(0));
            editText_FullName.setText(cursor.getString(1));
            editText_Password1.setText(cursor.getString(2));
            editText_Password2.setText(cursor.getString(2));
            cursor.close();
        }catch (Exception e){
            Toast.makeText(getContext(),"Unknown ID user",Toast.LENGTH_LONG).show();
        }
        database.close();

    }


    public void clean(){
        editText_IdUser.setText("");
        editText_NickName.setText("");
        editText_FullName.setText("");
        editText_Password1.setText("");
        editText_Password2.setText("");

    }


}
