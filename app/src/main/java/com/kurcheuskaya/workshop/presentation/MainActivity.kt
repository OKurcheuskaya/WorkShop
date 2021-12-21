package com.kurcheuskaya.workshop.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import by.kirich1409.viewbindingdelegate.viewBinding
import com.kurcheuskaya.workshop.R
import com.kurcheuskaya.workshop.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by viewBinding()
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(
            this,
            MyViewModelFactory()
        )[(MainViewModel::class.java)]

        viewModel.getMovies()

        viewModel.listMovieList.observe(this, {
            binding.tvText.text = it[0].desc
        })
        viewModel.errorLiveData.observe(this, {
            binding.tvText.text = it
        })
    }
}