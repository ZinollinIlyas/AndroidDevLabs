package com.example.lab4

import androidx.lifecycle.LiveData

class TodoRepository(private val todoDao: TodoDao) {

    val readAllData: LiveData<List<Todo>> = todoDao.readAllData()

    suspend fun addTask(todo: Todo){
        todoDao.addTask(todo)
    }
}