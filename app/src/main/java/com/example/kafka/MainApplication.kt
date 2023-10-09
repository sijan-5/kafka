package com.example.kafka

import android.app.Application
import android.util.Log
import com.rudderstack.android.sdk.core.RudderClient
import com.rudderstack.android.sdk.core.RudderConfig
import com.rudderstack.android.sdk.core.RudderLogger
import com.rudderstack.android.sdk.core.RudderTraits

class MainApplication : Application() {

    private val DATA_PLANE_URL = "https://esewasijarsizn.dataplane.rudderstack.com"
    private val WRITE_KEY = "2WW0VbZJYygEpBnWmxpezUSckKY"
    companion object
    {
        var rudderClient : RudderClient?= null
    }
    override fun onCreate() {
        super.onCreate()
        setUpRudderStack()
    }


   fun setUpRudderStack() {
       Log.d("this", "setting up rudderstack....")
       rudderClient = RudderClient.getInstance(
           this,
           WRITE_KEY,
           RudderConfig.Builder()
               .withDataPlaneUrl(DATA_PLANE_URL)
               .withDbEncryption(RudderConfig.DBEncryption(false, "encryption_key"))
               .build()
       )
    }

//    override fun getWorkManagerConfiguration(): Configuration {
//        return Configuration.Builder().setMinimumLoggingLevel(android.util.Log.INFO).build()
//    }
}