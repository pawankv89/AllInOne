package com.pk.allinone.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.pk.allinone.R
import com.pk.allinone.model.Table
import kotlinx.android.synthetic.main.alphabets_layout.view.*

class TableAdapter : BaseAdapter {
    var list = ArrayList<Table>()
    var context: Context? = null

    constructor(context: Context?, list: ArrayList<Table>) : super() {
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
        val food = this.list[position]

        var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var layoutView = inflator.inflate(R.layout.table_layout, null)
        //layoutView.imgFood.setImageResource(food.image!!)
        layoutView.tvAlphabets.text = food.name!!
        //layoutView.tvAlphabets.textSize = 10.0f
        return layoutView
    }
}