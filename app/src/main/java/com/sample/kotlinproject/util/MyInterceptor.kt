package com.sample.kotlinproject.util

import okhttp3.Interceptor
import okhttp3.Response

class MyInterceptor:Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request=chain.request()


        if (UserUtil.isNetworkAvailable(CacheResponseApplication.appContext)){
            request.newBuilder().header("Cache-Control","public,  max-age=" + 5 )
                .build()
        }else{
            request.newBuilder().header("Cache-Control","public, only-if-cached , max-stale=" + 60 * 60 * 24 * 7 )
                .build()
        }
        return chain.proceed(request)
    }
}