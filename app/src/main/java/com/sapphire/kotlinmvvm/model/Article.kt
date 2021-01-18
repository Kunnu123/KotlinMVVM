package com.sapphire.kotlinmvvm.model

import com.google.gson.annotations.SerializedName

class Article {

    @SerializedName("title")
    public val title: String? = null

    @SerializedName("author")
    public val author: String? = null

    @SerializedName("urlToImage")
    public val urlToImage: String? = null

    @SerializedName("publishedAt")
    public val publishedAt: String? = null

    @SerializedName("description")
    public val description: String? = null
}