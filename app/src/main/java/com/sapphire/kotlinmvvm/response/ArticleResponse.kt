package com.sapphire.kotlinmvvm.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.sapphire.kotlinmvvm.model.Article

class ArticleResponse {
    @SerializedName("status")
    @Expose
    public val status: String? = null

    @SerializedName("totalResults")
    @Expose
    public val totalResults: Int? = null

    @SerializedName("articles")
    @Expose
    public val articles: List<Article>? = null
}