package za.co.dvt.android.showcase.repository

import io.reactivex.Observable

/**
 * @author rebeccafranks
 * @since 2017/07/22.
 */
interface RemoteConfigurationRepository {

    fun getTwitterUsername(): String
    fun getFacebookPageName(): String
    fun getAboutCompany(): Observable<String>
    fun getWebsiteUrl(): String
}