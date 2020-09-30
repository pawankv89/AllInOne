package com.pk.allinone

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.net.Uri
import android.view.View
import android.view.ViewGroup.LayoutParams
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.app.ShareCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.FragmentActivity
import com.startapp.sdk.ads.banner.Banner


object Singleton{

    init {
        println("Singleton class invoked.")
    }
    var variableName = "Pawan Sharma Kumar"
    fun printVarName(){
        println(variableName)
    }

    //For Banner Display
    fun displayorHideAdsBanner(fragmentActivity: FragmentActivity, banner: Banner){

        //Check Internet Connection
        val connectivityManager = fragmentActivity?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
        val isConnected: Boolean = activeNetwork?.isConnectedOrConnecting == true

        if (isConnected){
            //Toast.makeText(fragmentActivity,"Internet Online " + isConnected, Toast.LENGTH_SHORT).show()
            // Show the connected screen
            //Using Layout
            //banner.getLayoutParams().height = LayoutParams.WRAP_CONTENT;
            //banner.requestLayout();//It is necesary to refresh the screen
            banner.visibility = View.VISIBLE

            //Using ConstraintLayout
            val params = banner.layoutParams as ConstraintLayout.LayoutParams
            params.height = LayoutParams.WRAP_CONTENT
            banner.requestLayout() //It is necesary to refresh the screen

        }else{
            //Toast.makeText(fragmentActivity,"Internet Offline " + isConnected, Toast.LENGTH_SHORT).show()
            // Show disconnected screen
            //Using Layout
            //banner.getLayoutParams().height = 0;
            //banner.requestLayout();//It is necesary to refresh the screen
            banner.visibility = View.GONE

            //Using ConstraintLayout
            val params = banner.layoutParams as ConstraintLayout.LayoutParams
            params.height = 0
            banner.requestLayout() //It is necesary to refresh the screen
        }
    }

    fun getPackageName(): String {
        var packageName = BuildConfig.APPLICATION_ID
        return packageName
    }

    // Share App Link By Using Old Code

    fun shareApp(context: Context){
        val packageName = getPackageName()
        val appName = Utils.getAppName(context, packageName)

        try {
            var sareSubject = "My Application Name '${appName}'"
            val shareIntent = Intent()
            shareIntent.action = Intent.ACTION_SEND
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, sareSubject)

            var shareMessage = "https://play.google.com/store/apps/details?id=${packageName}".trimIndent()
            shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage)
            context.startActivity(Intent.createChooser(shareIntent, "Share via"))
        } catch (e: Exception) {
            //e.toString();
        }
    }

    // Share App Link By Using ShareCompat

    //https://developer.android.com/reference/android/support/v4/app/ShareCompat.html
    //https://androidx.de/androidx/core/app/ShareCompat.html

    fun shareAppByShareCompat(activity: Activity){

        val packageName = getPackageName()
        val appName = Utils.getAppName(activity, packageName)
        var title = "My Application Name '${appName}'"

        ShareCompat.IntentBuilder.from(activity)
            .setType("text/plain")
            .setChooserTitle(title)
            .setText("http://play.google.com/store/apps/details?id=" + activity.getPackageName())
            .startChooser();
    }

    // Rate App

    fun rateApp(context: Context){
        val packageName = getPackageName()
        val uri = Uri.parse("market://details?id=" + packageName)
        val goToMarket = Intent(Intent.ACTION_VIEW, uri)
        // To count with Play market backstack, After pressing back button,
        // to taken back to our application, we need to add following flags to intent.
        // To count with Play market backstack, After pressing back button,
        // to taken back to our application, we need to add following flags to intent.
        goToMarket.addFlags(
            Intent.FLAG_ACTIVITY_NO_HISTORY or
                    Intent.FLAG_ACTIVITY_NEW_DOCUMENT or
                    Intent.FLAG_ACTIVITY_MULTIPLE_TASK
        )
        try {
            context.startActivity(goToMarket)
        } catch (e: ActivityNotFoundException) {
            context.startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("http://play.google.com/store/apps/details?id=" + packageName)
                )
            )
        }
    }
}