package com.example.midterm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.first_page.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val todo = ArrayList<Todo>()
        for (i in 1..20){
            todo.add(Todo(0+i, "Some Titile "+i, "sdfjdhsfjdsfhsadjfodjfjasdoifjosidjfoasdjfoiasjdofjasdojfosdjfoiasdjfpi", "ok", "Necessary", 5+i))
        }

        val todoListAdapter = TodoListAdapter(todo, this)
        val layoutManager = LinearLayoutManager(this)
        recycler1.layoutManager = layoutManager
        recycler1.adapter = todoListAdapter
    }
}