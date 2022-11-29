package com.example.ghiblia.ui.fragments.detail

import androidx.lifecycle.ViewModel
import com.example.ghiblia.common.Resource
import com.example.ghiblia.data.repositories.GhibliaRepository
import com.example.ghiblia.models.GhibliaModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
@HiltViewModel
class DetailGhibliaViewModel @Inject constructor(
    private val repository :GhibliaRepository
) : ViewModel(){

    fun fetchDetailGhiblia(id: String): Flow<Resource<GhibliaModel>> {
        return repository.fetchDetailGhiblia(id)
    }
}