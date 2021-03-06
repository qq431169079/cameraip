package com.saigoncoder.cameraipmodule.db;

/**
 * Created by tiencao on 6/18/16.
 */

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.saigoncoder.cameraipmodule.db.table.CameraTable;
import com.saigoncoder.cameraipmodule.model.CameraDB;

import java.util.ArrayList;

public class MySQLiteDataSource {
    // Database fields

    private SQLiteDatabase database;
    private MySQLiteHelper dbHelper;

    public MySQLiteDataSource(Context context) {
        dbHelper = new MySQLiteHelper(context);

    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public int addCamera(CameraDB item){
        open();
        CameraTable table = new CameraTable();
        int id = table.insertRecord(database, item);
        close();
        return id;
    }

    public void updateCamera(CameraDB item){
        open();
        CameraTable table = new CameraTable();
        table.updateRecord(database, item);
        close();
    }


    public ArrayList<CameraDB> getCameras(int user, int type){
        open();
        CameraTable table = new CameraTable();
        ArrayList<CameraDB> list = table.readRecords(database,user,type);
        close();
        return list;
    }

    public void deleteCamera(String token){
        open();
        CameraTable table = new CameraTable();
        table.deleteRecord(database, token);
        close();
    }

    public void deleteCamera(int id){
        open();
        CameraTable table = new CameraTable();
        table.deleteRecord(database, id);
        close();
    }

    public void clearCamera(){
        open();
        CameraTable table = new CameraTable();
        table.clearTable(database);
        close();
    }

    public void updatePassword(String did, String password){
        open();
        CameraTable table = new CameraTable();
        table.clearTable(database);
        close();
    }


}

