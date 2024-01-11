package com.example.fooddelivery;

//import static kotlin.jvm.internal.Reflection.factory;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ArrayAdapter;

import androidx.annotation.Nullable;

import com.example.fooddelivery.Models.OrderModal;

import java.util.ArrayList;

public class dBHelper extends SQLiteOpenHelper {
    final static String DBName = "mydatabase.db";
    final static int DBVersion = 2;

    public dBHelper(@Nullable Context context) {
        super(context, DBName, null, DBVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
                "create table orders" +
                        "(id integer primary key autoincrement," +
                        "name text," +
                        "phone text," +
                        "price int," +
                        "quantity int," +
                        "image int," +
                        "description text," +
                        "foodname text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP table if exists orders");
        onCreate(sqLiteDatabase);
    }

    public boolean insertOrder(String name, String phone, int price, int image, String desc, String foodName, int quantity) {
        SQLiteDatabase database = getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("phone", phone);
        values.put("price", price);
        values.put("quantity", quantity);
        values.put("image", image);
        values.put("description", desc);
        values.put("foodName", foodName);
        long id = database.insert("orders", null, values);
        if (id <= 0) {
            return false;
        } else {
            return true;
        }
    }

    public ArrayList<OrderModal> getOrders() {
        ArrayList<OrderModal> order = new ArrayList<>();
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery("Select id,foodname,image,price from orders",null);
        if(cursor.moveToFirst()){
            while (cursor.moveToNext()){
                OrderModal modal = new OrderModal();
                modal.setOrderNumber((cursor.getInt(0)+""));
                modal.setSoldItemName((cursor.getString(1)+""));
                modal.setOrderImg(cursor.getInt(2));
                modal.setPrice(cursor.getInt(3)+"");
                order.add(modal);
            }
        }
        cursor.close();
        database.close();
        return order;
    }
}
