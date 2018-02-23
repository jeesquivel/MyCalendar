package itcr.mycalendar;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import itcr.mycalendar.utilities.Utilities;

import static itcr.mycalendar.R.*;

public class SignInActivity extends AppCompatActivity {

    EditText idUserField,nameField, nicknameField, passwordField, confirmPass;
    String mensaje;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_sign_in);

        idUserField= (EditText) findViewById(id.etxt_IdUser);
        nameField = (EditText) findViewById(id.etxt_Fullname);
        nicknameField = (EditText) findViewById(id.etxt_Nickname);
        passwordField = (EditText) findViewById(id.etxt_Password);
        confirmPass = (EditText) findViewById(id.etxt_ConfirmPassword);



    }

    public void onClick(View view){

        userRegister();
    }

    private void userRegister(){
        connectSQLite conn = new connectSQLite(this, "bd_users", null, 1);
        SQLiteDatabase db = conn.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Utilities.idUser,idUserField.getText().toString());
        values.put(Utilities.UserNickname,nicknameField.getText().toString());
        values.put(Utilities.UserFullname,nameField.getText().toString());
        values.put(Utilities.Passwords,passwordField.getText().toString());

        Long idResult = db.insert(Utilities.UserTable, Utilities.UserFullname,values);
        if (idResult==-1){
            mensaje="Error";
        }else{
            mensaje="Correct Sing in";
        }
        Toast.makeText(getApplicationContext(),mensaje, Toast.LENGTH_SHORT).show();
        db.close();

    }
}
