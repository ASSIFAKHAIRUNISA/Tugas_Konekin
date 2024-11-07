package com.example.tugaskonekin

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.tugaskonekin.R
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val nameTextView: TextView = findViewById(R.id.tv_name)
        val emailTextView: TextView = findViewById(R.id.tv_email)
        val avatarImageView: ImageView = findViewById(R.id.iv_avatar)

        // Retrieve data from intent
        val userName = intent.getStringExtra("user_name")
        val userEmail = intent.getStringExtra("user_email")
        val userAvatar = intent.getStringExtra("user_avatar")

        // Set data to views
        nameTextView.text = userName
        emailTextView.text = userEmail
        Picasso.get().load(userAvatar).into(avatarImageView)
    }
}
