package com.example.list2do.database.todo

import android.graphics.Color
import android.graphics.drawable.shapes.Shape
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "label")
data class Label(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "color") val color: Color,
    @ColumnInfo(name = "shape") val shape: Shape
)
