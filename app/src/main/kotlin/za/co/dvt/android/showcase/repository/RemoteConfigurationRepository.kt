package za.co.dvt.android.showcase.repository

/**
 * @author rebeccafranks
 * @since 2017/07/22.
 */
interface RemoteConfigurationRepository {

    fun getTwitterUsername(): String
    fun getFacebookPageName(): String
    fun getAboutCompany(): String
    fun getWebsiteUrl(): String
}