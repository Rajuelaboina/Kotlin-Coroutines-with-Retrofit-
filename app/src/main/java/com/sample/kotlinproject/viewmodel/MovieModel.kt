package com.sample.kotlinproject.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sample.kotlinproject.util.RetrofitInstance
import com.sample.kotlinproject.model.Movies
import com.sample.kotlinproject.model.Result
import retrofit2.Call
import retrofit2.Response

class MovieModel:ViewModel() {
    var movieLiveData=MutableLiveData<List<Result>>()
   // lateinit var progressBar:ProgressBar
    fun getPopularMovies(){
       // retrofit2=RetrofitInstance.api.getPopularMovies("69d66957eebff9666ea46bd464773cf0")

       // RetrofitInstance.api.getPopularMovies("69d66957eebff9666ea46bd464773cf0").enqueue(object :Cal)
        val response= RetrofitInstance.api.getPopularMovies("69d66957eebff9666ea46bd464773cf0")
        // progressBar.visibility=View.VISIBLE
        response.enqueue(object :  retrofit2.Callback<Movies> {
           override fun onResponse(call: Call<Movies>, response: Response<Movies>) {
               Log.e("RESPONSE<><>",""+response.body())

               if (response.isSuccessful)
                   movieLiveData.value=response.body()!!.results
            }

            override fun onFailure(call: Call<Movies>, t: Throwable) {
                Log.e("RESPONSE",""+t.message.toString())
            }
        })

       //  Coroutines ===========  ////

    }
    fun observeMovieLivadata() : MutableLiveData<List<Result>> {
        return movieLiveData

    }
}