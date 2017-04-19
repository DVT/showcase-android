package za.co.dvt.android.showcase;

import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import com.google.firebase.database.FirebaseDatabase;

import timber.log.Timber;


public class DvtShowcaseApplication extends MultiDexApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        MultiDex.install(this);
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        } else {
            //TODO plant Crashlytics tree Timber.plant();
        }
    }
}
