package com.example.learnhilt

import com.google.gson.Gson
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Qualifier
import javax.inject.Singleton

// Tells hilt where to install this module
@InstallIn(ApplicationComponent::class)
@Module
abstract class MainModule {

    // By specifying a bind notation of the interface implementation
    // to the class requiring the Interface
    // We can inject classes based on their interfaces
    @Impl1
    @Singleton
    @Binds
    abstract fun bindSomeDependency(
            someInterfaceImpl: SomeInterfaceImpl
    ): SomeInterface

    @Impl2
    @Singleton
    @Binds
    abstract fun bindSimilarDependency(
            someInterfaceImpl: SomeInterfaceImpl
    ): SomeInterface

}

@InstallIn(ApplicationComponent::class)
@Module
class ThirdPartyModules {
    @Singleton
    @Provides
    fun provideGson(): Gson = Gson()
}

// Similar to declaring @Named
// This creates annotations for hilt to differentiate the injection of classes
// belonging to the same type
@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class Impl1

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class Impl2


// Supposedly we want to install it in the ActivityComponent
// @InstallIn(ActivityComponent::class)
// @Module
// abstract class ActivityModule {
//
//     // We have to make sure that the scoping is declared correctly
//     @ActivityScoped
//     @Binds
//     abstract fun bindSomeDependency(
//             someInterfaceImpl: SomeInterfaceImpl
//     ) : SomeInterface
// }
