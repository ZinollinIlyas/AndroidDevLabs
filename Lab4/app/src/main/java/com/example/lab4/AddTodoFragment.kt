package com.example.lab4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.add_task.*
import kotlinx.android.synthetic.main.add_task.view.*

class AddTodoFragment: Fragment() {

    private lateinit var mTodoViewModel: TodoViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.add_task, container,false)

        mTodoViewModel = ViewModelProvider(this).get(TodoViewModel::class.java)

        view.submit_add_task.setOnClickListener {
            insertDataTodatabase()
        }

        return view
    }

    private fun insertDataTodatabase(){
        val title = add_title.text.toString()
        val description = add_description.text.toString()
        val status = add_status.text.toString()
        val category = add_category.text.toString()
        val duration = add_duration.text.toString()

        if (inputCheck(title, description, status, category, duration)){
            val todo = Todo(0,title,description,status,category,duration)

            mTodoViewModel.addTask(todo)

            Toast.makeText(requireContext(),"Successfuly added", Toast.LENGTH_LONG).show()

        }else{
            Toast.makeText(requireContext(),"Please fill all of the fields",Toast.LENGTH_LONG).show()
        }
    }


    private fun inputCheck(title: String, description: String, status: String, category: String, duration: String): Boolean{
        return !(title.isEmpty() && description.isEmpty() && status.isEmpty() && category.isEmpty() && duration.isEmpty())
    }
}