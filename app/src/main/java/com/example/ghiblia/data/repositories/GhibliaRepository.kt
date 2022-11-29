package com.example.ghiblia.data.repositories

import com.example.ghiblia.base.BaseRepository
import com.example.ghiblia.data.remote.apiservices.GhibliaApi
import javax.inject.Inject

class GhibliaRepository @Inject constructor(
    private val ghibliaApi: GhibliaApi,
) : BaseRepository() {

    fun fetchGhiblia() = doRequest {
        ghibliaApi.fetchGhiblia()
    }

    fun fetchDetailGhiblia(id: String) = doRequest {
        ghibliaApi.fetchDetailGhiblia(id)
    }

}
