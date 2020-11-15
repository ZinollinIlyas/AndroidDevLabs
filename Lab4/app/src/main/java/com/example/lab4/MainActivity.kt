package com.example.lab4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().add(R.id.fragment_container, FragmentListTodo()).commit()

        add_task_btn.setOnClickListener{
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container,AddTodoFragment()).commit()
        }

        go_back_btn.setOnClickListener{
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container,FragmentListTodo()).commit()
        }

    }





}




