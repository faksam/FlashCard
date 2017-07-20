package android.fu.flashcard;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {

    public final String CREATE_TABLE =  "CREATE TABLE tblFlashCard ( " +
                                        " id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                        " title TEXT NOT NULL, " +
                                        " question TEXT NOT NULL, " +
                                        " answer TEXT NOT NULL )";

    public DBHelper(Context context, String databaseName, int version) {
        super(context,databaseName,null,version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(DBHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS tblFlashCard");
        onCreate(db);
    }
}
