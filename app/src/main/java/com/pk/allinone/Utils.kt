package com.pk.allinone

import android.content.Context
import android.content.pm.PackageManager


internal class Utils {
    fun DoSleep(c: Context?, ms: Int) {
        try {
            Thread.sleep(ms.toLong())
        } catch (e1: InterruptedException) {
            e1.printStackTrace()
        }
    }

    companion object {
        fun checkForInstalledApp(
            ctx: Context,
            pkgName: String?
        ): Boolean {
            try {
                val pm = ctx.packageManager
                pm.getPackageInfo(pkgName, 0)
                // Log.d(TAG, pkgString + " is installed");
                return true
            } catch (e: PackageManager.NameNotFoundException) {
                // Log.d(TAG, pkgString + " is not installed");
            }
            return false
        }

        fun getAppName(ctx: Context, pkgName: String?): String {
            return try {
                val pm = ctx.packageManager
                val appInfo = pm.getApplicationInfo(pkgName, 0)
                pm.getApplicationLabel(appInfo).toString()
            } catch (e: PackageManager.NameNotFoundException) {
                ""
            }
        }

        fun getAppVersionName(
            ctx: Context,
            pkgName: String?
        ): String {
            return try {
                val pm = ctx.packageManager
                val pkgInfo = pm.getPackageInfo(pkgName, 0)
                pkgInfo.versionName
            } catch (e: PackageManager.NameNotFoundException) {
                "0"
            }
        }

        fun getAppVersionCode(ctx: Context, pkgName: String?): Int {
            return try {
                val pm = ctx.packageManager
                val pkgInfo = pm.getPackageInfo(pkgName, 0)
                pkgInfo.versionCode
            } catch (e: PackageManager.NameNotFoundException) {
                0
            }
        }
    }
}
