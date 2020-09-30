package com.pk.allinone.ui.fruits

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
import com.pk.allinone.adapter.FruitsAdapter
import com.pk.allinone.model.Fruits
import com.startapp.sdk.ads.banner.Banner
import kotlinx.android.synthetic.main.common_list_layout.view.*


class FruitsFragment : Fragment() {

    var mContext: Context? = null
    var adapter: FruitsAdapter? = null
    var list = ArrayList<Fruits>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //Load Fragment Layout
        val root = inflater.inflate(R.layout.fragment_fruits, container, false)
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
        list.add(Fruits("Apple","(एप्पल)", "शेब \n(Sheb)"))
        list.add(Fruits("Banana","(बनाना)", "केला \n(Kela)"))
        list.add(Fruits("Coconut","(कोकोनट)", "नारियल \n(Nariyal)"))
        list.add(Fruits("Orange","(ऑरेंज)", "संतरा \n(Santra)"))
        list.add(Fruits("Pineapple","(पाइनएप्पल)", "अनानास \n(Ananas)"))
        list.add(Fruits("Papaya","(पपाया)", "पपीता \n(Papita)"))
        list.add(Fruits("Mango","(मैंगो)", "आम \n(Aam)"))
        list.add(Fruits("Guava","(गुआवा)", "अमरुद \n(Amrud)"))
        list.add(Fruits("Lemon","(लेमन)", "निम्बू \n(Nimboo)"))
        list.add(Fruits("Watermelon","(वाटरमेलन)", "तरबूज \n(Tarbooj)"))
        list.add(Fruits("Wood Apple","(वुड एप्पल)", "बेल \n(Bel)"))
        list.add(Fruits("Apricots","(एप्रिकोट्स)", "खुबानी \n(Khubanee)"))
        list.add(Fruits("Almond","(आलमंड)", "बादाम \n(Badam)"))
        list.add(Fruits("Avocado","(एवोकाडो)", "मक्खनफल \n(MakkhanPhal)"))
        list.add(Fruits("Barberry","(बारबेर्री)", "दारुहल्दी \n(Daruhaldi)"))
        list.add(Fruits("Black Currant","(ब्लैक करंट)", "फालशेब \n(Falsheb)"))
        list.add(Fruits("Blackberry","(ब्लैकबेरी)", "जामुन \n(Jamun)"))
        list.add(Fruits("Blueberry","(ब्लुबेर्री)", "नीलबदरी \n(Neelbadri)"))
        list.add(Fruits("Breadfruit","(ब्रेडफ्रूट)", "विलायती फल \n(Vilayti phal)"))
        list.add(Fruits("Cashews","(कश्यु)", "काजू \n(Kajoo)"))
        list.add(Fruits("Cherry","(चेरी)", "चेरी फल \n(Cheri phal)"))
        list.add(Fruits("Custard Apple","(कस्टर्ड एप्पल)", "सरीफा \n(Sarifa)"))
        list.add(Fruits("Date fruit","(डेट फ्रूट)", "खजूर \n(Khajoor)"))
        list.add(Fruits("Fig","(फिग)", "अंजीर \n(Anjir)"))
        list.add(Fruits("Gooseberry","(गूसबेर्री)", "करोंदा \n(Karonda)"))
        list.add(Fruits("Grapes","(ग्रैप्स)", "अंगूर \n(Angur"))
        list.add(Fruits("Jackfruit","(जैकफ्रूट)", "कटहल \n(KatHal)"))
        list.add(Fruits("Lychee","(लीची)", "लीची \n(Lichee)"))
        list.add(Fruits("Mulberry","(मुल्बेर्री)", "शहतूत \n(Shahtoot)"))
        list.add(Fruits("Nut","(नट)", "अखरोट \n(Akhrot)"))
        list.add(Fruits("Peach","(पीच)", "आडू \n(Aadoo)"))
        list.add(Fruits("Pear","(पियर)", "नाशपति \n(Nashpati)"))
        list.add(Fruits("Pistachio","(पिस्ताचियो)", "पिस्ता \n(Pista)"))
        list.add(Fruits("Plum","(पल्म)", "बेर \n(Ber)"))
        list.add(Fruits("Pomegranate","(पोमेग्रेनेट)", "अनार \n(Anaar)"))
        list.add(Fruits("Raisins","(रेसिंस)", "किशमिश \n(Kishmish)"))
        list.add(Fruits("Sapota","(सपोता)", "चीकू \n(Chikoo)"))
        list.add(Fruits("Starfruit","(स्टारफ्रूट)", "कमरख \n(Kamrakh)"))
        list.add(Fruits("Sweet Lime","(स्वीट लाइम)", "मौसंबी \n(Mosambi)"))
        
        // Set Adapter
        adapter = FruitsAdapter(mContext, list)

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
