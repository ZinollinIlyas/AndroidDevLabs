package com.example.lab5

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.add_task_fragment.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class AddTaskFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.add_task_fragment, container, false)


        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        go_back_btn.setOnClickListener {
            it.findNavController().navigate(R.id.action_addTaskFragment_to_todoListFragment)
        }

        submit_add_task_btn.setOnClickListener {

            val title = add_title.text.toString()
            val completed = add_completion.text.toString()
            val detailedInfo = add_detailed_info.text.toString()

            MainActivity.apiService.addTask(
                title,completed,detailedInfo
            ).enqueue(object : Callback<Todo> {
                override fun onFailure(call: Call<Todo>, t: Throwable) {
                    Log.e("error", t.message.toString())
                }

                override fun onResponse(call: Call<Todo>, response: Response<Todo>) {
                    Log.e("Response body: ", response.body()!!.toString())
                    val task = response.body()!!
                    MainActivity.todo.add(task)
                    TodoAdapter.instance.notifyDataSetChanged()
                    Toast.makeText(requireContext(),"Successfuly added",Toast.LENGTH_LONG).show()
                }
            })


            it.findNavController().navigate(R.id.action_addTaskFragment_to_todoListFragment)
        }
    }

//fun addTask(){
//    val apiService = RestApiService()
//
//
//    val title = add_title.text.toString()
//    val completed = add_completion.text.toString()
//    val detailedInfo = add_detailed_info.text.toString()
//    var id = 200
//    val userId = 1
//
//    val todo = Todo(completed,id++,title,userId,detailedInfo)
//
//    apiService.addTask(todo){
//        if (completed.isEmpty() && title.isEmpty() && detailedInfo.isEmpty()){
//            Toast.makeText(requireContext(),"Fill all fields", Toast.LENGTH_LONG).show()
//            Log.d("message","added")
//        }else {
//            Toast.makeText(requireContext(), "Successfuly added", Toast.LENGTH_LONG).show()
//        }
//    }
//
//
//}


}