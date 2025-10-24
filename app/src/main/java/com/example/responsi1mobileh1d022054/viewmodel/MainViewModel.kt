package com.example.responsi1mobileh1d022054.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.responsi1mobileh1d022054.data.model.CoachData
import com.example.responsi1mobileh1d022054.data.model.SquadData
import com.example.responsi1mobileh1d022054.data.network.RetrofitInstance
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val _squad = MutableLiveData<List<SquadData>>()
    private val _coach = MutableLiveData<CoachData>()
    val squad: LiveData<List<SquadData>> = _squad
    val coach: LiveData<CoachData> = _coach
    fun fetchData() {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getFootballData("1192d0b3bd3d486f9d084b189960404e")
                if (response.isSuccessful) {
                    val squadResult = response.body()?.squad ?: emptyList()
                    val coachResult = response.body()?.coach ?: CoachData("", "", "")
                    _squad.value = squadResult
                    _coach.value = coachResult
                    Log.d("SUCCESS_GET_DATA", "$squadResult, $coachResult")
                } else {
                    Log.e("API_ERROR", "${response.code()} ${response.message()}")
                }
            } catch (e: Exception) {
                Log.e("API_EXCEPTION", e.localizedMessage ?: "Unknown error")
            }
        }
    }
}