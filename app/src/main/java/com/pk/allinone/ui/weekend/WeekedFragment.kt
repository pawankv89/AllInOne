package com.pk.allinone.ui.weekend
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
import com.pk.allinone.adapter.WeekendAdapter
import com.pk.allinone.model.WeekendTable
import com.startapp.sdk.ads.banner.Banner
import kotlinx.android.synthetic.main.alphabets_layout.view.*


class WeekedFragment : Fragment() {

    var mContext: Context? = null
    var adapter: WeekendAdapter? = null
    var list = ArrayList<WeekendTable>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //Load Fragment Layout
        val root = inflater.inflate(R.layout.fragment_weekend, container, false)
        val gridView: GridView = root.findViewById(R.id.gridView)

        //Display Banner
        val banner: Banner = root.findViewById(R.id.startAppBanner)
        this.activity?.let { Singleton.displayorHideAdsBanner(it, banner) }

        creeateWeekendList(gridView)

        // move this line to last
        return root
    }

    //The onAttach (Activity activity) method was deprecated in API level 23.
    //Now to get context in  Fragment we can use onAttach (Context context)
    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    fun creeateWeekendList(gridView: GridView){

        // Add Day
        //list.add(WeekendTable("Days In English","उच्चारण", "Days In Hindi"))
        list.add(WeekendTable("Sunday","(सन्डे)", "रबिवार \n(Ravivar)"))
        list.add(WeekendTable("Monday","(मंडे)", "सोमवार \n(Somvar)"))
        list.add(WeekendTable("Tuesday","(ट्यूजडे)", "मंगलवार \n(Mangalvar)"))
        list.add(WeekendTable("Wednesday","(वेडनेसडे)", "बुधवार \n(Budhvar)"))
        list.add(WeekendTable("Thursday","(थर्सडे)", "गुरुवार \n(Guruvar)"))
        list.add(WeekendTable("Friday","(फ्राइडे)", "शुक्रवार \n(Shukrvar)"))
        list.add(WeekendTable("Saturday","(सैटरडे)", "शनिवार \n(Shanivar)"))

        // Set Adapter
        adapter = WeekendAdapter(mContext, list)

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

/*
Days In English	उच्चारण	Days In Hindi
Sunday	(सन्डे)	रबिवार (Ravivar)
Monday	(मंडे)	सोमवार (Somvar)
Tuesday	(ट्यूजडे)	मंगलवार (Mangalvar)
Wednesday	(वेडनेसडे)	बुधवार (Budhvar)
Thursday	(थर्सडे)	गुरुवार (Guruvar)
Friday	(फ्राइडे)	शुक्रवार (Shukrvar)
Saturday	(सैटरडे)	शनिवार (Shanivar)
 */