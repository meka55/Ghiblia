package com.example.ghiblia.base

import com.example.ghiblia.common.Resource
import kotlinx.coroutines.flow.flow
import java.lang.Exception

abstract class BaseRepository {
    protected fun <T> doRequest(request: suspend () -> T) = flow {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(request()))
        } catch (exception: Exception){
            emit(
                Resource.Error(
                    massage = exception.localizedMessage ?: "Error Occurred"
                )
            )
        }
    }
}