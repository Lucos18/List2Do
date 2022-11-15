package com.example.list2do

import android.app.Application
import com.example.list2do.database.List2DoRoomDatabase

class ToDoApplication : Application() {

    val database: List2DoRoomDatabase by lazy { List2DoRoomDatabase.getDatabase(this) }
}
