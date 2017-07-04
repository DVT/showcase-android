package za.co.dvt.android.showcase.ui.contact

import android.arch.lifecycle.ViewModel
import io.reactivex.Flowable
import io.reactivex.Maybe
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import za.co.dvt.android.showcase.injection.ShowcaseComponent
import za.co.dvt.android.showcase.model.Office
import za.co.dvt.android.showcase.repository.OfficesRepository
import za.co.dvt.android.showcase.repository.TrackingRepository
import za.co.dvt.android.showcase.utils.SingleLiveEvent
import javax.inject.Inject

/**
 * @author rebeccafranks
 * @since 2017/06/25.
 */
class ContactUsViewModel : ViewModel(), ShowcaseComponent.Injectable {

    override fun inject(component: ShowcaseComponent) {
        component.inject(this)
    }


    @Inject
    lateinit var officesRepository: OfficesRepository

    fun getOffices(): Flowable<List<Office>> = officesRepository.getOffices()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())

    @Inject
    lateinit var trackingRepository: TrackingRepository

    val openEmail: SingleLiveEvent<Office> = SingleLiveEvent()

    val openCall: SingleLiveEvent<Office> = SingleLiveEvent()

    val openNavigate: SingleLiveEvent<Office> = SingleLiveEvent()

    fun openEmail(office: Office) {
        trackingRepository.trackEmailOffice(office)
        openEmail.value = office
    }

    fun openCall(office: Office) {
        trackingRepository.trackCallOffice(office)
        openCall.value = office
    }

    fun openNavigation(office: Office) {
        trackingRepository.trackNavigationOffice(office)
        openNavigate.value = office
    }
}