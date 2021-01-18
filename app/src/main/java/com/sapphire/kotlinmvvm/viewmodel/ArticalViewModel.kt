package com.sapphire.kotlinmvvm.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.sapphire.kotlinmvvm.constants.AppConstant.Companion.API_KEY
import com.sapphire.kotlinmvvm.constants.AppConstant.Companion.ARTICLE_QUERY
import com.sapphire.kotlinmvvm.repository.ArticleRespository
import com.sapphire.kotlinmvvm.response.ArticleResponse

class ArticalViewModel(application: Application) : AndroidViewModel(application) {
    private var articleResponseLiveData: LiveData<ArticleResponse>? = null
    val articleRepository : ArticleRespository = ArticleRespository()
    fun getArticleResponseLiveData(): LiveData<ArticleResponse>? {
        articleResponseLiveData = articleRepository.getMovieArticles(ARTICLE_QUERY, API_KEY) as LiveData<ArticleResponse>
        return articleResponseLiveData
    }
}