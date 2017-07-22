package za.co.dvt.android.showcase

import android.app.Application
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import timber.log.Timber
import za.co.dvt.android.showcase.injection.DaggerShowcaseComponent
import za.co.dvt.android.showcase.injection.ShowcaseComponent
import za.co.dvt.android.showcase.injection.ShowcaseModule
import za.co.riggaroo.datecountdown.injection.ApplicationModule


class ShowcaseApplication : Application() {

    val showcaseComponent: ShowcaseComponent = DaggerShowcaseComponent.builder()
            .applicationModule(ApplicationModule(this))
            .showcaseModule(ShowcaseModule())
            .build()

    override fun onCreate() {
        super.onCreate()
        FirebaseDatabase.getInstance().setPersistenceEnabled(true)
        FirebaseRemoteConfig.getInstance().apply {
            setDefaults(R.xml.remote_config_defaults)
            val time = if (BuildConfig.DEBUG) 0L else 43200L
            fetch(time).addOnCompleteListener({
                activateFetched()
            })
        }
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}
