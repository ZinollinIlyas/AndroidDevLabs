package com.example.lab5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.add_task_fragment.*
import kotlinx.android.synthetic.main.detailed_page.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailedPageFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.detailed_page, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        go_back_to_list.setOnClickListener {
            it.findNavController().navigate(R.id.action_detailedPageFragment2_to_todoListFragment)
        }

        val todoId = arguments?.getInt("taskId")!!
        val userId = arguments?.getInt("userId")!!

        MainActivity.apiService.getTodoById(todoId).enqueue(object : Callback<Todo> {
            override fun onFailure(call: Call<Todo>, t: Throwable) {

            }

            override fun onResponse(call: Call<Todo>, response: Response<Todo>) {
                val todo = response.body()!!
                detail_title.text = todo.title

            }

        })

        MainActivity.apiService.getUser(userId).enqueue(object : Callback<User> {
            override fun onFailure(call: Call<User>, t: Throwable) {
            }
            override fun onResponse(call: Call<User>, response: Response<User>) {
                val user = response.body()!!
                detail_email.text = user.email
                detail_name.text = user.name
            }
        })




    }

}