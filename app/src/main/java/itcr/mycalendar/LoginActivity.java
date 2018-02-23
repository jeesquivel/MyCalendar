package itcr.mycalendar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;


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


    public void iniciarButtonOnClick(View view){
        Intent intent = new Intent(this,MainMenu.class);
        startActivity(intent);
    }


    public void signUpButtonOnClick(View view){
        Intent intent=  new Intent(this,SignInActivity.class );
        startActivity(intent);
    }



}
