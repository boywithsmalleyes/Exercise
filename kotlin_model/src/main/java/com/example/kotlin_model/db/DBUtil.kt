package com.example.kotlin_model.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase

open class DBUtil(context: Context?) {

    val dbHelper: DBHelper = DBHelper(context, "todo_list.db", null, 1)

    open fun getDbInstants(context: Context?): SQLiteDatabase {
        return dbHelper.writableDatabase
    }

    open fun closeDb(){
        dbHelper.close()
    }
}