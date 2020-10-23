package com.example.lab5

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class MailListAdapter(val mail: ArrayList<Mail> , val context: Context): RecyclerView.Adapter<MailListAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.mail_list_content, parent, false)

        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mail.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val mail = mail.get(position)
        holder.nameText.text = mail.name
        holder.titleText.text = mail.title
        holder.contentText.text = mail.content


    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var nameText : TextView = view.findViewById(R.id.name)
        var titleText : TextView = view.findViewById(R.id.title)
        var contentText : TextView = view.findViewById(R.id.content)

    }




}