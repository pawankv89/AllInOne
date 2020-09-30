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

class PetsAnimalNamesFragment : Fragment() {

    var mContext: Context? = null
    var adapter: AnimalAdapter? = null
    var list = ArrayList<Animal>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //Load Fragment Layout
        val root = inflater.inflate(R.layout.fragment_petsanimalnames, container, false)
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
        list.add(Animal("Dog","(डॉग)", "कुत्ता \n(Kutta)"))
        list.add(Animal("Cat","(कैट)", "बिल्ली \n(Billi)"))
        list.add(Animal("Puppy","(पप्पी)", "कुत्ते का बच्चा \n(Kutte ka bachcha)"))
        list.add(Animal("Goldfish","(गोल्डफिश)", "सुनहरी मछली \n(Sunahri Machhli)"))
        list.add(Animal("Hamster","(हम्सटर)", "चूहे जैसा जानवर \n(Chuhe jaisa janwar)"))
        list.add(Animal("Mouse","(माउस)", "चूहा \n(Chuha)"))
        list.add(Animal("Parrot","(पैरेट)", "तोता \n(Tota)"))
        list.add(Animal("Rabbit","(रैबिट)", "खरगोश \n(Khargosh)"))
        list.add(Animal("Turtle","(टर्टल)", "कछुआ \n(Kachhuaa)"))

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
