package com.example.androidjourney.ui;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;


public class MyDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "MyDatabase";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_POSTS = "posts";

    private static final String KEY_ID = "id";
    private static final String KEY_USER_ID = "user_id";
    private static final String KEY_TITLE = "title";
    private static final String  KEY_BODY = "body";


    public MyDBHelper( Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL( " CREATE TABLE " + TABLE_POSTS +"(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+ KEY_USER_ID + " INTEGER," + KEY_TITLE + " TEXT,"+ KEY_BODY + " TEXT" + ")" );
        //CREATE TABLE posts( id INTEGER PRIMARY KEY AUTOINCREMENT, user_id TEXT, title TEXT,body,TEXT)


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_POSTS);
        onCreate(db);

    }


    public  void addPosts(int  user_id, String title,String body){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_USER_ID,user_id);
        contentValues.put(KEY_TITLE,title);
        contentValues.put(KEY_BODY,body);
        db.insert(TABLE_POSTS,null,contentValues);


    }


    public ArrayList<PostsModel> fetchPosts(){

        SQLiteDatabase db = this.getReadableDatabase();
          Cursor cursor= db.rawQuery("SELECT * FROM "+ TABLE_POSTS,null);

          ArrayList<PostsModel> arrPosts = new ArrayList<>();

          while (cursor.moveToNext()){
              PostsModel postsModel = new PostsModel();
              postsModel.id = cursor.getInt(0);
              postsModel.user_id = cursor.getInt(1);
              postsModel.title = cursor.getString(2);
              postsModel.body = cursor.getString(3);

              arrPosts.add(postsModel);
          }
          return arrPosts;
    }

}
