package com.pk.allinone.ui.statesnamewithcapital

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
import com.pk.allinone.adapter.StatesAdapter
import com.pk.allinone.model.States
import com.startapp.sdk.ads.banner.Banner
import kotlinx.android.synthetic.main.common_list_layout.view.*


class StatesNameWithCapitalFragment : Fragment() {

    var mContext: Context? = null
    var adapter: StatesAdapter? = null
    var list = ArrayList<States>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //Load Fragment Layout
        val root = inflater.inflate(R.layout.fragment_statesnamewithcapital, container, false)
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
        list.add(States("Andhra Pradesh","(आंध्र प्रदेश)", "अमरावती \n(Amravati)"))
        list.add(States("Arunachal Pradesh","(अरुणाचल प्रदेश)", "इटानगर \n(Itanagar)"))
        list.add(States("Assam","(असम)", "दिसपुर \n(Dispur)"))
        list.add(States("Bihar","(बिहार)", "पटना \n(Patna)"))
        list.add(States("Chhattisgarh","(छत्तीसगढ़)", "रायपुर \n(Raipur)"))
        list.add(States("Goa","(गोवा)", "पणजी \n(Panji)"))
        list.add(States("Gujarat","(गुजरात)", "गांधीनगर \n(Gandhinagar)"))
        list.add(States("Hariyana","(हरियाणा)", "चंडीगढ़ \n(Chandigarh)"))
        list.add(States("Himachal Pradesh","(हिमाचल प्रदेश)", "शिमला \n(Shimla)"))
        list.add(States("Jharkhand","(झारखण्ड)", "रांची \n(Ranchi)"))
        list.add(States("Karnataka","(कर्नाटक)", "बेंगलुरु \n(Bengaluru)"))
        list.add(States("Kerala","(केरल)", "तिरुवनंतपुरम  \n(Tiruvanantpuram)"))
        list.add(States("Madhya Pradesh","(मध्य प्रदेश)", "भोपाल \n(Bhopal)"))
        list.add(States("Maharastra","(महाराष्ट्र)", "मुम्बई \n(Mumbai)"))
        list.add(States("Manipur","(मणिपुर)", "इम्फाल \n(Imphal)"))
        list.add(States("Meghalaya","(मेघालय)", "शिल्लोंग \n(Shillong)"))
        list.add(States("Mizoram","(मिजोरम)", "एझवाल \n(Aizwal)"))
        list.add(States("Nagaland","(नागालैंड)", "कोहिमा \n(Kohima)"))
        list.add(States("Udisa","(उड़ीसा)", "भुबनेश्वर \n(Bhubneswar)"))
        list.add(States("Punjab","(पंजाब)", "चंडीगढ़ \n(Chandigarh)"))
        list.add(States("Rajasthan","(राजस्थान)", "जयपुर \n(Jaipur)"))
        list.add(States("Sikkim","(सिक्किम)", "गंगटोक \n(Gangtok)"))
        list.add(States("Tamil Nadu","(तमिल नाडु)", "चेन्नई \n(Chennai)"))
        list.add(States("Telangana","(तेलंगाना)", "हैदराबाद \n(Hyderabad)"))
        list.add(States("Tripura","(त्रिपुरा)", "अगरतला \n(Agartala)"))
        list.add(States("Uttar Pradesh","(उत्तर प्रदेश)", "लखनऊ \n(Lucknow)"))
        list.add(States("Uttarakhand","(उत्तराखंड)", "देहरादून \n(Dehradun)"))
        list.add(States("Paschim (West) Bengal","(पश्चिम बंगाल)", "कोलकाता \n(Kolkata)"))

        // Set Adapter
        adapter = StatesAdapter(mContext, list)

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
