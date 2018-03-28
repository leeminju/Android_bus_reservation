package e.user.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by USER on 2018-02-02.
 */

public class infoActivity extends Activity{

    int seatnum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_screen);

        Intent intent = getIntent();
        seatnum = intent.getIntExtra("seatnum",-1);

        if(seatnum < 0)
            finish();
    }

    //reserve
    public void ok_b_clicked(View v) {
        seatnum += 10;

        Intent returnIntent = new Intent();
        returnIntent.putExtra("seatnum",seatnum);
        setResult(Activity.RESULT_OK,returnIntent);

        finish();
    }

    //not reserve
    public void cancel_b_clicked(View v) {
        Intent returnIntent = new Intent();
        returnIntent.putExtra("seatnum",seatnum);
        setResult(Activity.RESULT_OK,returnIntent);

        finish();
    }

}