package com.example.responsi1mobileh1d022054.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.responsi1mobileh1d022054.R
import com.example.responsi1mobileh1d022054.databinding.FragmentSquadDetailBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class SquadDetailFragment(
    private val name: String,
    private val nationality: String,
    private val position: String,
    private val birthdate: String
) : BottomSheetDialogFragment() {

    private var _binding: FragmentSquadDetailBinding? = null
    private val binding get() = _binding!!

    override fun getTheme(): Int = R.style.ThemeOverlay_App_BottomSheetDialog

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSquadDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun loadData() {
        binding.textViewName.text = name
        binding.textViewPosition.text = position
        binding.textViewBirthdate.text = birthdate
        binding.textViewNationality.text = nationality
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadData()
    }

}