package com.example.detaylirecyclerview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.detaylirecyclerview.databinding.FragmentAnasayfaBinding

class AnasayfaFragment : Fragment() {
    private lateinit var tasarim: FragmentAnasayfaBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tasarim = FragmentAnasayfaBinding.inflate(inflater, container, false)

        tasarim.toolbarAnasayfa.title = "Filmler"
        tasarim.rv.layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        val filmlerListesi = ArrayList<Filmler>()
        val f1 = Filmler(1, "Anadoluda", "anadoluda", 2008, 7.0, "Nuri Bilge Ceylan")
        val f2 = Filmler(2, "Django", "django", 2009, 15.0, "Nuri Bilge Ceylan")
        val f3 = Filmler(3, "Inception", "inception", 2006, 8.0, "Nuri Bilge Ceylan")
        val f4 = Filmler(4, "Interstellar", "interstellar", 2013, 18.0, "Nuri Bilge Ceylan")
        val f5 = Filmler(5, "The Hateful Eight", "thehatefuleight", 2011, 7.0, "Nuri Bilge Ceylan")
        val f6 = Filmler(6, "The Pianist", "thepianist", 2000, 7.0, "Nuri Bilge Ceylan")
        filmlerListesi.add(f1)
        filmlerListesi.add(f2)
        filmlerListesi.add(f3)
        filmlerListesi.add(f4)
        filmlerListesi.add(f5)
        filmlerListesi.add(f6)

        val adapter = FilmlerAdapter(requireContext(), filmlerListesi)
        tasarim.rv.adapter = adapter

        return tasarim.root
    }

}