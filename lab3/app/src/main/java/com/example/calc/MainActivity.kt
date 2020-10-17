package com.example.calc

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.menu.ShowableListMenu
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_calc.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    var isFragmentCalcLoaded = true;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val Change = findViewById<Button>(R.id.move_to_calculator)
        ShowFragmentHome()
        Change.setOnClickListener({if (isFragmentCalcLoaded)
            ShowFragmentCalc()
        else
            ShowFragmentHome()
        })

    }


    fun ShowFragmentHome(){
        supportFragmentManager.beginTransaction().replace(R.id.fragment_holder, FragmentHome()).commit()
        isFragmentCalcLoaded = true;
    }

    fun ShowFragmentCalc(){
        supportFragmentManager.beginTransaction().replace(R.id.fragment_holder, FragmentCalc()).commit()
        isFragmentCalcLoaded = false;
    }

}