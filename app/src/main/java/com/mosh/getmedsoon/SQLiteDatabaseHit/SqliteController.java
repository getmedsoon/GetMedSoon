package com.mosh.getmedsoon.SQLiteDatabaseHit;

/**
 * Created by Shyam on 2/3/14.
 */


import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.HashMap;

public class SqliteController  extends SQLiteOpenHelper {
    private static final String LOGCAT = null;

    public SqliteController(Context applicationcontext) {
        super(applicationcontext, "androidsqlite.db", null, 1);
        Log.d(LOGCAT,"Created by Shyam");
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        String query;
        query = "CREATE TABLE MemberDetails ( MemberId INTEGER PRIMARY KEY, MemberName TEXT , MemberEmailId TEXT , MemberGender TEXT , DOB TEXT " +
                " , Address TEXT , PhoneNo INTEGER )";
        database.execSQL(query);
        Log.d(LOGCAT,"Member Database Created");
        System.out.println("Member Database Created");
    }
    @Override
    public void onUpgrade(SQLiteDatabase database, int version_old, int current_version) {
        String query;
        query = "DROP TABLE IF EXISTS MemberDetails";
        database.execSQL(query);
        onCreate(database);
       // System.out.println("Y the hell it is coming here");
    }

    //public void insertStudent(HashMap<String, String> queryValues) {
        public void insertStudent(String name,String gender,String DOB,String email,SharedPreferences settings) {
            System.out.println("\n\n------?>>>>"+name+gender+DOB+email);
            SQLiteDatabase database;
            database = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("MemberName", name);
            values.put("MemberGender", gender);
            values.put("DOB", DOB);
            database.insert("MemberDetails", null, values);
            database.close();
            //getMedSoonConstants.perferenceCheck=true;
           settings.edit().putBoolean("my_first_time", false).apply();
    }

   /* public int updateStudent(HashMap<String, String> queryValues) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("StudentName", queryValues.get("StudentName"));
        return database.update("Students", values, "StudentId" + " = ?", new String[] { queryValues.get("StudentId") });
        //String updateQuery = "Update  words set txtWord='"+word+"' where txtWord='"+ oldWord +"'";
        //Log.d(LOGCAT,updateQuery);
        //database.rawQuery(updateQuery, null);
        //return database.update("words", values, "txtWord  = ?", new String[] { word });
    }

    public void deleteStudent(String id) {
        Log.d(LOGCAT,"delete");
        SQLiteDatabase database = this.getWritableDatabase();
        String deleteQuery = "DELETE FROM  MemberDetails where MemberId='"+ id +"'";
        Log.d("query",deleteQuery);
        database.execSQL(deleteQuery);
    }

    public ArrayList<HashMap<String, String>> getAllStudents() {
        ArrayList<HashMap<String, String>> wordList;
        wordList = new ArrayList<HashMap<String, String>>();
        String selectQuery = "SELECT  * FROM MemberDetails";
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> map = new HashMap<String, String>();
                map.put("StudentId", cursor.getString(0));
                map.put("StudentName", cursor.getString(1));
                wordList.add(map);
            } while (cursor.moveToNext());
        }

        // return contact list
        return wordList;
    }*/

    public HashMap<String, String> getMemberInfo() {
        HashMap<String, String> wordList = new HashMap<String, String>();
        SQLiteDatabase database = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM MemberDetails";
        Cursor cursor = database.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                //HashMap<String, String> map = new HashMap<String, String>();
                wordList.put("MemberName", cursor.getString(1));
                wordList.put("EmailId", cursor.getString(2));
                wordList.put("MemberGender", cursor.getString(3));
                wordList.put("MemberDOB", cursor.getString(4));
                //wordList.add(map);
            } while (cursor.moveToNext());
        }
        return wordList;
    }
}


