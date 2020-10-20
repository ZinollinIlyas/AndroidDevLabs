package com.example.midterm

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TodoListAdapter(val todo: ArrayList<Todo> , val context: Context): RecyclerView.Adapter<TodoListAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.first_page, parent, false)

        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return todo.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val todo = todo.get(position)
        holder.titleText.text = todo.title
        holder.statusText.text = todo.status
        holder.categoryText.text = todo.category

    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var titleText : TextView = view.findViewById(R.id.title)
        var statusText : TextView = view.findViewById(R.id.status)
        var categoryText : TextView = view.findViewById(R.id.category)

    }


}