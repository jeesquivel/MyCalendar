package itcr.mycalendar;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import itcr.mycalendar.utilities.Utilities;


/**
 * Te amo KEILYN <3
 */


public class LoginActivity extends AppCompatActivity {

    EditText nickname, password, fullname;
    connectSQLite tempConnect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tempConnect = new connectSQLite(getApplicationContext(), "bd_users",null,1);

        nickname = (EditText) findViewById(R.id.etxtNombreUsuario);
        password = (EditText) findViewById(R.id.etxtContrasena);
    }


    public void onClick(View view){
        boolean temp = checkUser();
    }


    public void iniciarButtonOnClick(View view){
        //Intent intent = new Intent(this,MainMenu.class);
        boolean resultL = checkUser();
        if (resultL == true){
            //Toast.makeText(getApplicationContext(),"The User or the password is wrong", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this,MainMenu.class);
            startActivity(intent);
        }
    }

    public void signUpButtonOnClick(View view){
        Intent intent=  new Intent(this,SignInActivity.class );
        startActivity(intent);
    }

    public boolean checkUser() {

        // array of columns to fetch
        String[] columns = {
                Utilities.UserNickname, Utilities.Passwords, Utilities.idUser
        };
        SQLiteDatabase db = tempConnect.getReadableDatabase();
        // selection criteria
        String selection = Utilities.UserNickname + " = ?" + " AND " + Utilities.Passwords + " = ?";

        // selection arguments
        String[] selectionArgs = {nickname.getText().toString(), password.getText().toString()};

        // query user table with conditions
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com' AND user_password = 'qwerty';
         */
        Cursor cursor = db.query(Utilities.UserTable, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                       //filter by row groups
                null);                      //The sort order

        int cursorCount = cursor.getCount();

        cursor.close();
        db.close();
        if (cursorCount > 0) {
            Toast.makeText(getApplicationContext(),"The User or the password is wrong", Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }
}
