package com.sapphire.kotlinmvvm.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sapphire.kotlinmvvm.R
import com.sapphire.kotlinmvvm.model.Article

/**
 * Created by Belal on 6/19/2017.
 */

class CustomAdapter(val mContext: Context, val userList: List<Article>) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_each_row_movie_article, parent, false)
        return ViewHolder(v)
    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(mContext, userList[position])
    }

    //this method is giving the size of the list
    override fun getItemCount(): Int {
        return userList.size
    }

    //the class is hodling the list view
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(
            mContext: Context,
            article: Article
        ) {
            val tvTitle = itemView.findViewById(R.id.tvTitle) as TextView
            val imgViewCover = itemView.findViewById(R.id.imgViewCover) as ImageView
            val tvAuthorAndPublishedAt =
                itemView.findViewById(R.id.tvAuthorAndPublishedAt) as TextView
            val tvDescription = itemView.findViewById(R.id.tvDescription) as TextView
            tvTitle.text = article.title
            tvAuthorAndPublishedAt.text =
                "- " + article.author + " | Published At" + article.publishedAt
            tvDescription.text = article.description

            Glide.with(mContext)
                .load(article.urlToImage)
                .into(imgViewCover)
        }
    }
}