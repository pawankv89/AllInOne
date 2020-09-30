package com.pk.allinone.ui.alphabets

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import androidx.fragment.app.Fragment
import com.pk.allinone.R
import com.pk.allinone.Singleton
import com.pk.allinone.adapter.AlphabetAdapter
import com.pk.allinone.model.Alphabet
import com.startapp.sdk.ads.banner.Banner
import kotlinx.android.synthetic.main.alphabets_layout.view.*


class AlphabetsFragment : Fragment() {

    var mContext: Context? = null
    var adapter: AlphabetAdapter? = null
    var alphabetsList = ArrayList<Alphabet>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //Load Fragment Layout
        val root = inflater.inflate(R.layout.fragment_alphabets, container, false)
        val gridView: GridView = root.findViewById(R.id.gridView)

        //Display Banner
        val banner: Banner = root.findViewById(R.id.startAppBanner)
        this.activity?.let { Singleton.displayorHideAdsBanner(it, banner) }

        creeateAlphaetsList(gridView)

        // move this line to last
        return root
    }

    //The onAttach (Activity activity) method was deprecated in API level 23.
    //Now to get context in  Fragment we can use onAttach (Context context)
    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    fun creeateAlphaetsList(gridView: GridView){

        var c: Char
        c = 'A'
        while (c <= 'Z'){
            // Add Alphabets
            alphabetsList.add(Alphabet(c.toString()))
            ++c
        }
        // Set Adapter
        adapter = AlphabetAdapter(mContext, alphabetsList)

        // Display Adapter
        gridView.adapter = adapter
    }
}