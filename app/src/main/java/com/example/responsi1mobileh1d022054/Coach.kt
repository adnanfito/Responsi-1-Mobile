package com.example.responsi1mobileh1d022054

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.responsi1mobileh1d022054.databinding.ActivityCoachBinding
import com.example.responsi1mobileh1d022054.ui.adapter.CoachAdapter
import com.example.responsi1mobileh1d022054.viewmodel.MainViewModel
import kotlin.getValue

class Coach : AppCompatActivity() {
    private lateinit var binding: ActivityCoachBinding
    private val viewModel: MainViewModel by viewModels()
    private val adapter = CoachAdapter(emptyList())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoachBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        viewModel.coach.observe(this) {
            adapter.updateData(it)
        }

        viewModel.fetchData()
    }

}