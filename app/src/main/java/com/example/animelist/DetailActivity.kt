package com.example.animelist

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val tvTitle : TextView = findViewById(R.id.tvTitleDetail)
        val tvDesc : TextView = findViewById(R.id.tvDescDetail)
        val tvGenre : TextView = findViewById(R.id.tvGenreDetail)
        val tvCharacter : TextView = findViewById(R.id.tvCharacterDetail)
        val image : ImageView = findViewById(R.id.imgDetail)

        val anime = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Anime>("anime", Anime::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Anime>("anime")
        }

        if (anime != null) {
            tvTitle.text = anime.title
            tvDesc.text = anime.description
            tvGenre.text = anime.genre
            tvCharacter.text = anime.character
            Glide.with(this@DetailActivity)
                .load(anime.photo) // URL Gambar
                .into(image) // imageView mana yang akan diterapkan
        }
    }
}