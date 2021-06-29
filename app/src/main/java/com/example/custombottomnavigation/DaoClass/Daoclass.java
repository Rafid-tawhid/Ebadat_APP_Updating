package com.example.custombottomnavigation.DaoClass;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.custombottomnavigation.EntityClass.UserModel;

import java.util.List;

@Dao
public interface Daoclass {

    @Insert
    void insertAllData(UserModel model);

    @Query("select * from user")
    List<UserModel> getAllData();


    @Delete
    void deleteData(UserModel model);
//    @Query("select * from user where `key` = :id")
//    int deleteData(int id);

}
