package com.example.retrofit.network

import com.example.retrofit.model.GithubResponse
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {
    @GET("/users/evgenkostrov/repos")
    fun getData():Call<List<GithubResponse>>
}