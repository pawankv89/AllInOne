# AllInOne

Added Some screens here.

![](https://github.com/pawankv89/AllInOne/blob/master/images/Screens_1.png)
![](https://github.com/pawankv89/AllInOne/blob/master/images/Screens_2.png)
![](https://github.com/pawankv89/AllInOne/blob/master/images/Screens_3.png)
![](https://github.com/pawankv89/AllInOne/blob/master/images/Screens_4.png)
![](https://github.com/pawankv89/AllInOne/blob/master/images/Screens_5.png)

## Version 1.0
This App only for Entertainment.

This App only for Entertainment, will keep your toddler entertained, educated and quiet in a car, in a restaurant, on a plane or everywhere

• All In One includes English letters A to Z
• 1 se 100 tak pahade (Tables) is presented to you by All In One

** Alphabets
** Number Table
** 1 To 10 Number Table
** 11 To 20 Number Table
** Day Names
** Month Names
** Birds Names
** Fruits Names
** Vegetables Names
** Human Body Parts
** Pets Animals Names
** Wild Animals Names
** Farm Animals Names
** Sea Animals Names
** Insects Animals Names
** States Name With Capital

#### Controller

```xml

<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.pk.allinone">

    <!-- Add these permissions for better ad targeting -->
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
    <uses-permission android:name="android.permission.INTERNET"/>
    <uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" />
    <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
    <uses-permission android:name="android.permission.RECEIVE_BOOT_COMPLETED" />
    <uses-permission android:name="android.permission.BLUETOOTH" />

    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/AppTheme">

        <!-- TODO replace YOUR_APP_ID with actual value -->
        <meta-data
            android:name="com.startapp.sdk.APPLICATION_ID"
            android:value="APPLICATION_ID" />

        <activity
            android:name=".MainActivity"
            android:label="@string/app_name"
            android:theme="@style/AppTheme.NoActionBar">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>

</manifest>

```

## Requirements

### Android Studio 4.0

Build #AI-193.6911.18.40.6514223, built on May 20, 2020
Runtime version: 1.8.0_242-release-1644-b3-6222593 x86_64
VM: OpenJDK 64-Bit Server VM by JetBrains s.r.o
macOS 10.15.1
GC: ParNew, ConcurrentMarkSweep
Memory: 1246M
Cores: 4
Registry: ide.new.welcome.screen.force=true
Non-Bundled Plugins: com.intellij.marketplace, com.thoughtworks.gauge, org.intellij.plugins.markdown


## License

This code is distributed under the terms and conditions of the [MIT license](LICENSE).

## Change-log

A brief summary of each this release can be found in the [CHANGELOG](CHANGELOG.mdown). 
