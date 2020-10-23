package com.example.lab5

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*

class LoginActivity : AppCompatActivity() {
    lateinit var sharedPreferences: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)



        login_btn.setOnClickListener{
            saveData()

        }








    }

    private fun saveData(){
        sharedPreferences = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)


        val email = emailET.text.toString()
        val password = passwordET.text.toString()

        val editor = sharedPreferences.edit()

        editor.apply{
            putString("EMAIL", email)
            putString("PASSWORD", password)
        }.apply()

        if (email.isNotEmpty() && password.isNotEmpty()){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()

            Toast.makeText(this, "Data saved", Toast.LENGTH_LONG).show()
        }




        }

    }









