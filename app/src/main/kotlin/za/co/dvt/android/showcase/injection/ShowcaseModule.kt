package za.co.dvt.android.showcase.injection

import android.content.Context
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import dagger.Module
import dagger.Provides
import za.co.dvt.android.showcase.repository.*
import za.co.dvt.android.showcase.repository.impl.*
import javax.inject.Singleton

/**
 * @author rebeccafranks
 * *
 * @since 2017/06/07.
 */
@Module
class ShowcaseModule {

    @Provides
    @Singleton
    fun providesAppRepository(): AppRepository = FirebaseAppRepository(FirebaseDatabase.getInstance())

    @Provides
    @Singleton
    fun providesOfficesRepository(): OfficesRepository = FirebaseOfficesRepository(FirebaseDatabase.getInstance())

    @Provides
    @Singleton
    fun providesUserRepository(): UserRepository = FirebaseUserRepository(FirebaseAuth.getInstance())

    @Provides
    @Singleton
    fun providesTrackingRepository(context: Context): TrackingRepository = FirebaseTrackingRepository(FirebaseAnalytics.getInstance(context))


    @Provides
    @Singleton
    fun providesRemoteConfigRepository(): RemoteConfigurationRepository = FirebaseRemoteConfigRepository(FirebaseRemoteConfig.getInstance())
}
