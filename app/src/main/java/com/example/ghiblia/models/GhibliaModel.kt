package com.example.ghiblia.models

import com.example.ghiblia.base.IBaseDiffutils
import com.google.gson.annotations.SerializedName

class GhibliaModel(
    @SerializedName("id")
    override val id: String,

    @SerializedName("title")
    val title: String,

    @SerializedName("producer")
    val producer: String,

    @SerializedName("description")
    val description: String,

    @SerializedName("image")
    val image: String
) : IBaseDiffutils