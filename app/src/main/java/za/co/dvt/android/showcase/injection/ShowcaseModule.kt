package za.co.dvt.android.showcase.injection

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import dagger.Module
import dagger.Provides
import za.co.dvt.android.showcase.repository.AppRepository
import za.co.dvt.android.showcase.repository.UserRepository
import za.co.dvt.android.showcase.repository.impl.FirebaseAppRepository
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

}
