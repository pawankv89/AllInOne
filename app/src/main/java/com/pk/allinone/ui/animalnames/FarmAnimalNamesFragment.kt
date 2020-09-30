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


class FarmAnimalNamesFragment : Fragment() {

    var mContext: Context? = null
    var adapter: AnimalAdapter? = null
    var list = ArrayList<Animal>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //Load Fragment Layout
        val root = inflater.inflate(R.layout.fragment_farmanimalnames, container, false)
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
        list.add(Animal("Sheep","(शीप)", "भेड़ \n(Bhed)"))
        list.add(Animal("Pig","(पिग)", "सूअर \n(Suwar)"))
        list.add(Animal("Rabbit","(रैबिट)", "खरगोश \n(Khargosh)"))
        list.add(Animal("Ox","(ऑक्स)", "बैल \n(Bail)"))
        list.add(Animal("Horse","(हॉर्स)", "घोड़ा \n(Ghoda)"))
        list.add(Animal("Mare","(मेयर)", "घोड़ी \n(Ghodi)"))
        list.add(Animal("Goat","(गोट)", "बकरी \n(Bakri)"))
        list.add(Animal("Duck","(डक)", "बत्तख \n(Batakh)"))
        list.add(Animal("Cow","(काऊ)", "गाय \n(Gay)"))
        list.add(Animal("Cock","(कॉक)", "मुर्गा \n(Murga)"))
        list.add(Animal("Hen","(हेन)", "मुर्गी \n(Murgi)"))

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
        Log.i("builder",builder.toString())*/
    }
}
