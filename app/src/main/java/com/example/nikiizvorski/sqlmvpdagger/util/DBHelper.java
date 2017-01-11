package com.example.nikiizvorski.sqlmvpdagger.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.HashMap;

import javax.inject.Inject;

/**
 * The type Db helper.
 */
public class DBHelper extends SQLiteOpenHelper {

    /**
     * The constant DATABASE_NAME.
     */
    public static final String DATABASE_NAME = "MyDBName.db";
    /**
     * The constant CONTACTS_TABLE_NAME.
     */
    public static final String CONTACTS_TABLE_NAME = "contacts";
    /**
     * The constant CONTACTS_COLUMN_ID.
     */
    public static final String CONTACTS_COLUMN_ID = "id";
    /**
     * The constant CONTACTS_COLUMN_NAME.
     */
    public static final String CONTACTS_COLUMN_NAME = "name";
    /**
     * The constant CONTACTS_COLUMN_EMAIL.
     */
    public static final String CONTACTS_COLUMN_EMAIL = "email";
    /**
     * The constant CONTACTS_COLUMN_STREET.
     */
    public static final String CONTACTS_COLUMN_STREET = "street";
    /**
     * The constant CONTACTS_COLUMN_CITY.
     */
    public static final String CONTACTS_COLUMN_CITY = "place";
    /**
     * The constant CONTACTS_COLUMN_PHONE.
     */
    public static final String CONTACTS_COLUMN_PHONE = "phone";
    private HashMap hp;

    /**
     * Instantiates a new Db helper.
     *
     * @param context the context
     */
    @Inject
    public DBHelper(Context context) {
        super(context, DATABASE_NAME , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "create table contacts " +
                        "(id integer primary key, name text,phone text,email text, street text,place text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS contacts");
        onCreate(db);
    }

    /**
     * Insert contact boolean.
     *
     * @param name   the name
     * @param phone  the phone
     * @param email  the email
     * @param street the street
     * @param place  the place
     * @return the boolean
     */
    public boolean insertContact (String name, String phone, String email, String street,String place) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("phone", phone);
        contentValues.put("email", email);
        contentValues.put("street", street);
        contentValues.put("place", place);
        db.insert("contacts", null, contentValues);
        return true;
    }

    /**
     * Gets data.
     *
     * @param id the id
     * @return the data
     */
    public Cursor getData(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from contacts where id="+id+"", null );
        return res;
    }

    /**
     * Number of rows int.
     *
     * @return the int
     */
    public int numberOfRows(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, CONTACTS_TABLE_NAME);
        return numRows;
    }

    /**
     * Update contact boolean.
     *
     * @param id     the id
     * @param name   the name
     * @param phone  the phone
     * @param email  the email
     * @param street the street
     * @param place  the place
     * @return the boolean
     */
    public boolean updateContact (Integer id, String name, String phone, String email, String street,String place) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("phone", phone);
        contentValues.put("email", email);
        contentValues.put("street", street);
        contentValues.put("place", place);
        db.update("contacts", contentValues, "id = ? ", new String[] { Integer.toString(id) } );
        return true;
    }

    /**
     * Delete contact integer.
     *
     * @param id the id
     * @return the integer
     */
    public Integer deleteContact (Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();

        return db.delete("contacts",
                "id = ? ",
                new String[] { Integer.toString(id) });
    }

    /**
     * Gets all cotacts.
     *
     * @return the all cotacts
     */
    public ArrayList<String> getAllCotacts() {
        ArrayList<String> array_list = new ArrayList<String>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from contacts", null );
        res.moveToFirst();

        while(!res.isAfterLast()){
            array_list.add(res.getString(res.getColumnIndex(CONTACTS_COLUMN_NAME)));
            res.moveToNext();
        }
        return array_list;
    }
}
