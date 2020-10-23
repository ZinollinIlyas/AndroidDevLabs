package com.example.lab5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.content_fragment.*
import kotlinx.android.synthetic.main.mail_list_content.*

class FragmentMailContent: Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.content_fragment,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val content: TextView = view.findViewById(R.id.content)
        val placeContent: TextView = view.findViewById(R.id.main_content)

        placeContent.text = content.text

        }
    }
