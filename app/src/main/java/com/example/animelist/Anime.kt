package com.example.animelist

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Anime(
    val title : String,
    val photo : String,
    val description : String,
    val genre : String,
    val character : String
) : Parcelable
