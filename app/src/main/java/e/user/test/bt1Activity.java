package e.user.test;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by USER on 2018-01-17.
 */


public class bt1Activity extends Activity {

    DBHandler controller;

    ArrayList<Integer> reserve;

    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;

    int blue=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bt1_screen);

        controller = new DBHandler(getApplicationContext());


        reserve = new ArrayList<Integer>();


        button1 = findViewById(R.id.box1);
        button2 = findViewById(R.id.box2);
        button3 = findViewById(R.id.box3);
        button4 = findViewById(R.id.box4);
        button5 = findViewById(R.id.box5);
        button6 = findViewById(R.id.box6);

        if(controller.count_reserveData() == 0) {
            controller.insert_to_reserve(1, 1, 0);
            controller.insert_to_reserve(2, 2, 0);
            controller.insert_to_reserve(3, 3, 0);
            controller.insert_to_reserve(4, 4, 0);
            controller.insert_to_reserve(5, 5, 0);
            controller.insert_to_reserve(6, 6, 0);
        }
        for(int i = 0 ; i < controller.count_reserveData(); i++) {
            Cursor c;
            c = controller.select_seat(i+1);
            reserve.add(c.getInt(c.getColumnIndex("reserved")));//예약된 인덱스 번호를 arraylist에 추가

            int color = -1;

            if(reserve.get(i) == 0) {
                color = 0xFF0000FF;//파란색
            } else
                color = 0xFFFF0000;//빨간색

            if(color != -1)
                Reserve_seat(i,color,1);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                int seatnum = data.getIntExtra("seatnum",-1);
                Log.d("seatnum","seatnum : " + seatnum);

                int color = -1;
                Log.d("color", "color : " + color);

                if(seatnum >= 10) {//ok버튼
                    seatnum -= 10;
                    color = 0xFFFF0000;//빨간색
                } else if (seatnum >= 0) {
                    color = 0xFF0000FF;//파란색
                } else {
                    Toast.makeText(this,"Wrong Reservation result",Toast.LENGTH_SHORT).show();
                }

                Log.d("seatColor", "color : " + color);

                if(color != -1)
                    Reserve_seat(seatnum, color,0);
                else {
                    Toast.makeText(this,"Wrong Reservation result",Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    public void box1_clicked(View v) {
        int seatnum = 1;


        if(reserve.get(seatnum-1) == 1) {
            Toast.makeText(this,"This seat is already reserved",Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(this, infoActivity.class);

            intent.putExtra("seatnum", 0);
            startActivityForResult(intent, 1);
        }
    }

    public void box2_clicked(View v) {
        int seatnum = 2;

        if(reserve.get(seatnum-1) == 1) {
            Toast.makeText(this,"This seat is already reserved",Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(this, infoActivity.class);

            intent.putExtra("seatnum", 1);
            startActivityForResult(intent, 1);
        }
    }

    public void box3_clicked(View v) {
        int seatnum = 3;

        if(reserve.get(seatnum-1) == 1) {
            Toast.makeText(this,"This seat is already reserved",Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(this, infoActivity.class);

            intent.putExtra("seatnum", 2);
            startActivityForResult(intent, 1);
        }
    }

    public void box4_clicked(View v) {
        int seatnum = 4;

        if(reserve.get(seatnum-1) == 1) {
            Toast.makeText(this,"This seat is already reserved",Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(this, infoActivity.class);

            intent.putExtra("seatnum",3);
            startActivityForResult(intent,1);
        }
    }

    public void box5_clicked(View v) {
        int seatnum = 5;
        if(reserve.get(seatnum-1) == 1) {
            Toast.makeText(this,"This seat is already reserved",Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(this, infoActivity.class);

            intent.putExtra("seatnum", 4);
            startActivityForResult(intent, 1);
        }
    }

    public void box6_clicked(View v) {
        int seatnum = 6;

        if(reserve.get(seatnum-1) == 1) {
            Toast.makeText(this,"This seat is already reserved",Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(this, infoActivity.class);

            intent.putExtra("seatnum", 5);
            startActivityForResult(
                    intent, 1);
        }
    }

    public void Reserve_seat(int seatnum, int color, int init) {
        switch (seatnum) {
            case 0:
                button1.setBackgroundColor(color);
                break;
            case 1:
                button2.setBackgroundColor(color);
                break;
            case 2:
                button3.setBackgroundColor(color);
                break;
            case 3:
                button4.setBackgroundColor(color);
                break;
            case 4:
                button5.setBackgroundColor(color);
                break;
            case 5:
                button6.setBackgroundColor(color);
                break;
        }

        if(init == 0 && color == 0xFFFF0000) {
            controller.update_reserved(seatnum +1, 1);
            reserve.set(seatnum, 1);
        }
    }
}

