package com.sapphire.kotlinmvvm.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.sapphire.kotlinmvvm.R
import com.sapphire.kotlinmvvm.adapter.CustomAdapter
import com.sapphire.kotlinmvvm.databinding.ActivityMainBinding
import com.sapphire.kotlinmvvm.model.Article
import com.sapphire.kotlinmvvm.viewmodel.ArticalViewModel
import java.util.*

class MainActivity : AppCompatActivity() {

    var bindingMainBinding: ActivityMainBinding? = null
    private lateinit var linearLayoutManager: LinearLayoutManager

    private val articleArrayList: ArrayList<Article> = ArrayList<Article>()
    var articleViewModel: ArticalViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingMainBinding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_main
        )

        articleViewModel = ArticalViewModel(this.application)
        getMovieArticles()
    }

    fun setData(articles: List<Article>?) {
        val adapter = CustomAdapter(this@MainActivity, articles!!)
        bindingMainBinding?.rvList?.adapter = adapter
    }

    private fun getMovieArticles() {

        articleViewModel?.getArticleResponseLiveData()?.observe(this, androidx.lifecycle.Observer {
            Log.e("RAG", it.articles?.size.toString())
            setData(it.articles)
        })

    }
}

