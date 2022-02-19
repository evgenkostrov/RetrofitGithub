package com.example.retrofit.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit.R
import com.example.retrofit.model.GithubResponse

class GithubAdapter(private val mList:List<GithubResponse>):RecyclerView.Adapter<GithubAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val title: TextView =itemView.findViewById(R.id.tvTitle)
        val date: TextView =itemView.findViewById(R.id.tvDate)



    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubAdapter.ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_git,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: GithubAdapter.ViewHolder, position: Int) {
        holder.title.text=mList[position].name
        holder.date.text=mList[position].created_at

    }

    override fun getItemCount(): Int {
      return mList.size
    }


}