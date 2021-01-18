package com.sapphire.kotlinmvvm.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sapphire.kotlinmvvm.response.ArticleResponse
import com.sapphire.kotlinmvvm.retrofit.ApiRequest
import com.sapphire.kotlinmvvm.retrofit.RetrofitRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ArticleRespository {

    private val TAG: String =
        com.sapphire.kotlinmvvm.repository.ArticleRespository::class.java.getSimpleName()

    val request = RetrofitRequest.buildService(ApiRequest::class.java)

    fun getMovieArticles(
        query: String?,
        key: String?
    ): LiveData<ArticleResponse?>? {
        val data: MutableLiveData<ArticleResponse?> = MutableLiveData<ArticleResponse?>()

        request.getMovieArticles(query, key)
            ?.enqueue(object : Callback<ArticleResponse?> {
                override fun onResponse(
                    call: Call<ArticleResponse?>,
                    response: Response<ArticleResponse?>
                ) {
                    Log.d(
                       TAG,
                        "onResponse response:: $response"
                    )
                    if (response.body() != null) {
                        data.setValue(response.body())
                        Log.d(
                            TAG,
                            "articles total result:: " + response.body()
                        )
                        Log.d(
                            TAG,
                            "articles size:: " + response.body()!!.articles!!.size
                        )
                        Log.d(
                            TAG,
                            "articles title pos 0:: " + response.body()!!.articles?.get(0)
                                !!.title
                        )
                    }
                }

                override fun onFailure(
                    call: Call<ArticleResponse?>,
                    t: Throwable
                ) {
                    data.setValue(null)
                }
            })
        return data
    }
}