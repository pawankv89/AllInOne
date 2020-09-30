package com.pk.allinone.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.pk.allinone.R
import com.pk.allinone.model.HomeItem
import kotlinx.android.synthetic.main.home_layout.view.*

class HomeAdapter : BaseAdapter {
    var list = ArrayList<HomeItem>()
    var context: Context? = null

    constructor(context: Context?, list: ArrayList<HomeItem>) : super() {
        this.context = context
        this.list = list
    }

    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): Any {
        return list[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    //Load Custom Layout
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val item = this.list[position]

        var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var layoutView = inflator.inflate(R.layout.home_layout, null)
        layoutView.textView.text = item.name!!
        return layoutView
    }
}