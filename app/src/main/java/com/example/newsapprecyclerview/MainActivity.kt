package com.example.newsapprecyclerview

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    // so below is a variable name is myRecyclerView and its type is "RecyclerView"
    lateinit var myRecyclerView : RecyclerView
    lateinit var newsArrayList: ArrayList<News>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        myRecyclerView= findViewById(R.id.recyclerView)

        val newsImageArray = arrayOf(
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5,
            R.drawable.img6,
        )

        val newsHeadingArray = arrayOf(
            "U.K. Foreign Secretary James Cleverly raises issue of BBC tax searches with EAM Jaishankar",
            "Cooking gas prices hiked by ₹50 for domestic, ₹350.50 for commercial cylinders",
            "Joe Biden appoints two prominent Indian-American corporate leaders to his Export Council",
            "Sergey Lavrov will raise suspected bombing of Nord Stream II at G20: Russian Foreign Ministry",
            "Belarusian leader Lukashenko visits China amid Ukraine tensions",
            "China rips new U.S. House committee on countering Beijing",
            "Largest gathering of Foreign Ministers hosted by any G20 presidency: Foreign Secretary Vinay Kwatra"
        )

        val newsContent= arrayOf(
            getString(R.string.news_content), getString(R.string.news_content),
            getString(R.string.news_content), getString(R.string.news_content),
            getString(R.string.news_content), getString(R.string.news_content)
        )

        // it set the behaviour of items inside recyclerview, like it is vertical scrowling or horizontal scrowling
        myRecyclerView.layoutManager = LinearLayoutManager(this)
        newsArrayList= arrayListOf<News>()

        // now har ek elem pe ja ke data ko ready karna
        for( index in newsImageArray.indices){
            // so news bnate chalna h yahi pe uske liye News class ko bula ke usme heading or image pass kr denge
            val news = News(newsHeadingArray[index], newsImageArray[index], newsContent[index])
            //so agar indx=3 hai, to img3 & 3rd heading lag jaega means dono sath me aa jaenge
            // now to ab jo v img or heading sath me aa rhi h unko arraylist me add karna hai
            newsArrayList.add(news)
        }

        // now we r going to create adapter
        // so adapter is nothing but kotlin class use to conect two activity, one activity & one class
        var myAdapter= MyAdapter(newsArrayList, this)
        myRecyclerView.adapter = myAdapter
        myAdapter.setItemClickListener(object : MyAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                //by clicking on each item, what action do u want to perform?
                val intent= Intent(this@MainActivity, News2ndActivity::class.java)
                intent.putExtra("heading", newsArrayList[position].newsHeading)
                intent.putExtra("imgaeId", newsArrayList[position].newsImage)
                intent.putExtra("newscontent", newsArrayList[position].newsContent)
                startActivity(intent)
            }

        })

    }
}