package za.co.dvt.android.showcase.ui.about

import android.arch.lifecycle.ViewModel
import za.co.dvt.android.showcase.injection.ShowcaseComponent
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

    val openWebsite: SingleLiveEvent<Void> = SingleLiveEvent()

    val openFacebook: SingleLiveEvent<Void> = SingleLiveEvent()

    val openTwitter: SingleLiveEvent<Void> = SingleLiveEvent()

    override fun inject(component: ShowcaseComponent) {
        component.inject(this)
    }

    fun openWebsite() {
        trackingRepository.trackOpenWebsite()
        openWebsite.call()
    }

    fun openTwitter() {
        trackingRepository.trackOpenTwitter()
        openTwitter.call()
    }

    fun openFacebook() {
        trackingRepository.trackOpenFacebook()
        openFacebook.call()
    }
}