package com.example.detaylirecyclerview

import java.io.Serializable

data class Filmler(
    var filmId: Int,
    var filmAdi: String,
    var filmResimAdi: String,
    val filmYil: Int,
    var filmFiyat: Double,
    var filmYonetmen: String
) : Serializable {

}

