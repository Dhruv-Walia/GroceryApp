package in.vibescom.groceryapp.UI.Activities;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by HP on 7/24/2015.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "contacts.db";
    private static final String TABLENAME = "contacts";
    private static  final String COLUMN_ID = "id";
    private static  final String COLUMN_NAME = "name";
    private static  final String COLUMN_EMAIL = "email";
    private static  final String COLUMN_UNAME = "uname";
    private static  final String COLUMN_PASS = "pass";
    SQLiteDatabase db;
    private static final String TABLE_CREATE = "create table contacts(id integer primary key  not null)" +
            "name text not null,email text not null,uname text not null,pass text not null)";

    public DatabaseHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.db=db;

    }

    public void insertContact(Contact c){

        db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        String query = "select * from contacts";
        Cursor cursor = db.rawQuery(query, null);
        int count = cursor.getCount();

        contentValues.put(COLUMN_ID , count);
        contentValues.put(COLUMN_NAME , c.getName());
        contentValues.put(COLUMN_EMAIL ,c.getEmail());
        contentValues.put(COLUMN_UNAME , c.getUname());
        contentValues.put(COLUMN_PASS, c.getPass());

        db.insert(TABLENAME, null, contentValues);
        db.close();
    }

    public String searchPass(String uname){

        db = this.getReadableDatabase();
        String query = "select uname,pass from"+TABLENAME;
        Cursor cursor = db . rawQuery(query , null);
        String a,b;
        b="not found";

        if(cursor.moveToFirst()){
            do{
               a = cursor.getString(0);


                if(a.equals(uname)){
                    b = cursor.getString(1);
                    break;
                }
            }
            while (cursor.moveToNext());
        }
        return  b;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query ="DROP TABLE IF EXISTS" +TABLENAME ;
        db.execSQL(query);
        this.onCreate(db);

    }
}
