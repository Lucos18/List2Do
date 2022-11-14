package com.example.list2do.database.labels

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey
import com.example.list2do.database.todo.Label

@Entity(
    tableName = "to_do",
    foreignKeys = [
        ForeignKey(
            entity = Label::class,
            parentColumns = ["id"],
            childColumns = ["id_label"],
            onDelete = CASCADE
        )]
)
data class ToDo(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "content") val content: String,
    @ColumnInfo(name = "priority") val priority: Int,
    @ColumnInfo(name = "id_label") val labelId: Int
)
