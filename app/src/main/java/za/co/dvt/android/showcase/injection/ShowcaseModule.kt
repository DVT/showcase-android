package za.co.dvt.android.showcase.injection

import android.content.Context
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import dagger.Module
import dagger.Provides
import za.co.dvt.android.showcase.repository.AppRepository
import za.co.dvt.android.showcase.repository.TrackingRepository
import za.co.dvt.android.showcase.repository.UserRepository
import za.co.dvt.android.showcase.repository.impl.FirebaseAppRepository
import za.co.dvt.android.showcase.repository.impl.FirebaseTrackingRepository
import za.co.dvt.android.showcase.repository.impl.FirebaseUserRepository
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
    fun providesUserRepository(): UserRepository = FirebaseUserRepository(FirebaseAuth.getInstance())

    @Provides
    @Singleton
    fun providesTrackingRepository(context: Context): TrackingRepository = FirebaseTrackingRepository(FirebaseAnalytics.getInstance(context))
}
