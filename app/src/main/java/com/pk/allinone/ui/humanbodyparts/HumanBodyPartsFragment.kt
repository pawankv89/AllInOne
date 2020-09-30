package com.pk.allinone.ui.humanbodyparts

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
import com.pk.allinone.adapter.HumanBodyPartsAdapter
import com.pk.allinone.model.HumanBodyParts
import com.startapp.sdk.ads.banner.Banner
import kotlinx.android.synthetic.main.common_list_layout.view.*


class HumanBodyPartsFragment : Fragment() {

    var mContext: Context? = null
    var adapter: HumanBodyPartsAdapter? = null
    var list = ArrayList<HumanBodyParts>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //Load Fragment Layout
        val root = inflater.inflate(R.layout.fragment_humanbodyparts, container, false)
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
        list.add(HumanBodyParts("Face","(फेस)", "चेहरा \n(Chehra)"))
        list.add(HumanBodyParts("Eyes","(आईज)", "आँखे \n(Aankhe)"))
        list.add(HumanBodyParts("Eye","(आइ)", "आँख \n(Aankh)"))
        list.add(HumanBodyParts("Eyebrow","(आइब्रो)", "भौं \n(Bhaun)"))
        list.add(HumanBodyParts("Tongue","(टंग)", "जीभ \n(Jeebh)"))
        list.add(HumanBodyParts("Mouth","(माउथ)", "मुँह \n(Munh)"))
        list.add(HumanBodyParts("Teeth","(टीथ)", "दांत \n(Daant)"))
        list.add(HumanBodyParts("Lips","(लिप्स)", "होंठ \n(Hoth)"))
        list.add(HumanBodyParts("Cheek","(चीक)", "गाल \n(Gaal)"))
        list.add(HumanBodyParts("Nose","(नोज)", "नाक \n(Naak)"))
        list.add(HumanBodyParts("Forehead","(फॉरहेड)", "माथा \n(Maatha)"))
        list.add(HumanBodyParts("Hair","(हेयर)", "बाल \n(Ball)"))
        list.add(HumanBodyParts("Shoulder","(शोल्डर)", "कन्धा \n(Kandha)"))
        list.add(HumanBodyParts("Back","(बैक)", "कमर \n(Kamar)"))
        list.add(HumanBodyParts("Stomach","(स्तोमच)", "पेट \n(Pet)"))
        list.add(HumanBodyParts("Throat","(थ्रोट)", "गला \n(Galla)"))
        list.add(HumanBodyParts("Leg","(लेग)", "टांग \n(Taang)"))
        list.add(HumanBodyParts("Knee","(नी)", "घुटना \n(Ghutana)"))
        list.add(HumanBodyParts("Foot","(फूट)", "पैर \n(Pair)"))
        list.add(HumanBodyParts("Hand","(हैण्ड)", "हाथ \n(Hath)"))
        list.add(HumanBodyParts("Ear","(इयर)", "कान \n(Kaan)"))
        list.add(HumanBodyParts("Beard","(बियर्ड)", "दाढ़ी \n(Daarhi)"))
        list.add(HumanBodyParts("Neck","(नैक)", "गर्दन \n(Gardan)"))
        list.add(HumanBodyParts("Moustache","(मौसटेक)", "मूछ \n(Muchh)"))
        list.add(HumanBodyParts("Smiley face","(स्माइली फेस)", "हशमुख चेहरा \n(Hashmukh Chehra)"))
        list.add(HumanBodyParts("Wrist","(वरिस्ट)", "कलाई \n(Kalai)"))
        list.add(HumanBodyParts("Larynx","(लार्यन्क्स)", "कंठ \n(Kanth)"))
        list.add(HumanBodyParts("Thumb","(थम्ब)", "अंगूठा \n(Angutha)"))
        list.add(HumanBodyParts("Fingers","(फिंगर्स)", "उंगली \n(Ungali)"))
        list.add(HumanBodyParts("Little Finger","(लिटिल फिंगर)", "छोटी उंगली \n(Chhoti Ungali)"))
        list.add(HumanBodyParts("Ring Finger","(रिंग फिंगर)", "अनामिका \n(Anamika)"))
        list.add(HumanBodyParts("Index Finger","(इंडेक्स फिंगर)", "तर्जनी \n(Tarjani)"))
        list.add(HumanBodyParts("Belly","(बेल्ली)", "पेट \n(Pet)"))
        list.add(HumanBodyParts("Bone","(बोन)", "हड्डी \n(Haddi)"))
        list.add(HumanBodyParts("Palm","(पाल्म)", "हथेली \n(Hatheli)"))
        list.add(HumanBodyParts("Calf","(कल्फ)", "पिंडली \n(Pindali)"))
        list.add(HumanBodyParts("Head","(हेड)", "सिर \n(Sir)"))
        list.add(HumanBodyParts("Hip","(हिप)", "कुल्हा \n(Kulha)"))
        list.add(HumanBodyParts("Skin","(स्किन)", "त्वचा \n(Twacha)"))
        list.add(HumanBodyParts("Nail","(नेल)", "नाख़ून \n(Nakhun)"))
        list.add(HumanBodyParts("Blood","(ब्लड)", "रक्त \n(Rakt)"))
        list.add(HumanBodyParts("Fist","(फिस्ट)", "मुठी \n(Muthi)"))
        list.add(HumanBodyParts("Brow","(ब्रो)", "भौंह \n(Bhaunh)"))

        // Set Adapter
        adapter = HumanBodyPartsAdapter(mContext, list)

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
