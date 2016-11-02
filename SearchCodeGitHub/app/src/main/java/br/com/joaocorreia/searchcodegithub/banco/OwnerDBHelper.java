package br.com.joaocorreia.searchcodegithub.banco;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by joaocorreia on 30/10/16.
 */
public class OwnerDBHelper extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;

    public OwnerDBHelper(Context context) {
        super(context, OwnerContrato.DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "CREATE TABLE "+ OwnerContrato.DB_TABLE +" (" +
                        OwnerContrato._ID +" INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        OwnerContrato.COL_ID  +" TEXT UNIQUE NOT NULL, "+
                        OwnerContrato.COL_LOGIN    +" TEXT NOT NULL, "+
                        OwnerContrato.COL_EMAIL     +" TEXT NOT NULL, "+
                        OwnerContrato.COL_AVATAR   +" TEXT NOT NULL, "+
                        OwnerContrato.COL_BLOG    +" TEXT NOT NULL )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
}


