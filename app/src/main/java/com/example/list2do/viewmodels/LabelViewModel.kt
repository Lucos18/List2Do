package com.example.list2do.viewmodels

import android.graphics.Color
import android.graphics.drawable.shapes.Shape
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.list2do.database.todo.Label
import com.example.list2do.database.todo.LabelDao
import kotlinx.coroutines.launch

class LabelViewModel(private val labelDao: LabelDao) : ViewModel() {

    private fun composeLabelObject(
        name: String, color: Color, shape: Shape
    ): Label {
        return Label(
            name = name, color = color, shape = shape
        )
    }

    private fun addNewLabel(
        name: String, color: Color, shape: Shape
    ) {
        viewModelScope.launch {
            labelDao.insert(
                composeLabelObject(
                    name = name,
                    color = color,
                    shape = shape,
                )
            )
        }
    }

    private fun updateLabel(
        name: String, color: Color, shape: Shape
    ) {
        viewModelScope.launch {
            labelDao.update(
                composeLabelObject(
                    name = name,
                    color = color,
                    shape = shape,
                )
            )
        }
    }

    private fun deleteLabel(
        name: String, color: Color, shape: Shape
    ) {
        viewModelScope.launch {
            labelDao.delete(
                composeLabelObject(
                    name = name,
                    color = color,
                    shape = shape,
                )
            )
        }
    }
}

class LabelViewModelFactory(private val labelDao: LabelDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LabelViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return LabelViewModel(labelDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}