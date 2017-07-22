package za.co.dvt.android.showcase.repository.impl

import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import za.co.dvt.android.showcase.repository.RemoteConfigurationRepository

/**
 * @author rebeccafranks
 * @since 2017/07/22.
 */
class FirebaseRemoteConfigRepository(val firebaseRemoteConfig: FirebaseRemoteConfig) : RemoteConfigurationRepository {
    private val WEBSITE_PARAM = "web_url"
    private val TWITTER_PARAM = "twitter_url"
    private val FACEBOOK_URL = "facebook_url"
    private val ABOUT_COMPANY_URL = "about_company"

    override fun getWebsiteUrl(): String {
        return firebaseRemoteConfig.getString(WEBSITE_PARAM)
    }

    override fun getTwitterUsername(): String {
        return firebaseRemoteConfig.getString(TWITTER_PARAM)
    }

    override fun getFacebookPageName(): String {
        return firebaseRemoteConfig.getString(FACEBOOK_URL)
    }

    override fun getAboutCompany(): String {
        return firebaseRemoteConfig.getString(ABOUT_COMPANY_URL)
    }

}