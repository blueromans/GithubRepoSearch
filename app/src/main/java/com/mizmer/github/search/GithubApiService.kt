package com.mizmer.github.search

import retrofit2.Call
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query
import kotlin.collections.ArrayList

interface GithubApiService {

    @GET("search/repositories")
    fun search(@Query("q") query: String, @Query("page") page: Int = 1, @Query("per_page") perPage: Int = 20): Call<RepoList>

    companion object Factory {
        fun create(): GithubApiService {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.github.com/")
                .build()

            return retrofit.create(GithubApiService::class.java);
        }
    }
}