package com.example.responsi1mobileh1d022054

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.responsi1mobileh1d022054.data.model.SquadData
import com.example.responsi1mobileh1d022054.databinding.ActivitySquadBinding
import com.example.responsi1mobileh1d022054.ui.adapter.SquadAdapter
import com.example.responsi1mobileh1d022054.ui.adapter.onSquadClickListener
import com.example.responsi1mobileh1d022054.ui.fragment.SquadDetailFragment
import com.example.responsi1mobileh1d022054.viewmodel.MainViewModel

class Squad : AppCompatActivity(), onSquadClickListener {
    private lateinit var binding: ActivitySquadBinding
    private val viewModel: MainViewModel by viewModels()
    private val adapter = SquadAdapter(emptyList(), this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySquadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        viewModel.squad.observe(this) {
            adapter.updateData(it)
        }

        viewModel.fetchData()
    }

    override fun onSquadClick(squad: SquadData) {
        squad.let { b ->
            SquadDetailFragment(
                b.name?:"-",
                b.position?:"-",
                b.dateOfBirth?:"-",
                b.nationality?:"-"
            ).show(supportFragmentManager, SquadDetailFragment::class.java.simpleName)
        }
    }
}