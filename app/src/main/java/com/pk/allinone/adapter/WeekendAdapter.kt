package com.pk.allinone.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.pk.allinone.R
import com.pk.allinone.model.WeekendTable
import kotlinx.android.synthetic.main.weekend_layout.view.*

class WeekendAdapter : BaseAdapter {
    var list = ArrayList<WeekendTable>()
    var context: Context? = null

    constructor(context: Context?, list: ArrayList<WeekendTable>) : super() {
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
        var layoutView = inflator.inflate(R.layout.weekend_layout, null)

        layoutView.name.text = item.name!!
        layoutView.english.text = item.english!!
        layoutView.hindi.text = item.hindi!!

        return layoutView
    }
}