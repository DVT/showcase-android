package za.co.dvt.android.showcase.ui.viewapp

import android.arch.lifecycle.ViewModel
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import za.co.dvt.android.showcase.injection.ShowcaseComponent
import za.co.dvt.android.showcase.model.AppModel
import za.co.dvt.android.showcase.repository.AppRepository
import za.co.dvt.android.showcase.repository.TrackingRepository
import za.co.dvt.android.showcase.utils.SingleLiveEvent
import javax.inject.Inject

/**
 * @author rebeccafranks
 * @since 2017/06/28.
 */
class ViewAppViewModel : ViewModel(), ShowcaseComponent.Injectable {

    var app: AppModel? = null
    @Inject
    lateinit var appRepository: AppRepository
    @Inject
    lateinit var analyticsRepository: TrackingRepository
    val openAppStore: SingleLiveEvent<AppModel> = SingleLiveEvent()

    fun loadApp(appId: String): Flowable<AppModel> {
        Timber.d("loadApp called with $appId")
        return appRepository.getAppById(appId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).flatMap { newApp: AppModel ->
            app = newApp
            Flowable.just(app)
        }

    }

    override fun inject(component: ShowcaseComponent) {
        component.inject(this)
    }

    fun installApp(app: AppModel) {
        analyticsRepository.trackInstallAppClicked(app)
        openAppStore.value = app
    }

}