package com.example.newsapprecyclerview

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class MyAdapter(var newsArrayList: ArrayList<News>, var context : Activity):
RecyclerView.Adapter<MyAdapter.MyViewHolder>(){

    private lateinit var myListener: onItemClickListener
    //agar koi class is interface ko implement karta hai to usko onItemClick() method ka use karna padega
    //or wo use whi hoga jo ham item ko click karenge to new interface open hoga
    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setItemClickListener(listener: onItemClickListener){
        myListener= listener
    }


    // to create new view instance
    // when layout manager fails to find a suitable view for each item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val itemView= LayoutInflater.from(parent.context).inflate(R.layout.each_row, parent, false)
        return MyViewHolder(itemView, myListener)
    }

    // populates items with data
    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
// now ab view mil gya & jagah v to ab kon sa item kon se jagah dalna hai to uske liye ye method call hoga
        val currentItem= newsArrayList[position]
        holder.hTitle.text= currentItem.newsHeading
        holder.hImage.setImageResource(currentItem.newsImage)
    }

    override fun getItemCount(): Int {
    //so basically this method ask how many items there in NewsArrayList & return no of items
        return newsArrayList.size
    }

    class MyViewHolder(itemView: View, listener: onItemClickListener): RecyclerView.ViewHolder(itemView) {
// agar layoutmanager smajh nhi pa rha ki items ko kis jagah lgana h to vo contact karta h ye method ko & then call this method
//if layoutmanager fails to find suitable view in all of those places, it call adapter MyViewHolder method
        val hTitle= itemView.findViewById<TextView>(R.id.headingTitle)
        val hImage= itemView.findViewById<ShapeableImageView>(R.id.headingImage)

        //to yha pe code init me aayega, init : short form for initialization
        //so init work as constructor to initialize variables in kotlin
        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }
}