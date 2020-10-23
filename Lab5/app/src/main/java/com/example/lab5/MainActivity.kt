package com.example.lab5

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.mail_list_content.*
import kotlinx.android.synthetic.main.mail_list_fragment.*

class MainActivity : AppCompatActivity() {

    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        sharedPreferences = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)

        val email = sharedPreferences.getString("EMAIL", "")

        if (email.isNullOrEmpty()){
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        emailTV.text = "User: "+ email



        logout_btn.setOnClickListener{
            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.clear()
            editor.apply()

            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }


        supportFragmentManager.beginTransaction().add(R.id.mail_list, FragmentMailList()).commit()




    }


}