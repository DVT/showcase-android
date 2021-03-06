package za.co.dvt.android.showcase.repository.impl

import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics
import za.co.dvt.android.showcase.model.AppModel
import za.co.dvt.android.showcase.model.Office
import za.co.dvt.android.showcase.repository.TrackingRepository

/**
 * @author rebeccafranks
 * *
 * @since 2017/06/24.
 */

class FirebaseTrackingRepository(val firebaseAnalytics: FirebaseAnalytics) : TrackingRepository {
    private val APP_NAME_PARAM = "app_name"
    private val CLIENT_PARAM = "client"
    private val OFFICE_NAME_PARAM = "office_name"
    private val ERROR_MSG_PARAM = "error_msg"

    override fun trackInstallAppClicked(app: AppModel) {
        val bundle = Bundle()
        bundle.putString(APP_NAME_PARAM, app.name)
        firebaseAnalytics.logEvent("click_app_install", bundle)
    }

    override fun trackEmailOffice(office: Office) {
        val bundle = Bundle()
        bundle.putString(OFFICE_NAME_PARAM, office.name)
        firebaseAnalytics.logEvent("click_email_office", bundle)
    }

    override fun trackCallOffice(office: Office) {
        val bundle = Bundle()
        bundle.putString(OFFICE_NAME_PARAM, office.name)
        firebaseAnalytics.logEvent("click_call_office", bundle)
    }

    override fun trackNavigationOffice(office: Office) {
        val bundle = Bundle()
        bundle.putString(OFFICE_NAME_PARAM, office.name)
        firebaseAnalytics.logEvent("click_navigate_office", bundle)
    }

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
        firebaseAnalytics.logEvent("view_login", null)
    }

    override fun trackViewListApps() {
        firebaseAnalytics.logEvent("view_list_apps", null)
    }

    override fun trackViewAppDetail(appModel: AppModel) {
        val bundle = Bundle()
        bundle.putString(APP_NAME_PARAM, appModel.name)
        bundle.putString(CLIENT_PARAM, appModel.client)
        firebaseAnalytics.logEvent("view_app", bundle)
    }

    override fun trackViewContactUs() {
        firebaseAnalytics.logEvent("view_contact_us", null)
    }

    override fun trackViewAboutCompany() {
        firebaseAnalytics.logEvent("view_about_company", null)
    }

    override fun trackUserLoginSuccess() {
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.LOGIN, null)
    }

    override fun trackUserLoginFailed(message: String?) {
        val bundle = Bundle()
        bundle.putString(ERROR_MSG_PARAM, message)
        firebaseAnalytics.logEvent("login_failed", bundle)
    }

}
