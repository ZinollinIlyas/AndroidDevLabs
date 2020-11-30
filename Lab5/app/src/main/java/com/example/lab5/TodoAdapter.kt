package com.example.lab5

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView


class TodoAdapter( val context: Context): RecyclerView.Adapter<TodoAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item_content, parent, false)
        instance = this
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return MainActivity.todo.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val todo = MainActivity.todo.get(position)
        holder.title.text = todo.title
        if (todo.completed == "true"){
            todo.completed = "done"
            holder.completed.text = todo.completed
        }else{
            todo.completed = "not done yet"
            holder.completed.text = todo.completed
        }

        holder.itemView.setOnClickListener{
            val bundle = bundleOf("taskId" to todo.id, "userId" to todo.userId)
            it.findNavController().navigate(R.id.action_todoListFragment_to_detailedPageFragment2,bundle)
        }


    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var title: TextView = view.findViewById(R.id.title)
        val completed: TextView = view.findViewById(R.id.completed)

    }

    companion object{
        lateinit var instance: TodoAdapter
    }




}
