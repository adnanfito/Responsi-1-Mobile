package com.example.responsi1mobileh1d022054.ui.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.responsi1mobileh1d022054.data.model.SquadData
import com.example.responsi1mobileh1d022054.databinding.ListSquadBinding
import com.example.responsi1mobileh1d022054.utils.Constants

class SquadAdapter(private var squads: List<SquadData>, private val onSquadClickListener: onSquadClickListener) :
    RecyclerView.Adapter<SquadAdapter.SquadViewHolder>() {

    inner class SquadViewHolder(val binding: ListSquadBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SquadViewHolder {
        val binding = ListSquadBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SquadViewHolder(binding)
    }

    override fun getItemCount(): Int = squads.size

    override fun onBindViewHolder(holder: SquadViewHolder, position: Int) {
        val squad = squads[position]
        holder.binding.tvName.text = squad.name ?: "Name Not Found"
        holder.binding.tvNationality.text = squad.nationality ?: "Nationality Not Found"

        holder.binding.root.setOnClickListener {
            onSquadClickListener.onSquadClick(squad)
        }

        if (squad.position in Constants.GK) {
            holder.binding.root.setCardBackgroundColor(Color.YELLOW)
        } else if (squad.position in Constants.DF) {
            holder.binding.root.setCardBackgroundColor(Color.BLUE)
        } else if (squad.position in Constants.MF) {
            holder.binding.root.setCardBackgroundColor(Color.GREEN)
        } else if (squad.position in Constants.ST) {
            holder.binding.root.setCardBackgroundColor(Color.RED)
        } else {
            holder.binding.root.setCardBackgroundColor(Color.GRAY)
        }
    }

    fun updateData(newSquads: List<SquadData>) {
        squads = newSquads
        notifyDataSetChanged()
    }

}

interface onSquadClickListener {
    fun onSquadClick(squad: SquadData)
}