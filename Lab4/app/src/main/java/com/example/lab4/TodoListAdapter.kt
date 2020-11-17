package com.example.lab4

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ListAdapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.add_task.view.*
import kotlinx.android.synthetic.main.list_item_content.view.*

class TodoListAdapter: RecyclerView.Adapter<TodoListAdapter.MyViewHolder>(){

    private var todoList = emptyList<Todo>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoListAdapter.MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item_content, parent ,false))
    }

    override fun getItemCount(): Int {
        return todoList.size
    }

    override fun onBindViewHolder(holder: TodoListAdapter.MyViewHolder, position: Int) {
        val currentItem = todoList[position]
        holder.itemView.title.text = currentItem.title.toString()
        holder.itemView.status.text = currentItem.status.toString()
        holder.itemView.category.text = currentItem.category.toString()

        holder.itemView.findViewById<Button>(R.id.see_detailed_info).setOnClickListener {
            
        }
    }

    fun setData(todo: List<Todo>){
        this.todoList = todo

        notifyDataSetChanged()
    }






}