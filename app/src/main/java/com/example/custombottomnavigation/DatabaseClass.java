package com.example.custombottomnavigation;


import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import com.example.custombottomnavigation.DaoClass.Daoclass;
import com.example.custombottomnavigation.EntityClass.UserModel;

@Database(entities = {UserModel.class},version = 1)

public abstract class DatabaseClass extends RoomDatabase {

    public abstract Daoclass getData();
    private static DatabaseClass instance;

   public static DatabaseClass getDatabase(final Context context)
    {
        if (instance==null)
        {
            synchronized (DatabaseClass.class)
            {
                instance=Room.databaseBuilder(context,DatabaseClass.class,"DATABASE").allowMainThreadQueries().build();

            }
        }
        return instance;
    }



}


