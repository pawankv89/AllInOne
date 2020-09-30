package com.pk.allinone.ui.animalnames

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
import com.pk.allinone.adapter.AnimalAdapter
import com.pk.allinone.model.Animal
import com.startapp.sdk.ads.banner.Banner
import kotlinx.android.synthetic.main.common_list_layout.view.*

class SeaAnimalNamesFragment : Fragment() {

    var mContext: Context? = null
    var adapter: AnimalAdapter? = null
    var list = ArrayList<Animal>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //Load Fragment Layout
        val root = inflater.inflate(R.layout.fragment_seaanimalnames, container, false)
        val gridView: GridView = root.findViewById(R.id.gridView)

        //Display Banner
        val banner: Banner = root.findViewById(R.id.startAppBanner)
        this.activity?.let { Singleton.displayorHideAdsBanner(it, banner) }

        creeateList(gridView)

        // move this line to last
        return root
    }

    //The onAttach (Activity activity) method was deprecated in API level 23.
    //Now to get context in  Fragment we can use onAttach (Context context)
    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    fun creeateList(gridView: GridView){

        // Add
        list.add(Animal("Turtle","(टर्टल)", "कछुआ \n(kachhuwa)"))
        list.add(Animal("Urchin","(अर्चिन)", "साही \n(Sahi)"))
        list.add(Animal("Seagull","(सीगल)", "गंगा चिली \n(Ganga chili)"))
        list.add(Animal("Seahorse","(सीहॉर्स)", "अश्वमीन \n(Aasmin)"))
        list.add(Animal("Shark","(शार्क)", "शार्क मछली \n(Shark Machhli)"))
        list.add(Animal("Squid","(स्क्विड)", "विद्रूप \n(Vidrup)"))
        list.add(Animal("Starfish","(स्टारफिश)", "समुद्री मछली \n(Samudri Machhli)"))
        list.add(Animal("Walrus","(वालरस)", "दरियाई घोडा \n(Dariyai Ghoda)"))
        list.add(Animal("Whale","(व्हेल)", "ह्वेल मछली \n(Hwel Machhli)"))
        list.add(Animal("Clams","(क्लैम)", "क्लैम एक समुद्री जानवर"))
        list.add(Animal("Coral","(कोरल)", "प्रवाल \n(Prawal)"))
        list.add(Animal("Cormorant","(कॉर्मरन्ट)", "पनकौवा \n(PanKauwa)"))
        list.add(Animal("Crab","(क्रैब)", "केकड़ा \n(Kekda)"))
        list.add(Animal("Dolphin","(डॉलफिन)", "डॉलफिन मछली"))
        list.add(Animal("Fish","(फिश)", "मछली \n(Machhli)"))
        list.add(Animal("Jellyfish","(जेलिफ़िश)", "जेल्लिफिश"))
        list.add(Animal("Lobster","(लॉबस्टर)", "झींगा-मछली \n(Jhinga machhli)"))
        list.add(Animal("Octopus","(ऑक्टोपस)", "अष्टभुज \n(Asthbhuj)"))
        list.add(Animal("Pelican","(पेलिकन)", "हवासील \n(Hawasil)"))
        list.add(Animal("Penguin","(पेंगुइन)", "समुद्री बगुला \n(Samudri Bagula)"))
        list.add(Animal("Sea lion","(सी लायन)", "जाल-सिंह \n(Jal sinh)"))

        // Set Adapter
        adapter = AnimalAdapter(mContext, list)

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
