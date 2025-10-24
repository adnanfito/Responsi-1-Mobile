package com.example.responsi1mobileh1d022054.data.network

import com.example.responsi1mobileh1d022054.data.model.SearchResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface FootballDataApi {
    @GET("10")
    suspend fun getFootballData(
        @Header("X-Auth-Token") apiKey: String
    ): Response<SearchResponse>
}