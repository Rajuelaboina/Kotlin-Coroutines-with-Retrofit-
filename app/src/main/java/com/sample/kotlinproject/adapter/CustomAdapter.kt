package com.sample.kotlinproject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.sample.kotlinproject.R
import com.sample.kotlinproject.interfaces.ItemClickListener
import com.sample.kotlinproject.model.Result

class CustomAdapter(
    private val names: List<Result>,
    private val onItemClickListener: ItemClickListener
) :
    RecyclerView.Adapter<CustomAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.row_item,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
          holder.tv.text= this.names[position].title
        holder.tv_rDate.text= this.names[position].release_date
        holder.tv_overView.text= this.names[position].overview
         Glide.with(holder.itemView)
             .load("https://image.tmdb.org/t/p/w500"+ names[position].poster_path)
             .into(holder.img)
         holder.itemView.setOnClickListener{
             onItemClickListener.onItemClickListener(position)
         }

    }

    override fun getItemCount(): Int {
       return names.size
    }
    class MyViewHolder(view: View) : ViewHolder(view) {
         val img:ImageView=view.findViewById(R.id.poster_img)
         val tv: TextView =view.findViewById(R.id.textView2)
        val tv_rDate: TextView =view.findViewById(R.id.releaseDate)
        val tv_overView: TextView =view.findViewById(R.id.textView_overview)

    }
}