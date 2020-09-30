package com.pk.allinone.ui.numbertable

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import androidx.fragment.app.Fragment
import com.pk.allinone.R
import com.pk.allinone.Singleton
import com.pk.allinone.adapter.TableAdapter
import com.pk.allinone.model.Table
import com.startapp.sdk.ads.banner.Banner

class Number11To20TableFragment : Fragment() {

    var mContext: Context? = null
    var adapter: TableAdapter? = null
    var list = ArrayList<Table>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //Load Fragment Layout
        val root = inflater.inflate(R.layout.fragment_number11to20table, container, false)
        val gridView: GridView = root.findViewById(R.id.gridView)

        //Display Banner
        val banner: Banner = root.findViewById(R.id.startAppBanner)
        this.activity?.let { Singleton.displayorHideAdsBanner(it, banner) }

        creeateAlphaetsList(gridView)

        // move this line to last
        return root
    }

    //The onAttach (Activity activity) method was deprecated in API level 23.
    //Now to get context in  Fragment we can use onAttach (Context context)
    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    fun creeateAlphaetsList(gridView: GridView){

        var row_list = ArrayList<Int>()

        var row_1: Int = 0
        // For Row 1
        while (row_1 < 10){

            row_1++
            var result = row_1 + 10
            // Add row_1
            list.add(Table(result.toString()))
            row_list.add(result)
        }

        // For Row 2
        row_1 = 0
        while (row_1 < 10){

            var row: Int = row_list[row_1]
            var result = row * 2
            // Add row_2
            list.add(Table(result.toString()))
            row_1++
        }
        // For Row 3
        row_1 = 0
        while (row_1 < 10){

            var row: Int = row_list[row_1]
            var result = row * 3
            // Add row_2
            list.add(Table(result.toString()))
            row_1++
        }
        // For Row 4
        row_1 = 0
        while (row_1 < 10){

            var row: Int = row_list[row_1]
            var result = row * 4
            // Add row_2
            list.add(Table(result.toString()))
            row_1++
        }
        // For Row 5
        row_1 = 0
        while (row_1 < 10){

            var row: Int = row_list[row_1]
            var result = row * 5
            // Add row_2
            list.add(Table(result.toString()))
            row_1++
        }
        // For Row 6
        row_1 = 0
        while (row_1 < 10){

            var row: Int = row_list[row_1]
            var result = row * 6
            // Add row_2
            list.add(Table(result.toString()))
            row_1++
        }
        // For Row 7
        row_1 = 0
        while (row_1 < 10){

            var row: Int = row_list[row_1]
            var result = row * 7
            // Add row_2
            list.add(Table(result.toString()))
            row_1++
        }
        // For Row 8
        row_1 = 0
        while (row_1 < 10){

            var row: Int = row_list[row_1]
            var result = row * 8
            // Add row_2
            list.add(Table(result.toString()))
            row_1++
        }
        // For Row 9
        row_1 = 0
        while (row_1 < 10){

            var row: Int = row_list[row_1]
            var result = row * 9
            // Add row_2
            list.add(Table(result.toString()))
            row_1++
        }
        // For Row 10
        row_1 = 0
        while (row_1 < 10){

            var row: Int = row_list[row_1]
            var result = row * 10
            // Add row_2
            list.add(Table(result.toString()))
            row_1++
        }

        // Set Adapter
        adapter = TableAdapter(mContext, list)

        // Display Adapter
        gridView.adapter = adapter
    }
}

