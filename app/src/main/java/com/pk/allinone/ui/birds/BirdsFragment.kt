package com.pk.allinone.ui.birds

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import androidx.fragment.app.Fragment
import com.pk.allinone.R
import com.pk.allinone.Singleton
import com.pk.allinone.adapter.BirdsAdapter
import com.pk.allinone.model.Birds
import com.startapp.sdk.ads.banner.Banner
import kotlinx.android.synthetic.main.alphabets_layout.view.*


class BirdsFragment : Fragment() {

    var mContext: Context? = null
    var adapter: BirdsAdapter? = null
    var list = ArrayList<Birds>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //Load Fragment Layout
        val root = inflater.inflate(R.layout.fragment_birds, container, false)
        val gridView: GridView = root.findViewById(R.id.gridView)

        //Display Banner
        val banner: Banner = root.findViewById(R.id.startAppBanner)
        this.activity?.let { Singleton.displayorHideAdsBanner(it, banner) }

        creeateBirdsList(gridView)

        // move this line to last
        return root
    }

    //The onAttach (Activity activity) method was deprecated in API level 23.
    //Now to get context in  Fragment we can use onAttach (Context context)
    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    fun creeateBirdsList(gridView: GridView){

        // Add
        list.add(Birds("Parrot","(पैरट)", "तोता \n(Tota)"))
        list.add(Birds("Cock","(कॉक)", "मुर्गा \n(Murga)"))
        list.add(Birds("Peacock","(पीकॉक)", "मोर \n(Mor)"))
        list.add(Birds("Owl","(ऑऊल)", "उल्लू \n(Ullu)"))
        list.add(Birds("Pigeon","(पिजेन)", "कबूतर \n(Kabutar)"))
        list.add(Birds("Hen","(हेन)", "मुर्गी \n(Murgi)"))
        list.add(Birds("Crow","(क्रो)", "कावा \n(Kawa)"))
        list.add(Birds("Swan","(स्वान)", "हंस \n(Hans)"))
        list.add(Birds("Duck","(डक)", "बतख \n(Batakh)"))
        list.add(Birds("Cuckoo","(कक्कू)", "कोयल \n(Koyal)"))
        list.add(Birds("Crane","(क्रेन)", "सरस \n(Saras)"))
        list.add(Birds("Dove","(डव)", "फाख्ता \n(Phakhta)"))
        list.add(Birds("Eagle","(ईगल)", "चील \n(Cheel)"))
        list.add(Birds("Nightingale","(नाईटिंगल)", "बुलबुल \n(Bulbul)"))
        list.add(Birds("Flamingo","(फ्लेमिंगो)", "राजहंस \n(RajHans)"))
        list.add(Birds("Quail","(क्यूयाल)", "बटेर \n(Bater)"))
        list.add(Birds("Partridge","(पार्ट्रिज)", "तितर \n(Titar)"))
        list.add(Birds("Ostrich","(ऑस्ट्रिच)", "सुतुरमुर्ग \n(Suturmurg)"))
        list.add(Birds("Mynah","(मैना)", "मैना \n(Maina)"))
        list.add(Birds("Kite","(काईट)", "चील \n(Cheel)"))
        list.add(Birds("Kingfisher","(किंगफ़िशर)", "राम चिरैया \n(Ram Chiraiya)"))
        list.add(Birds("Hoopoe","(हुपी)", "हुदहुद \n(Hudhud)"))
        list.add(Birds("Hawk","(हॉक)", "बाज \n(Baaj)"))
        list.add(Birds("Hawk-Cuckoo","(हॉक कक्कू)", "पपीहा \n(Papiha)"))
        list.add(Birds("Woodpecker","(वुडपीकर)", "कंठफोड़वा \n(KanthPhodwa)"))
        list.add(Birds("Wagtail","(वेगटेल)", "खंजन \n(Khanjan)"))
        list.add(Birds("Vulture","(वल्चर)", "गिद्ध \n(Giddh)"))
        list.add(Birds("Sparrow","(स्पैरो)", "गोरेया \n(Goreya)"))
        list.add(Birds("Skylark","(स्काईलार्क)", "आबबिल \n(Aabbil)"))

        // Set Adapter
        adapter = BirdsAdapter(mContext, list)

        // Display Adapter
        gridView.adapter = adapter

/*
        // Convert Model to Json
        val builder = StringBuilder()
        builder.append("[")
        list.forEach {
            builder.append(it.toString())
            builder.append(",")
        }
        builder.append("]")
        Log.i("builder",builder.toString())
 */
    }
}
