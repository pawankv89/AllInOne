package com.pk.allinone

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import com.startapp.sdk.adsbase.StartAppAd
import com.startapp.sdk.adsbase.StartAppSDK
import com.pk.allinone.Singleton

class MainActivity : AppCompatActivity() {

    object Singleton
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration =
            AppBarConfiguration(setOf(
                R.id.nav_home,
                R.id.nav_alphabeta,
                R.id.nav_numbertable,
                R.id.nav_number1to10table,
                R.id.nav_number11to20table,
                R.id.nav_weekend,
                R.id.nav_month,
                R.id.nav_birds,
                R.id.nav_fruits,
                R.id.nav_vegetables,
                R.id.nav_humanbodyparts,
                R.id.nav_farmanimalnames,
                R.id.nav_insectsanimalnames,
                R.id.nav_petsanimalnames,
                R.id.nav_seaanimalnames,
                R.id.nav_wildanimalnames,
                R.id.nav_statesnamewithcapital),
                drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_share -> {
                // Action goes here
                //com.pk.allinone.Singleton.shareApp(this)
                com.pk.allinone.Singleton.shareAppByShareCompat(this)
                Toast.makeText(this,"Clicked on " + item, Toast.LENGTH_SHORT).show()
                true
            } R.id.action_rate_app -> {
                // Action goes here
                com.pk.allinone.Singleton.rateApp(this)
                Toast.makeText(this,"Clicked on " + item, Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onBackPressed() {
        StartAppAd.onBackPressed(this);
        super.onBackPressed()

    }
}