package za.co.dvt.android.showcase.ui.about

import android.arch.lifecycle.ViewModel
import io.reactivex.Observable
import za.co.dvt.android.showcase.injection.ShowcaseComponent
import za.co.dvt.android.showcase.repository.RemoteConfigurationRepository
import za.co.dvt.android.showcase.repository.TrackingRepository
import za.co.dvt.android.showcase.utils.SingleLiveEvent
import javax.inject.Inject

/**
 * @author rebeccafranks
 * @since 2017/06/07.
 */
class AboutViewModel : ViewModel(), ShowcaseComponent.Injectable {

    @Inject
    lateinit var trackingRepository: TrackingRepository

    @Inject
    lateinit var remoteConfigRepository: RemoteConfigurationRepository

    val openWebsite: SingleLiveEvent<String> = SingleLiveEvent()

    val openFacebook: SingleLiveEvent<String> = SingleLiveEvent()

    val openTwitter: SingleLiveEvent<String> = SingleLiveEvent()

    lateinit var aboutCompany: Observable<String>

    override fun inject(component: ShowcaseComponent) {
        component.inject(this)
        aboutCompany = remoteConfigRepository.getAboutCompany()
    }

    fun openWebsite() {
        trackingRepository.trackOpenWebsite()
        openWebsite.value = remoteConfigRepository.getWebsiteUrl()
    }

    fun openTwitter() {
        trackingRepository.trackOpenTwitter()
        openTwitter.value = remoteConfigRepository.getTwitterUsername()
    }

    fun openFacebook() {
        trackingRepository.trackOpenFacebook()
        openFacebook.value = remoteConfigRepository.getFacebookPageName()
    }
}