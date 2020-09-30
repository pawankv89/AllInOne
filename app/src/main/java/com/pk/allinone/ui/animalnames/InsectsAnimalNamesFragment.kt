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

class InsectsAnimalNamesFragment : Fragment() {

    var mContext: Context? = null
    var adapter: AnimalAdapter? = null
    var list = ArrayList<Animal>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //Load Fragment Layout
        val root = inflater.inflate(R.layout.fragment_insectsanimalnames, container, false)
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
        list.add(Animal("Ant","(एंट)", "चींटी \n(Chinti)"))
        list.add(Animal("Bee","(बी)", "मधुमक्खी \n(Madhumakhi)"))
        list.add(Animal("Beetle","(बीटल)", "भृंग \n(Bhring)"))
        list.add(Animal("Butterfly","(बटरफ्लाई)", "तितली \n(Titli)"))
        list.add(Animal("Centipede","(सेंटीपेड)", "चालीसपद \n(Chalisapad)"))
        list.add(Animal("Cockroach","(कॉकरोच)", "तिलचट्टा \n(Teelchata)"))
        list.add(Animal("Dragonfly","(ड्रैगनफ्लाई)", "तितली"))
        list.add(Animal("Fly","(फ्लाई)", "मक्खी \n(Makkhi)"))
        list.add(Animal("Grasshopper","(ग्रासऑपर)", "टिड्डी \n(Tiddi)"))
        list.add(Animal("Ladybird","(लेडीबर्ड)", "एक प्रकार की गुबरैला"))
        list.add(Animal("Louse","(लूज)", "जूं \n(Joo)"))
        list.add(Animal("Mosquito","(मस्कीटो)", "मछर \n(Machhar)"))
        list.add(Animal("Moth","(मोथ)", "कीट \n(Keet)"))
        list.add(Animal("Spider","(स्पाइडर)", "मकड़ी \n(Makdi)"))
        list.add(Animal("Worm","(वर्म)", "कृमि \n(Krimi)"))

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
