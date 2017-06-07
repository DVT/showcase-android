package za.co.dvt.android.showcase

import android.app.Application

import com.google.firebase.database.FirebaseDatabase

import timber.log.Timber
import za.co.dvt.android.showcase.injection.DaggerShowcaseComponent
import za.co.dvt.android.showcase.injection.ShowcaseComponent
import za.co.dvt.android.showcase.injection.ShowcaseModule
import za.co.riggaroo.datecountdown.injection.ApplicationModule


class DvtShowcaseApplication : Application() {

    open val showcaseComponent: ShowcaseComponent = DaggerShowcaseComponent.builder()
            .applicationModule(ApplicationModule(this))
            .showcaseModule(ShowcaseModule())
            .build()

    override fun onCreate() {
        super.onCreate()
        FirebaseDatabase.getInstance().setPersistenceEnabled(true)
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}
