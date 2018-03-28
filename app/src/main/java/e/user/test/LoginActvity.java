package e.user.test;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.concurrent.Delayed;

/**
 * Created by USER on 2018-02-09.
 */

public class LoginActvity extends AppCompatActivity {
    DBHandler controller;

    EditText userid;
    EditText userpw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);

        controller = new DBHandler(getApplicationContext());
    }

    public void login_b_clicked(View v) {
        int idx;
        Cursor cu;
        Cursor c;
        userid = (EditText) findViewById(R.id.id);
        userpw = (EditText) findViewById(R.id.pw);

        String ID = userid.getText().toString();
        String PW = userpw.getText().toString();

        if(controller.count_useridx()==0) {
            Toast.makeText(this, "회원정보가 없습니다", Toast.LENGTH_SHORT).show();
        }
        for (int i = 0; i < controller.count_useridx() ; i++) {
            c = controller.select_userid(ID);

            if (c.getString(1).equals(ID) && c.getString(2).equals(PW)) {
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            }
            else if (c.getString(1).equals(ID) && !c.getString(2).equals(PW))
                Toast.makeText(this,"비번이 잘못 되었습니다",Toast.LENGTH_SHORT).show();
            else {
                Toast.makeText(this, "아이디가 존재하지 않습니다", Toast.LENGTH_SHORT).show();
            }
        }



    }
    public void signup_b_clicked(View v){
        Intent intent = new Intent(this,SignupActivity.class);
        startActivity(intent);
    }

    public void exit_b_clicked(View v){
        finish();
    }
}
