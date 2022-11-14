package com.example.list2do.database.todo

import android.graphics.Color
import android.graphics.drawable.shapes.Shape
import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface LabelDao {

    @Query("SELECT * FROM label ORDER BY name ASC")
    fun getAllOrderedAscByName(): Flow<List<Label>>

    @Query("SELECT * FROM label WHERE name = :name ORDER BY name ASC")
    fun getLabelByNameOrderedAscByName(name: String): Flow<List<Label>>

    @Query("SELECT * FROM label WHERE name = :color ORDER BY name ASC")
    fun getLabelByColorOrderedAscByName(color: Color): Flow<List<Label>>

    @Query("SELECT * FROM label WHERE name = :shape ORDER BY name ASC")
    fun getLabelByShapeOrderedAscByName(shape: Shape): Flow<List<Label>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(label: Label)

    @Update
    suspend fun update(label: Label)

    @Delete
    suspend fun delete(label: Label)
}