package com.amod.kotlinsharedpreferance

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var editname: EditText
    lateinit var editcity: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editname = (findViewById(R.id.edt_name))
        editcity = (findViewById(R.id.edt_city))
        findViewById<Button>(R.id.btn_save).setOnClickListener {
            // Saving the data in SharedPreferance
            savedata()
        }
        findViewById<Button>(R.id.btn_show).setOnClickListener {
            //Getting data from SharedPreferance
            getData()
        }

    }

    private fun getData() {
        val mypref_ = getSharedPreferences("mypref", MODE_PRIVATE)
        val name = mypref_.getString("name", "")
        val city = mypref_.getString("city", "")
        editname.setText(name)
        editcity.setText(city)
    }

    private fun savedata() {
        if (editname.text.isEmpty()) {
            editname.error = "Please enter a name"
            return
        }
        if (editcity.text.isEmpty()) {
            editcity.error = "Please enter City"
            return
        }
        val mypref_ = getSharedPreferences("mypref", MODE_PRIVATE)
        val editor = mypref_.edit()
        editor.putString("name", editname.text.toString())
        editor.putString("city", editcity.text.toString())
        Toast.makeText(this, "Data Saved Successfully ", Toast.LENGTH_LONG).show()
        editname.setText("")
        editcity.setText("")
    }

}