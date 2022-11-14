/*
 * Copyright (C) 2021 The Android Open Source Project.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.list2do.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.list2do.database.labels.ToDo
import com.example.list2do.database.labels.ToDoDao
import com.example.list2do.database.todo.Label
import com.example.list2do.database.todo.LabelDao

@Database(entities = [ToDo::class, Label::class], version = 1, exportSchema = false)
abstract class List2DoRoomDatabase : RoomDatabase() {

    abstract fun toDoDao(): ToDoDao

    abstract fun labelDao(): LabelDao

    companion object {
        @Volatile
        private var INSTANCE: List2DoRoomDatabase? = null

        fun getDatabase(context: Context): List2DoRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    List2DoRoomDatabase::class.java,
                    "list2do_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
