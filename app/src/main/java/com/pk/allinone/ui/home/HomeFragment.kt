package com.pk.allinone.ui.home

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentTransaction
import com.pk.allinone.MainActivity
import com.pk.allinone.R
import com.pk.allinone.Singleton
import com.pk.allinone.adapter.HomeAdapter
import com.pk.allinone.model.HomeItem
import com.pk.allinone.ui.alphabets.AlphabetsFragment
import com.pk.allinone.ui.animalnames.*
import com.pk.allinone.ui.birds.BirdsFragment
import com.pk.allinone.ui.fruits.FruitsFragment
import com.pk.allinone.ui.humanbodyparts.HumanBodyPartsFragment
import com.pk.allinone.ui.month.MonthFragment
import com.pk.allinone.ui.numbertable.Number11To20TableFragment
import com.pk.allinone.ui.numbertable.Number1To10TableFragment
import com.pk.allinone.ui.numbertable.NumberTableFragment
import com.pk.allinone.ui.statesnamewithcapital.StatesNameWithCapitalFragment
import com.pk.allinone.ui.vegetables.VegetablesFragment
import com.pk.allinone.ui.weekend.WeekedFragment
import com.startapp.sdk.ads.banner.Banner
import com.startapp.sdk.adsbase.StartAppAd


class HomeFragment : Fragment() {

    var mContext: Context? = null
    var adapter: HomeAdapter? = null
    var gridView: GridView? = null
    var list = ArrayList<HomeItem>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //Load Fragment Layout
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        gridView = root.findViewById(R.id.gridView) as GridView

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

    fun creeateList(gridView: GridView?){

        // Add
        list.add(HomeItem(mContext!!.resources.getString(R.string.menu_alphabets)))
        list.add(HomeItem(mContext!!.resources.getString(R.string.menu_numbertable)))
        list.add(HomeItem(mContext!!.resources.getString(R.string.menu_number1to10table)))
        list.add(HomeItem(mContext!!.resources.getString(R.string.menu_number11to20table)))
        list.add(HomeItem(mContext!!.resources.getString(R.string.menu_weekend)))
        list.add(HomeItem(mContext!!.resources.getString(R.string.menu_month)))
        list.add(HomeItem(mContext!!.resources.getString(R.string.menu_birds)))
        list.add(HomeItem(mContext!!.resources.getString(R.string.menu_fruits)))
        list.add(HomeItem(mContext!!.resources.getString(R.string.menu_vegetables)))
        list.add(HomeItem(mContext!!.resources.getString(R.string.menu_humanbodyparts)))
        list.add(HomeItem(mContext!!.resources.getString(R.string.menu_farmanimalnames)))
        list.add(HomeItem(mContext!!.resources.getString(R.string.menu_insectsanimalnames)))
        list.add(HomeItem(mContext!!.resources.getString(R.string.menu_petsanimalnames)))
        list.add(HomeItem(mContext!!.resources.getString(R.string.menu_seaanimalnames)))
        list.add(HomeItem(mContext!!.resources.getString(R.string.menu_wildanimalnames)))
        list.add(HomeItem(mContext!!.resources.getString(R.string.menu_statesnamewithcapital)))

        // Set Adapter
        adapter = HomeAdapter(mContext, list)

        // Display Adapter
        gridView?.adapter = adapter

        //On Click for GridView Item
        gridView?.setOnItemClickListener { adapterView, parent, position, l ->
            Toast.makeText(mContext, "Click on : " + list[position].name, Toast.LENGTH_LONG).show()

            /* Because we are showing Ads on Top of Each Fragment
            if (this.getActivity() == null) {
                //Display STANDARD INTERSTITIALS Ads
                StartAppAd.showAd(mContext)
            } else {
                val activity = this.activity
                //Display STANDARD INTERSTITIALS Ads
                StartAppAd.showAd(activity)
            }*/

            //Show Fragment
            showFragment(position)
        }

        /*
        gridView?.onItemClickListener = object : AdapterView.OnItemClickListener {

            override fun onItemClick(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                // Get the GridView selected/clicked item text
                //val selectedItem = parent.getItemAtPosition(position).toString()

                // Show click confirmation
                // Display the selected/clicked item text and position on TextView
                //print("GridView item clicked : $selectedItem \nAt index position : $position")

                //Show Fragment
               // showFragment(position)
            }
        }*/
    }

    //Show Fragment
    private fun showFragment(index: Int) {

        //Toast.makeText(mContext,"List Clicked." + index, Toast.LENGTH_SHORT).show()

        val transaction: FragmentTransaction = requireFragmentManager().beginTransaction()
        var fragment: Fragment? = null
        if (index == 0) {
            fragment = AlphabetsFragment()
        } else if (index == 1) {
            fragment = NumberTableFragment()
        } else if (index == 2) {
            fragment = Number1To10TableFragment()
        } else if (index == 3) {
            fragment = Number11To20TableFragment()
        } else if (index == 4) {
            fragment = WeekedFragment()
        } else if (index == 5) {
            fragment = MonthFragment()
        } else if (index == 6) {
            fragment = BirdsFragment()
        } else if (index == 7) {
            fragment = FruitsFragment()
        } else if (index == 8) {
            fragment = VegetablesFragment()
        } else if (index == 9) {
            fragment = HumanBodyPartsFragment()
        } else if (index == 10) {
            fragment = FarmAnimalNamesFragment()
        } else if (index == 11) {
            fragment = InsectsAnimalNamesFragment()
        } else if (index == 12) {
            fragment = PetsAnimalNamesFragment()
        } else if (index == 13) {
            fragment = SeaAnimalNamesFragment()
        } else if (index == 14) {
            fragment = WildAnimalNamesFragment()
        } else if (index == 15) {
            fragment = StatesNameWithCapitalFragment()
        }

        fragmentManager?.beginTransaction()?.apply {
            replace(R.id.fragment_home, fragment!!)
            addToBackStack(null)
            setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            commit()
        }
    }
}
