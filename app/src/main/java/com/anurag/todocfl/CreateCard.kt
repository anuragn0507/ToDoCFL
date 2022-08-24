package com.anurag.todocfl

import com.anurag.todocfl.Entity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_create_card.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CreateCard :AppCompatActivity() {
    // If you got any issue please write the orverride function as main activity
    // watch video at 29:00 min of CFL

    private lateinit var database: myDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_card)

        database= Room.databaseBuilder(
            applicationContext,myDatabase::class.java,"To_Do"
        ).build()

        save_button.setOnClickListener {
            if(create_title.text.toString().trim{it<=' '}.isNotEmpty()
                && create_priority.text.toString().trim{it<=' '}.isNotEmpty()){

                var title = create_title.getText().toString()
                var priority = create_priority.getText().toString()
                DataObject.setData(title,priority)

                GlobalScope.launch {
                    database.dao().insertTask(Entity(0,title,priority))
                }
//                GlobalScope.launch {
//                   Log.i("Anurag",database.dao().getTasks().toString())
//                }
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
            }
        }
    }
}