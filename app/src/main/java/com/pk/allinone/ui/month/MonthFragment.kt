package com.pk.allinone.ui.month

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
import com.pk.allinone.adapter.MonthAdapter
import com.pk.allinone.model.MonthTable
import com.startapp.sdk.ads.banner.Banner
import kotlinx.android.synthetic.main.alphabets_layout.view.*


class MonthFragment : Fragment() {

    var mContext: Context? = null
    var adapter: MonthAdapter? = null
    var list = ArrayList<MonthTable>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //Load Fragment Layout
        val root = inflater.inflate(R.layout.fragment_month, container, false)
        val gridView: GridView = root.findViewById(R.id.gridView)

        //Display Banner
        val banner: Banner = root.findViewById(R.id.startAppBanner)
        this.activity?.let { Singleton.displayorHideAdsBanner(it, banner) }

        creeateMonthList(gridView)

        // move this line to last
        return root
    }

    //The onAttach (Activity activity) method was deprecated in API level 23.
    //Now to get context in  Fragment we can use onAttach (Context context)
    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    fun creeateMonthList(gridView: GridView){

        // Add Day
        list.add(MonthTable("January","(जनवरी)","31"))
        list.add(MonthTable("February","(फ़रवरी)","28/29"))
        list.add(MonthTable("March","(मार्च)", "31"))
        list.add(MonthTable("April","(अप्रैल)", "30"))
        list.add(MonthTable("May","(मई)", "31"))
        list.add(MonthTable("June","(जून)", "30"))
        list.add(MonthTable("July","(जुलाई)", "31"))
        list.add(MonthTable("August","(अगस्त)", "31"))
        list.add(MonthTable("September","(सितंबर)", "30"))
        list.add(MonthTable("October","(अक्टूबर)", "31"))
        list.add(MonthTable("November","(नवंबर)", "30"))
        list.add(MonthTable("December","(दिसंबर)", "31"))

        // Set Adapter
        adapter = MonthAdapter(mContext, list)

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
