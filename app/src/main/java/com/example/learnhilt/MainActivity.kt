package com.example.learnhilt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

// Removes the need to declare inject in the AppComponent
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    // Field injection
    @Inject
    lateinit var someClass: SomeClass

    @Inject
    lateinit var someOtherClass: SomeOtherClass

    @Inject
    lateinit var someClassRequireThirdParty: SomeClassRequireThirdParty

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println(someClass.doAThing())
        someClassRequireThirdParty.iNeedGson()
        println(someOtherClass.gettingAThing2())


        // Problem Class
        println(someOtherClass.gettingAThing())
    }
}

class SomeClass
@Inject
constructor(
    private val someOtherClass: SomeOtherClass
) {
    fun doAThing(): String = "I did a thing by ${someOtherClass.doSomeOtherThing()}"
}


