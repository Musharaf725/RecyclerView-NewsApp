package com.example.newsapprecyclerview

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class News2ndActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_news2nd)

        val heading= intent.getStringExtra("heading")
        val newsContent= intent.getStringExtra("newscontent")
        val imageId= intent.getIntExtra("imageId", R.drawable.img1)

        val headingTV= findViewById<TextView>(R.id.newsHeading)
        val headingIV= findViewById<ImageView>(R.id.newsImage)
        val newsContentTV= findViewById<TextView>(R.id.newsContent)

        headingTV.text= heading
        newsContentTV.text= newsContent
        headingIV.setImageResource(imageId)
    }
}