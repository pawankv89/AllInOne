package com.pk.allinone.ui.vegetables

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
import com.pk.allinone.adapter.VegetablesAdapter
import com.pk.allinone.model.Vegetables
import com.startapp.sdk.ads.banner.Banner
import kotlinx.android.synthetic.main.common_list_layout.view.*


class VegetablesFragment : Fragment() {

    var mContext: Context? = null
    var adapter: VegetablesAdapter? = null
    var list = ArrayList<Vegetables>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //Load Fragment Layout
        val root = inflater.inflate(R.layout.fragment_vegetables, container, false)
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
        list.add(Vegetables("Tomato","(टोमेटो)", "टमाटर \n(Tamatar)"))
        list.add(Vegetables("Onion","(ऑनियन)", "प्याज \n(Pyaj)"))
        list.add(Vegetables("Potato","(पोटैटो)", "आलू \n(Aaloo)"))
        list.add(Vegetables("Turnip","(टर्निप)", "शलजम \n(Shaljam)"))
        list.add(Vegetables("White Goose Foot","(वाइट गूस फूट)", "बथुआ \n(Bathuaa)"))
        list.add(Vegetables("Turmeric","(टर्मेरिक)", "हल्दी \n(Haldde)"))
        list.add(Vegetables("Sweet Potato","(स्वीट पोटैटो)", "शकरकंद \n(Shakarkand)"))
        list.add(Vegetables("Green Onion","(ग्रीन ऑनियन)", "हरा प्याज \n(Hara Pyaj)"))
        list.add(Vegetables("Spinach","(स्पिनच)", "पालक \n(Palak)"))
        list.add(Vegetables("Snake Gourd","(स्नेक गार्ड)", "चिचिंडा \n(Chichinda)"))
        list.add(Vegetables("Pumpkin","(पम्पकिन)", "घिया,कद्दू \n(Ghiya, Kaddu)"))
        list.add(Vegetables("Garlic","(गार्लिक)", "लहशुन \n(Lahshun)"))
        list.add(Vegetables("Fenugreek Leaf","(फेनुग्रीक लीफ)", "हरी मेथी \n(Haree Methi)"))
        list.add(Vegetables("Ginger","(जिंजर)", "अदरक \n(Adarak)"))
        list.add(Vegetables("Green Chilli","(ग्रीन चिल्ली)", "हरी मिर्च \n(Haree Mirch)"))
        list.add(Vegetables("Green Beans","(ग्रीन बीन्स)", "हरी शेम \n(Haree Shem)"))
        list.add(Vegetables("Radish","(रेडिस)", "मूली \n(Mooli)"))
        list.add(Vegetables("Jackfruit","(जैकफ्रूट)", "कटहल \n(Kathal)"))
        list.add(Vegetables("Lady Finger","(लेडी फिंगर)", "भिन्डी \n(Bhindee)"))
        list.add(Vegetables("Mushroom","(मशरूम)", "खुखड़ी \n(Khukhdi)"))
        list.add(Vegetables("Maize","(माईज)", "मक्का \n(Makka)"))
        list.add(Vegetables("Natal Plum","(नेटल पल्म)", "करुन्दा \n(Karunda)"))
        list.add(Vegetables("Mustard Greens","(मस्टर्ड ग्रीन्स)", "सरशो पत्ता \n(Sarsho patta)"))
        list.add(Vegetables("Pointed Gourd","(पॉइंटेड गार्ड)", "परवल \n(Parwal)"))
        list.add(Vegetables("Peppermint","(पेपरमिंट)", "पुदीना \n(Pudina)"))
        list.add(Vegetables("Ridged Gourd","(रिज्ड गार्ड)", "तोरी \n(Tori)"))
        list.add(Vegetables("Red Chilli","(रेड चिल्ली)", "लाल मिर्च \n(Lal Mirch)"))
        list.add(Vegetables("Peas","(पीज)", "मटर \n(Matar)"))
        list.add(Vegetables("Cucumber","(कुकुम्बर)", "खीरा \n(Kheera)"))

        // Set Adapter
        adapter = VegetablesAdapter(mContext, list)

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
