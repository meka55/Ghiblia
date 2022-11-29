package com.example.ghiblia.data.remote.apiservices

import com.example.ghiblia.models.GhibliaModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GhibliaApi {

    @GET("films")
    suspend fun fetchGhiblia(): Response<ArrayList<GhibliaModel>>

    @GET("films/{id}")
    suspend fun fetchDetailGhiblia(
        @Path("id") id: String
    ): GhibliaModel
}