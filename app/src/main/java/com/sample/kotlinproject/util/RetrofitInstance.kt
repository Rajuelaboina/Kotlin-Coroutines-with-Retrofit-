package com.sample.kotlinproject.util

import com.sample.kotlinproject.api.MovieApi
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitInstance {

    val api: MovieApi by lazy {
        val cacheSize:Long = 5 * 1024 * 1024
        val TIMEOUT:Long=10
        val mycache=Cache(CacheResponseApplication.appContext.cacheDir,cacheSize)
        val okt:OkHttpClient.Builder=OkHttpClient.Builder()
        okt.cache(mycache)
        okt.connectTimeout(TIMEOUT,TimeUnit.SECONDS)
        okt.addInterceptor(MyInterceptor())
        Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/movie/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okt.build())
            .build()
            .create(MovieApi::class.java)
    }
}