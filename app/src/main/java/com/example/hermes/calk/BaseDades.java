package com.example.hermes.calk;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by HERMES on 10/07/2015.
 */
public class BaseDades  extends SQLiteOpenHelper {

    //Declaracion del nombre de la base de datos
    public static final int DATABASE_VERSION = 1;

    //Declaracion global de la version de la base de datos
    public static final String DATABASE_NAME = "user";

    //Declaracion del nombre de la tabla
    public static final String USERS_TABLE_NAME ="User";

    //sentencia global de cracion de la base de datos
    public static final String CREATE_USERS_TABLE = "CREATE TABLE " + USERS_TABLE_NAME + " (user TEXT PRIMARY KEY UNIQUE, password TEXT, puntuacion INTEGER, uri TEXT);";



    public BaseDades(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USERS_TABLE);
    }


    //obtener una lista de coches
    public Cursor getAllScores() {
        SQLiteDatabase db = this.getWritableDatabase();
        String[] columns = {"user","puntuacion"};
        Cursor c = db.query(
                USERS_TABLE_NAME,  // The table to query
                columns,                                // The columns to return
                null,                                   // The columns for the WHERE clause
                null,                                   // The values for the WHERE clause
                null,                                   // don't group the rows
                null,                                   // don't filter by row groups
                null                                    // The sort order
        );
        return c;
    }


    public Cursor getUriByUsername(String username) {
        SQLiteDatabase db = this.getWritableDatabase();
        String[] columns = {"uri"};
        String[] where = {username};
        Cursor c = db.query(
                USERS_TABLE_NAME,                                  // The table to query
                columns,                                    // The columns to return
                "user=?",                                   // The columns for the WHERE clause
                where,                                      // The values for the WHERE clause
                null,                                       // don't group the rows
                null,                                       // don't filter by row groups
                null                                        // The sort order
        );
        return c;
    }


    public void createUser (ContentValues values, String tableName) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(
                tableName,
                null,
                values);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {

    }
}