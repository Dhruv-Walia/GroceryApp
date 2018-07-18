package in.vibescom.groceryapp.Database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import in.vibescom.groceryapp.Models.Contact;

import static in.vibescom.groceryapp.Constants.Constants.kDATABASE_NAME;

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_CONTACT = "contacts";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_USER_ID = "userId";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_PHONE = "phone";
    private static final String COLUMN_PASS = "pass";

    public DatabaseHandler(Context context){
        super(context,kDATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_CONTACTS =
                "CREATE TABLE " + TABLE_CONTACT
                        + "("
                        + COLUMN_ID + " INTEGER PRIMARY KEY,"
                        + COLUMN_USER_ID + " INTEGER,"
                        + COLUMN_NAME + " TEXT,"
                        + COLUMN_EMAIL + " TEXT,"
                        + COLUMN_PHONE + " TEXT,"
                        + COLUMN_PASS + " TEXT"
                        + ")";

        db.execSQL(CREATE_TABLE_CONTACTS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACT);
        // Create tables again
        onCreate(db);
    }


    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }

    @SuppressLint("Recycle")
    public void addContact(Contact c){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        Cursor cursor = db.query(TABLE_CONTACT,new String[]{COLUMN_USER_ID},null,null,null,null,null);
        int count = cursor.getCount();

        contentValues.put(COLUMN_ID , count);
        contentValues.put(COLUMN_NAME , c.getName());
        contentValues.put(COLUMN_EMAIL ,c.getEmail());
        contentValues.put(COLUMN_PHONE , c.getPhone());
        contentValues.put(COLUMN_PASS, c.getPass());

        db.insert(TABLE_CONTACT, null, contentValues);
        db.close();
    }

    @SuppressLint("Recycle")
    public String getPassword(String email){

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_CONTACT, new String[]{COLUMN_EMAIL,COLUMN_PASS},null,null,null,null,null);
        String data = "not found";

        if(cursor.moveToFirst()){
            do{
                if(cursor.getString(0).equals(email)){
                    data = cursor.getString(1);
                    break;
                }
            }
            while (cursor.moveToNext());
        }
        return  data;
    }

}
