package com.example.responsi1mobileh1d022054.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.responsi1mobileh1d022054.data.model.CoachData
import com.example.responsi1mobileh1d022054.databinding.ListCoachBinding

class CoachAdapter(private var coachs: List<CoachData>) :
    RecyclerView.Adapter<CoachAdapter.CoachViewHolder>() {

    inner class CoachViewHolder(val binding: ListCoachBinding) :
            RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoachViewHolder {
        val binding = ListCoachBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CoachViewHolder(binding)
    }

    override fun getItemCount(): Int = coachs.size

    override fun onBindViewHolder(holder: CoachViewHolder, position: Int) {
        val coach = coachs[position]
        holder.binding.name.text = coach.name ?: "Name Not Found"
        holder.binding.dateOfBirth.text = coach.dateOfBirth ?: "Date of Birth Not Found"
        holder.binding.nationality.text = coach.nationality ?: "Nationality Not Found"
    }

    fun updateData(newCoachs: CoachData) {
        coachs = listOf(newCoachs)
        notifyDataSetChanged()
    }

}