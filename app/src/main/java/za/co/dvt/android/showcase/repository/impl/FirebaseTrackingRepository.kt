package za.co.dvt.android.showcase.repository.impl

import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics
import za.co.dvt.android.showcase.model.AppModel
import za.co.dvt.android.showcase.repository.TrackingRepository

/**
 * @author rebeccafranks
 * *
 * @since 2017/06/24.
 */

class FirebaseTrackingRepository(val firebaseAnalytics: FirebaseAnalytics) : TrackingRepository {
    override fun trackOpenWebsite() {
        firebaseAnalytics.logEvent("view_website", null)
    }

    override fun trackOpenTwitter() {
        firebaseAnalytics.logEvent("view_twitter", null)
    }

    override fun trackOpenFacebook() {
        firebaseAnalytics.logEvent("view_facebook", null)
    }

    override fun trackViewUserLogin() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun trackViewListApps() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun trackViewAppDetail(appModel: AppModel) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun trackViewContactUs() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun trackViewAboutDVT() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun trackUserLoginSuccess() {
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.LOGIN, null)
    }

    override fun trackUserLoginFailed(message: String?) {
        var bundle = Bundle()
        bundle.putString("error_msg", message)
        firebaseAnalytics.logEvent("login_failed", bundle)
    }

}
