package com.example.responsi1mobileh1d022054

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.responsi1mobileh1d022054.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initLayout()
        initListener()
    }

    private fun initLayout() {
        binding.layoutHistory.let {
            it.imgIcon.setImageResource(R.drawable.ball)
            it.tvLayout.setText(R.string.profile)
        }

        binding.layoutCoach.let {
            it.imgIcon.setImageResource(R.drawable.manager)
            it.tvLayout.setText(R.string.coach)
        }

        binding.layoutSquad.let {
            it.imgIcon.setImageResource(R.drawable.group)
            it.tvLayout.setText(R.string.squad)
        }
    }

    private fun initListener() {
        binding.layoutHistory.root.setOnClickListener {
            startActivity(Intent(this, History::class.java))
        }

        binding.layoutCoach.root.setOnClickListener {
            startActivity(Intent(this, Coach::class.java))
        }

        binding.layoutSquad.root.setOnClickListener {
            startActivity(Intent(this, Squad::class.java))
        }
    }
}