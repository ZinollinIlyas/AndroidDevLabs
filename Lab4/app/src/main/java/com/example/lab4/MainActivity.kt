package com.example.lab4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var mTodoViewModel: TodoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mTodoViewModel = ViewModelProvider(this).get(TodoViewModel::class.java)

        supportFragmentManager.beginTransaction().add(R.id.fragment_container, FragmentListTodo()).commit()

        add_task_btn.setOnClickListener{
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container,AddTodoFragment()).commit()
        }

        go_back_btn.setOnClickListener{
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container,FragmentListTodo()).commit()
        }

        delete_all.setOnClickListener {
            mTodoViewModel.deleteAll()
        }

    }

    fun addTaskChangeFragment() {
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, FragmentListTodo()).commit()
    }


}




