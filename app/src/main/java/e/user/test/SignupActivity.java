package e.user.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by USER on 2018-02-09.
 */

public class SignupActivity extends Activity {
    DBHandler controller;

    static int i=0;

    EditText userid;
    EditText userpw;
    EditText userpw2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_screen);

        controller = new DBHandler(getApplicationContext());

    }

    public void signup_b_clicked(View v){

        userid=(EditText)findViewById(R.id.id);
        userpw=(EditText)findViewById(R.id.pw);
        userpw2=(EditText)findViewById(R.id.pwcheck);

        String ID =userid.getText().toString();
        String PW=userpw.getText().toString();
        String PW2=userpw2.getText().toString();

        if(ID.length() == 0)//공백 입력시
        {
            Toast.makeText(this,"아이디를 입력하세요",Toast.LENGTH_SHORT).show();
        }
        else if(PW.length() == 0)//공백 입력시
        {
            Toast.makeText(this,"비밀번호를 입력하세요",Toast.LENGTH_SHORT).show();
        }
        else {
            if (!PW.equals(PW2)) {
                Toast.makeText(this, "비밀번호가 다릅니다.", Toast.LENGTH_SHORT).show();
            } else {
                controller.insert_to_user(controller.count_useridx(),ID,PW);
                Log.d("index","index:"+controller.count_useridx());
                Intent intent = new Intent(this, LoginActvity.class);
                startActivity(intent);
            }
        }

    }
}
