package com.example.lab5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab5.MainActivity.Companion.todo
import kotlinx.android.synthetic.main.list_item.*
import kotlinx.android.synthetic.main.list_item.view.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class TodoListFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.list_item, container, false)


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        recycler_view.adapter = TodoAdapter(view.context)
        recycler_view.layoutManager = LinearLayoutManager(view.context)

        MainActivity.apiService.getAllTodos().enqueue(object: Callback<MutableList<Todo>>{
            override fun onFailure(call: Call<MutableList<Todo>>, t: Throwable) {

            }

            override fun onResponse(
                call: Call<MutableList<Todo>>,
                response: Response<MutableList<Todo>>
            ) {
                MainActivity.todo = response.body()!!
                (recycler_view.adapter as TodoAdapter).notifyDataSetChanged()
            }
        })


        add_task_btn.setOnClickListener {
            it.findNavController().navigate(R.id.action_todoListFragment_to_addTaskFragment)
        }
    }



}


