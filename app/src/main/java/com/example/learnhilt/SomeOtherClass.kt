package com.example.learnhilt

import com.google.gson.Gson
import javax.inject.Inject

// Problem 1: When we want to inject an interface type, we can't.
// May not be good for testing to build a mock
interface SomeInterface {
    fun getAThing(): String
}

class SomeOtherClass
@Inject
constructor(
    @Impl1 private val someInterfaceImpl: SomeInterface,
    @Impl2 private val someInterfaceImp2: SomeInterface,
) {
    fun doSomeOtherThing(): String {
        return "SomeOtherClass do a thing"
    }

    fun gettingAThing(): String {
        return "From SomeInterfaceImpl: ${someInterfaceImpl.getAThing()}"
    }

    fun gettingAThing2(): String {
        return "From SomeInterfaceImpl2: ${someInterfaceImp2.getAThing()}"
    }
}

class SomeInterfaceImpl
@Inject
constructor() : SomeInterface {
    fun doSomeOtherThing(): String {
        return "SomeOtherClass do a thing"
    }

    override fun getAThing(): String {
        return "Getting a thing"
    }
}

class SomeInterfaceImpl2
@Inject
constructor() : SomeInterface {
    override fun getAThing(): String {
        return "Implementation 2"
    }
}

// Problem 2: Unable to inject from 3rd party libraries
class SomeClassRequireThirdParty
@Inject
constructor(
    private val gson: Gson
) {
    fun iNeedGson() {
        println("I have gson: $gson")
    }
}


