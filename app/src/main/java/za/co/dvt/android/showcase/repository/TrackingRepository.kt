package za.co.dvt.android.showcase.repository

import za.co.dvt.android.showcase.model.AppModel

/**
 * @author rebeccafranks
 * *
 * @since 2017/04/13
 */

interface TrackingRepository {

    fun trackViewUserLogin()
    fun trackViewListApps()
    fun trackViewAppDetail(appModel: AppModel)
    fun trackViewContactUs()
    fun trackViewAboutCompany()
    fun trackUserLoginSuccess()
    fun trackUserLoginFailed(message: String?)
    fun trackOpenWebsite()
    fun trackOpenTwitter()
    fun trackOpenFacebook()

}
