package com.tngen.hilttest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import dagger.hilt.android.AndroidEntryPoint
import androidx.activity.viewModels
import java.util.*
import kotlin.collections.ArrayList

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val mainViewModel: MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        findViewById<Button>(R.id.save_btn).setOnClickListener {
            mainViewModel.saveNote(
                title = findViewById<EditText>(R.id.note_title).text.toString(),
                description = findViewById<EditText>(R.id.note_description).text.toString()
            )
        }

        mainViewModel.note.observe(this, {
            findViewById<EditText>(R.id.note_title).setText(it.title)
//            findViewById<EditText>(R.id.note_description).setText(it.description)

        })

        mainViewModel.house.observe(this, {
            findViewById<EditText>(R.id.note_description).setText(it.count())
        })
    }
}