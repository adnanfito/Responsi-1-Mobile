package com.example.responsi1mobileh1d022054.data.model

import com.google.gson.annotations.SerializedName

data class SearchResponse(
    @SerializedName ("coach")
    val coach: CoachData,
    @SerializedName ("squad")
    val squad: List<SquadData>
)

data class CoachData(
    @SerializedName ("name")
    val name: String,
    @SerializedName ("dateOfBirth")
    val dateOfBirth: String,
    @SerializedName ("nationality")
    val nationality: String
)

data class SquadData(
    @SerializedName ("name")
    val name: String,
    @SerializedName ("position")
    val position: String,
    @SerializedName ("dateOfBirth")
    val dateOfBirth: String,
    @SerializedName ("nationality")
    val nationality: String
)
