package com.example.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit.adapter.GithubAdapter
import com.example.retrofit.model.GithubResponse
import com.example.retrofit.viewmodel.GithubViewModel

class MainActivity : AppCompatActivity() {


    private lateinit var githubViewModel: GithubViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initVM()
    }


    private fun initVM(){
        githubViewModel=ViewModelProvider(this).get(GithubViewModel::class.java)
        githubViewModel.getApiData()
        githubViewModel.githubDataList.observe(this, Observer {
            initAdapter(it)
        })
    }
    private fun initAdapter(data:List<GithubResponse>){

        val rv=findViewById<RecyclerView>(R.id.rv)
        rv.layoutManager=LinearLayoutManager(this)
        val adapter = GithubAdapter(data)
        rv.adapter=adapter
    }
}