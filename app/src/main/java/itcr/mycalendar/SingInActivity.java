package itcr.mycalendar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class SingInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_in);
    }



    public void loginOnClick(View view){
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
    }




}
