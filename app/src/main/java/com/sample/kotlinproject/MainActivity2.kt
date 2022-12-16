package com.sample.kotlinproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sample.kotlinproject.adapter.CustomAdapter
import com.sample.kotlinproject.interfaces.ItemClickListener
import com.sample.kotlinproject.viewmodel.MovieModel

class MainActivity2 : AppCompatActivity(), ItemClickListener {
    private lateinit var myRecyclerView:RecyclerView
    private val names= arrayListOf("Android","Java","Kolin","Js","NodeJs")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        myRecyclerView=findViewById(R.id.recyclerView)
        myRecyclerView.layoutManager=LinearLayoutManager(this)

            //  val adapter=CustomAdapter(applicationContext,names,this)

      //  myRecyclerView.adapter=adapter

        val mM: MovieModel =ViewModelProvider(this)[MovieModel::class.java]
        mM.getPopularMovies()
        mM.observeMovieLivadata().observe(this) { movieList ->
            val adapter = CustomAdapter(movieList, this)

            myRecyclerView.adapter = adapter
        }

    }

    override fun onItemClickListener(position: Int) {
        Toast.makeText(applicationContext, names[position], Toast.LENGTH_LONG).show()

    }
}