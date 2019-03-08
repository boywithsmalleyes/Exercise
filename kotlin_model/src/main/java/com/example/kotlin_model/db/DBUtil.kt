package com.example.kotlin_model.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase

class DBUtil(context: Context?) {

    val dbHelper: DBHelper = DBHelper(context, "todo_list", null, 1)

    fun getDbInstants(context: Context?): SQLiteDatabase {
        return DBHelper(context, "todo_list", null, 1).writableDatabase
    }
}