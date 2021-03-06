package com.example.lab4

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TodoViewModel(application: Application): AndroidViewModel(application) {

     val readAllData: LiveData<List<Todo>>

    private val repository: TodoRepository

    init {
        val todoDao = TodoDatabase.getDatabase(application).todoDao()
        repository = TodoRepository(todoDao)
        readAllData = repository.readAllData
    }


    fun addTask(todo: Todo){
        viewModelScope.launch(Dispatchers.IO){
            repository.addTask(todo)
        }
    }

    fun deleteAll(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAll()
        }
    }


}