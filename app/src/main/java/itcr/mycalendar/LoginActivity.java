package itcr.mycalendar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }



    public void iniciarButtonOnClick(View view){
        Intent intent = new Intent(this,MainMenu.class);
        startActivity(intent);
    }


    public void signUpButtonOnClick(View view){
        Intent intent=  new Intent(this,SingInActivity.class );
        startActivity(intent);
    }



}