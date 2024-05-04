package com.example.animelist

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityOptionsCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import androidx.core.util.Pair

class AnimeAdapter(private val animeList : ArrayList<Anime>) : RecyclerView.Adapter<AnimeAdapter.AnimeVH>(){
    class AnimeVH(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val tvTitle : TextView = itemView.findViewById(R.id.tvTitle)
        val tvDesc : TextView = itemView.findViewById(R.id.tvDesc)
        val img : ImageView = itemView.findViewById(R.id.img)
        val btn_detail : Button = itemView.findViewById(R.id.btn_detail)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeVH {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.card_anime, parent, false)
        return AnimeVH(view)
    }

    override fun getItemCount(): Int {
        return animeList.size
    }

    override fun onBindViewHolder(holder: AnimeVH, position: Int) {
        val (title,photo, desc, genre, character) = animeList[position]
        Glide.with(holder.itemView.context)
            .load(photo) // URL Gambar
            .into(holder.img) // imageView mana yang akan diterapkan
        holder.tvTitle.text = title
        holder.tvDesc.text = genre
        holder.btn_detail.setOnClickListener {
            val i = Intent(holder.itemView.context, DetailActivity::class.java)
            i.putExtra("anime", animeList[holder.adapterPosition])

            val optionsCompat : ActivityOptionsCompat =
                ActivityOptionsCompat.makeSceneTransitionAnimation(
                    holder.itemView.context as Activity,
                    Pair(holder.img, "profile"),
                    Pair(holder.tvTitle, "title"),
                    Pair(holder.tvDesc, "description"),
                )

            holder.itemView.context.startActivity(i, optionsCompat.toBundle())
        }
    }
}