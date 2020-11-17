package com.example.lab4

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface TodoDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
     suspend fun addTask( todo: Todo)

    @Delete
    fun deleteTask( todo: Todo)

    @Query("SELECT * FROM todo ORDER BY id ASC")
    fun readAllData(): LiveData<List<Todo>>

    @Query("DELETE FROM todo")
    suspend fun deleteAll()
}