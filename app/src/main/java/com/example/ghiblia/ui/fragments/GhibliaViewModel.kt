package com.example.ghiblia.ui.fragments

import androidx.lifecycle.ViewModel
import com.example.ghiblia.data.repositories.GhibliaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject


@HiltViewModel
class GhibliaViewModel @Inject constructor(
    private val repositories: GhibliaRepository
) : ViewModel() {

    fun fetchGhiblia() = repositories.fetchGhiblia()
}