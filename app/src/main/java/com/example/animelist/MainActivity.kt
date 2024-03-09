package com.example.animelist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var btn_about : Button
    private val list = ArrayList<Anime>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.RecyclerView)
        recyclerView.setHasFixedSize(true)
        list.addAll(getList())
        showRecyclerList()

        btn_about = findViewById(R.id.btn_about)
        btn_about.setOnClickListener{
            val i = Intent(this@MainActivity, AboutActivity::class.java)
            startActivity(i)
        }
    }

    private fun showRecyclerList() {
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        val animeAdapter = AnimeAdapter(list)
        recyclerView.adapter = animeAdapter
    }

    private fun getList(): ArrayList<Anime> {
        val title = resources.getStringArray(R.array.data_title)
        val photo = resources.getStringArray(R.array.data_photo)
        val description = resources.getStringArray(R.array.data_description)
        val genre = resources.getStringArray(R.array.data_genre)
        val character = resources.getStringArray(R.array.data_character)
        val listAnime = ArrayList<Anime>()
        for (i in title.indices) {
            val anime = Anime(title[i], photo[i], description[i], genre[i], character[i])
            listAnime.add(anime)
        }
        return listAnime
    }
}