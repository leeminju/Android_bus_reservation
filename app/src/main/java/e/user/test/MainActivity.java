package e.user.test;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {
 //   DBHandler controller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

 //       controller = new DBHandler(getApplicationContext());
    }

    public void bt1_clicked(View v){
        Intent intent = new Intent(this,bt1Activity.class);
        startActivity(intent);
    }

    public void bt2_clicked(View v){
        ;
    }

    public void bt3_clicked(View v){
        Intent intent = new Intent(this,LoginActvity.class);
        startActivity(intent);
    }
}
