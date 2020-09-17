package com.example.learnhilt

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

// @HiltAndroidApp saves the need to create an AppComponent class
// Which then requires modules to be install as Components
// Then calling Builder to build the Application with the HostAppComponent
@HiltAndroidApp
class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
    }
}