package com.pk.allinone.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.pk.allinone.R
import com.pk.allinone.model.Birds
import kotlinx.android.synthetic.main.alphabets_layout.view.*
import kotlinx.android.synthetic.main.birds_layout.view.*
import kotlinx.android.synthetic.main.nav_header_main.view.*
import kotlinx.android.synthetic.main.weekend_layout.view.*
import kotlinx.android.synthetic.main.weekend_layout.view.english
import kotlinx.android.synthetic.main.weekend_layout.view.hindi
import kotlinx.android.synthetic.main.weekend_layout.view.name

class BirdsAdapter : BaseAdapter {
    var list = ArrayList<Birds>()
    var context: Context? = null

    //var birdsImages = ArrayList<Int>()

    constructor(context: Context?, list: ArrayList<Birds>) : super() {
        this.context = context
        this.list = list

        /*
        birdsImages.add(R.drawable.parrot)
        birdsImages.add(R.drawable.cock)
        birdsImages.add(R.drawable.peacock)
        birdsImages.add(R.drawable.owl)
        birdsImages.add(R.drawable.pigeon)
        birdsImages.add(R.drawable.hen)
        birdsImages.add(R.drawable.crow)
        birdsImages.add(R.drawable.swan)
        birdsImages.add(R.drawable.duck)
        birdsImages.add(R.drawable.cuckoo)
        birdsImages.add(R.drawable.crane)
        birdsImages.add(R.drawable.dove)
        birdsImages.add(R.drawable.eagle)
        birdsImages.add(R.drawable.nightingale)
        birdsImages.add(R.drawable.flamingo)
        birdsImages.add(R.drawable.quail)
        birdsImages.add(R.drawable.partridge)
        birdsImages.add(R.drawable.ostrich)
        birdsImages.add(R.drawable.mynah)
        birdsImages.add(R.drawable.kite)
        birdsImages.add(R.drawable.kingfisher)
        birdsImages.add(R.drawable.hoopoe)
        birdsImages.add(R.drawable.hawk)
        birdsImages.add(R.drawable.hawk_cuckoo)
        birdsImages.add(R.drawable.woodpecker)
        birdsImages.add(R.drawable.wagtail)
        birdsImages.add(R.drawable.vulture)
        birdsImages.add(R.drawable.sparrow)
        birdsImages.add(R.drawable.skylark)
        */
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
        //val birdImage = this.birdsImages[position]

        var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var layoutView = inflator.inflate(R.layout.birds_layout, null)

        //layoutView.img.setImageResource(birdImage)
        layoutView.name.text = item.name!!
        layoutView.english.text = item.english!!
        layoutView.hindi.text = item.hindi!!

        return layoutView
    }
}