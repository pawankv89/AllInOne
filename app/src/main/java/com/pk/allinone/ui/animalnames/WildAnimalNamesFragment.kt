package com.pk.allinone.ui.animalnames

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import androidx.fragment.app.Fragment
import com.pk.allinone.R
import com.pk.allinone.Singleton
import com.pk.allinone.adapter.AnimalAdapter
import com.pk.allinone.model.Animal
import com.startapp.sdk.ads.banner.Banner
import kotlinx.android.synthetic.main.common_list_layout.view.*

class WildAnimalNamesFragment : Fragment() {

    var mContext: Context? = null
    var adapter: AnimalAdapter? = null
    var list = ArrayList<Animal>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //Load Fragment Layout
        val root = inflater.inflate(R.layout.fragment_wildanimalnames, container, false)
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
        list.add(Animal("Tiger","(टाइगर)", "बाघ \n(Bagh)"))
        list.add(Animal("Lion","(लायन)", "शेर \n(Sher)"))
        list.add(Animal("Reindeer","(रेनडियर)", "बारहसिंगा \n(Barahsinga)"))
        list.add(Animal("Gorilla","(गोरिल्ला)", "गोरिल्ला \n(Gorilla)"))
        list.add(Animal("Fox","(फॉक्स)", "लोमड़ी \n(Lomdi)"))
        list.add(Animal("Elk","(एल्क)", "गोज़न \n(Gojan)"))
        list.add(Animal("Snake","(स्नेक)", "सांप \n(Sanp)"))
        list.add(Animal("Kangaroo","(कंगारू)", "कंगारू"))
        list.add(Animal("Hippopotamus ","(हिप्पोपटेमस)", "दरियाई घोडा \n(Dariyai ghoda)"))
        list.add(Animal("Alligator","(एलीगेटर)", "मगरमच्छ  \n(Magarmachchh)"))
        list.add(Animal("Arctic wolf","(आर्कटिक वुल्फ)", "भेड़िया \n(bhediya)"))
        list.add(Animal("Badger","(बेजर)", "बिज्जू \n(Bijju)"))
        list.add(Animal("Beer","(बियर)", "भालू \n(Bhalu)"))
        list.add(Animal("Camel","(कैमल)", "ऊंट \n(Unt)"))
        list.add(Animal("Chimpanzee","(चिंपांज़ी)", "चिंपांज़ी"))
        list.add(Animal("Crocodile","(क्रोकोडाइल)", "मगरमच्छ  \n(Magarmachchh)"))
        list.add(Animal("Deer","(डियर)", "हिरन \n(Hiran)"))
        list.add(Animal("Elephant","(एलीफैंट)", "हाथी \n(Hathi)"))
        list.add(Animal("Frog","(फ्रॉग)", "मेढक \n(Medhak)"))
        list.add(Animal("Giraffe","(जिराफ़)", "जिराफ़ \n(Jiraph)"))
        list.add(Animal("Hare","(हेर)", "खरगोश \n(Khargosh)"))
        list.add(Animal("Hedgehog","(हेजहोग)", "कांटेदार जंगली चूहा  \n(Kantedar jangli chuha)"))
        list.add(Animal("Lizard","(लिज़र्ड)", "छिपकली \n(Chhipkali)"))
        list.add(Animal("Mole","(मोल)", "छछूंदर \n(Chhchhundar)"))
        list.add(Animal("Otter","(आटर)", "ऊदबिलाव \n(Udbilao)"))
        list.add(Animal("Rat","(रैट)", "चुहा \n(Chuha)"))
        list.add(Animal("Squirrel","(स्क्वरल)", "गिलहरि \n(Gilhari)"))
        list.add(Animal("Toad","(टोड)", "मेंढक \n(Mendhak)"))


        // Set Adapter
        adapter = AnimalAdapter(mContext, list)

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
