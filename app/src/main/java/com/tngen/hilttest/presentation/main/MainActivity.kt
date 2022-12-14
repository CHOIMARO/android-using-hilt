package com.tngen.hilttest.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import dagger.hilt.android.AndroidEntryPoint
import androidx.activity.viewModels
import com.tngen.hilttest.R
import com.tngen.hilttest.databinding.ActivityMainBinding
import com.tngen.hilttest.presentation.base.BaseActivity

@AndroidEntryPoint
class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>(R.layout.activity_main) {
    override val viewModel: MainViewModel by viewModels()
    override fun initData() {
        binding.viewModel = viewModel
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.note.observe(this) {
            binding.noteTitle.setText(it.title)
        }

        viewModel.house.observe(this) {
            binding.noteDescription.setText(it.count())
        }
    }

}