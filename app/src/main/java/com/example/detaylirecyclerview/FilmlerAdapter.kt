package com.example.detaylirecyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.detaylirecyclerview.databinding.CardTasarimBinding
import com.google.android.material.snackbar.Snackbar

class FilmlerAdapter(var mContext: Context, var filmlerListesi: List<Filmler>) :
    RecyclerView.Adapter<FilmlerAdapter.cardTasarimTutucu>() {
    inner class cardTasarimTutucu(tasarim: CardTasarimBinding) :
        RecyclerView.ViewHolder(tasarim.root) {
        var tasarim: CardTasarimBinding

        init {
            this.tasarim = tasarim
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): cardTasarimTutucu {
        val layoutInflater = LayoutInflater.from(mContext)
        val tasarim = CardTasarimBinding.inflate(layoutInflater, parent, false)
        return cardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: cardTasarimTutucu, position: Int) {
        val film = filmlerListesi[position]
        val t = holder.tasarim

        t.imageViewFilmResim.setImageResource(
            mContext.resources.getIdentifier(
                film.filmResimAdi,
                "drawable",
                mContext.packageName
            )
        )
        t.textViewFilmAdi.text = film.filmAdi
        t.textViewFilmFiyat.text = "${film.filmFiyat} ₺"
        t.buttonSepeteEkle.setOnClickListener {
            Snackbar.make(it, "${film.filmAdi} sepete eklendi", Snackbar.LENGTH_SHORT).show()
        }
        t.imageViewDahaFazla.setOnClickListener {
            val popup = PopupMenu(mContext, it)
            popup.menuInflater.inflate(R.menu.popup_menu, popup.menu)
            popup.show()

            popup.setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.action_haber_ver -> {
                        Snackbar.make(
                            t.imageViewDahaFazla,
                            "${film.filmAdi} haberdar edilmek için eklendi",
                            Snackbar.LENGTH_SHORT
                        ).show()
                        true
                    }
                    R.id.action_favorilere_ekle -> {
                        Snackbar.make(
                            t.imageViewDahaFazla,
                            "${film.filmAdi} favorilere eklendi",
                            Snackbar.LENGTH_SHORT
                        ).show()
                        true
                    }
                    else -> {
                        false
                    }
                }
            }
        }
        t.cardViewFilm.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.detayGecis(film = film)
            Navigation.findNavController(it).navigate(gecis)
        }

    }

    override fun getItemCount(): Int {
        return filmlerListesi.size
    }
}