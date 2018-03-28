package e.user.test;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


/**
 * Created by USER on 2018-02-02.
 */

public class DBOpenHelper extends SQLiteOpenHelper{
    public DBOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table reserve("+
                "idx integer, "+
                "seatnum integer, "+
                "reserved integer);";
        Log.d("DB","reserve created");

        db.execSQL(sql);

        sql = "create table user("+
                "idx integer,"+
                "id text, "+
                "pw text);";
        Log.d("DB","user created");
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "drop table if exists reserve";
        db.execSQL(sql);

        onCreate(db);
    }
}
