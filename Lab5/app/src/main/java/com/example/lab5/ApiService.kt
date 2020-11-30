package com.example.lab5

import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @GET("todos")
    fun getAllTodos(): Call<MutableList<Todo>>

    @GET("todos/{id}/")
    fun getTodoById(@Path("id") todoId: Int?): Call<Todo>

    @FormUrlEncoded
    @POST("todos")
    fun addTask(
        @Field("title") title: String,
        @Field("completed") completed: String,
        @Field("detailedInfo") detailedInfo:String
    ): Call<Todo>

    @GET("users/{id}/")
    fun getUser(@Path("id") userId: Int): Call<User>
}