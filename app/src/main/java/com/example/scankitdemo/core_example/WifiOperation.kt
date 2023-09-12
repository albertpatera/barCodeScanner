package com.example.scankitdemo.core

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.wifi.WifiConfiguration
import android.net.wifi.WifiManager
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat


class WifiOperation  : IWifi{
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun isOnline(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (connectivityManager != null) {
            val capabilities =
                connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            if (capabilities != null) {
                if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                   Toast.makeText(context, "Your internet connection was lost. Please try again later...", Toast.LENGTH_LONG).show()
                    // Log.i("Internet", "NetworkCapabilities.TRANSPORT_CELLULAR")
                    return true
                } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                    //Log.i("Internet", "NetworkCapabilities.TRANSPORT_WIFI")
                        Toast.makeText(context, "You are successfully conected", Toast.LENGTH_LONG).show()
                        return true
                } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)) {
                    //Log.i("Internet", "NetworkCapabilities.TRANSPORT_ETHERNET")
                    Toast.makeText(context, "You are successfully connected via ethernet", Toast.LENGTH_LONG).show()
                        return true
                }
            }
        }
        return false
    }

    /*override fun initWifiSettings(context: Context) {
        val networkSSID = "ProWifi"
        val networkPass = "Patera@0654"

        val conf = WifiConfiguration()
        conf.SSID =
            "\"" + networkSSID + "\"" // Please note the quotes. String should contain ssid in quotes

        conf.wepKeys[0] = "\"" + networkPass + "\"";
        conf.wepTxKeyIndex = 0;
        conf.allowedKeyManagement.set(WifiConfiguration.KeyMgmt.NONE);
        conf.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.WEP40);

        conf.preSharedKey = "\""+ networkPass +"\"";
        context.applicationContext.getSystemService(Context.WIFI_SERVICE)
        val wifiManager = context.getSystemService(Context.WIFI_SERVICE) as WifiManager
        wifiManager.addNetwork(conf)


        if (ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return
        }
        wifiManager.configuredNetworks
        val list = wifiManager.configuredNetworks
        for (i in list) {
            if (i.SSID != null && i.SSID == "\"" + networkSSID + "\"") {
                wifiManager.disconnect()
                wifiManager.enableNetwork(i.networkId, true)
                wifiManager.reconnect()
                break
            }
        }
    }*/


    override fun wifiMagerSettings() {

    }


}