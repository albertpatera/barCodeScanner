package com.example.scankitdemo.core

interface IWifi {
    fun isOnline(context : android.content.Context) : Boolean
   // fun initWifiSettings(context : android.content.Context)
    fun wifiMagerSettings()
}