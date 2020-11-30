package com.example.lab5

import com.google.gson.annotations.SerializedName

data class Todo(
    @SerializedName("completed")
    var completed: String,
    @SerializedName("id")
    var id: Int,
    @SerializedName("title")
    var title: String,
    @SerializedName("userId")
    var userId: Int,
    @SerializedName("detailedInfo")
    var detailedInfo: String
)