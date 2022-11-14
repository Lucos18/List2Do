package com.example.list2do.database.labels

import androidx.room.*
import com.example.list2do.database.todo.Label
import kotlinx.coroutines.flow.Flow

@Dao
interface ToDoDao {

    @Query("SELECT * FROM to_do ORDER BY title ASC")
    fun getAllOrderedAscByTitle(): Flow<List<Label>>

    @Query("SELECT * FROM to_do WHERE title = :title ORDER BY title ASC")
    fun getToDoByTitleOrderedAscByTitle(title: String): Flow<List<Label>>

    @Query("SELECT * FROM to_do WHERE content = :content ORDER BY content ASC")
    fun getToDoByContentOrderedAscByTitle(content: String): Flow<List<Label>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(toDo: ToDo)

    @Update
    suspend fun update(toDo: ToDo)

    @Delete
    suspend fun delete(toDo: ToDo)
}