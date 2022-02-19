package com.example.retrofit.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.retrofit.model.GithubResponse
import com.example.retrofit.network.RetrofitInstance
import com.example.retrofit.network.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GithubViewModel: ViewModel() {
    var githubDataList = MutableLiveData<List<GithubResponse>>()

    fun getApiData(){
        val retrofitService=RetrofitInstance.getRetrofitInstance().create(RetrofitService::class.java)

        retrofitService.getData().enqueue(object: Callback<List<GithubResponse>>{
            override fun onResponse(
                call: Call<List<GithubResponse>>,
                response: Response<List<GithubResponse>>
            ) {
                githubDataList.value=response.body()
            }

            override fun onFailure(call: Call<List<GithubResponse>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })

        }
    }
