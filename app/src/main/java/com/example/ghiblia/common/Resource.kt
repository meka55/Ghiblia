package com.example.ghiblia.common

sealed class Resource<out T>(
    val data: T? = null,
    val massage: String? = null
){
    class Loading<T> (data: T? = null) : Resource<T>(data = data)
    class Success<T> (data: T) : Resource<T>(data = data)
    class Error<T> (data: T? = null, massage: String) : Resource<T>(data = data, massage = massage)
}
