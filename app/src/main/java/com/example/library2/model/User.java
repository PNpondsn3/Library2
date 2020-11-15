package com.example.library2.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "users")
public class User {
    @PrimaryKey(autoGenerate = true)
    public final int id;
    public String name;
    @ColumnInfo(name = "last_name")
    public String lastName;
    public String address;
    public String status;

    public User(int id,String name, String lastName, String address, String status){
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.status = status;
    }
}
