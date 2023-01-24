package com.example.foodorderapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.foodorderapp.Models.OrdersModel;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

   final static String DBName = "mydatabase.db";
   final static int DBVERSION =2;           // initially 1 whenever database updates version increases


    public DBHelper(@Nullable Context context) {
        super(context, DBName, null, DBVERSION);    // context where is the database
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "create table orders"+
                        "(id integer primary key autoincrement," +
                        "name text," +
                        "phone text," +
                        "price int ," +
                        "image int," +
                        "quantity int,"+
                        "description text," +
                        "foodname text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // if first name we inserted was burger then we inserted name as pizza then burger table is DROP and new table is created where pizza is inserted
        db.execSQL("DROP table if exists orders ");

        // make the new table
        onCreate(db);
    }


    public  boolean insertOrder(String name,String phone,int price,int image,String desc,String foodName,int quantity){
        SQLiteDatabase database = getReadableDatabase();         // pick the all values from user
        ContentValues  values = new ContentValues();  //store in (key,values) pair

         /*
            id =0;
            name =1;
            phone=2;
            price=3;
            image=4;
            description =5;
            foodname=6;
            quantity=7
     */

        values.put("name",name);
        values.put("phone",phone);
        values.put("price",price);
        values.put("image",image);
        values.put("description",desc);
        values.put("foodname",foodName);
        values.put("quantity",quantity);
       long id =  database.insert("orders",null,values);
       if(id<=0){             // no value inserted
           return false;
       }
       else {
           return true;
       }
    }
    public ArrayList<OrdersModel> getOrders() {
        ArrayList<OrdersModel> orders = new ArrayList<>();
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery("Select id,foodname,image,price from orders", null);
        if (cursor.moveToFirst()) {
            while (cursor.moveToNext()) {
                OrdersModel model = new OrdersModel(0,null,null,null);
                model.setOrdernumber(cursor.getInt(0) + "");
                model.setSoldItemName(cursor.getString(1));
                model.setOrderImage(cursor.getInt(2));
                model.setPrice(cursor.getInt(3) + "");
                orders.add(model);
            }
        }
        cursor.close();
        database.close();
        return orders;
    }

    public  Cursor getOrderById(int id){

        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery("Select * from orders where id= "+ id, null);

        if(cursor!=null)
            cursor.moveToFirst();

        return cursor;

    }
    public  boolean updateOrder(String name,String phone,int price,int image,String desc,String foodName,int quantity,int id){
        SQLiteDatabase database = getReadableDatabase();         // pick the all values from user
        ContentValues  values = new ContentValues();  //store in (key,values) pair

         /*
            id =0;
            name =1;
            phone=2;
            price=3;
            image=4;
            description =5;
            food-name=6;
            quantity=7
     */

        values.put("name",name);
        values.put("phone",phone);
        values.put("price",price);
        values.put("image",image);
        values.put("description",desc);
        values.put("foodname",foodName);
        values.put("quantity",quantity);
        long row =  database.update("orders",values,"id="+id,null);
        if(row<=0){             // no value inserted
            return false;
        }
        else {
            return true;
        }
    }

    public  int deletedOrder(String id){
        SQLiteDatabase database = this.getWritableDatabase();
        return database.delete("orders","id="+id,null);
    }
}
