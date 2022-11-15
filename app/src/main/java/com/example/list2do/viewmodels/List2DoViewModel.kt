package com.example.list2do.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.list2do.database.labels.ToDo
import com.example.list2do.database.labels.ToDoDao
import kotlinx.coroutines.launch

class List2DoViewModel(private val toDoDao: ToDoDao) : ViewModel() {

    private fun composeToDoObject(
        title: String, content: String, priority: Int, id_label: Int?
    ): ToDo {
        return ToDo(
            title = title, content = content, priority = priority, labelId = id_label
        )
    }

    private fun addNewToDo(title: String, content: String, priority: Int, id_label: Int?) {
        viewModelScope.launch {
            toDoDao.insert(
                composeToDoObject(
                    title = title,
                    content = content,
                    priority = priority,
                    id_label = id_label
                )
            )
        }
    }

    private fun updateToDo(title: String, content: String, priority: Int, id_label: Int?) {
        viewModelScope.launch {
            toDoDao.update(
                composeToDoObject(
                    title = title,
                    content = content,
                    priority = priority,
                    id_label = id_label
                )
            )
        }
    }

    private fun deleteToDo(title: String, content: String, priority: Int, id_label: Int?) {
        viewModelScope.launch {
            toDoDao.delete(
                composeToDoObject(
                    title = title,
                    content = content,
                    priority = priority,
                    id_label = id_label
                )
            )
        }
    }
}

class List2DoViewModelFactory(private val toDoDao: ToDoDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(List2DoViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return List2DoViewModel(toDoDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}