package za.co.dvt.android.showcase.ui.viewapp

import android.arch.lifecycle.ViewModel
import io.reactivex.Flowable
import io.reactivex.FlowableSubscriber
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.reactivestreams.Subscription
import timber.log.Timber
import za.co.dvt.android.showcase.injection.ShowcaseComponent
import za.co.dvt.android.showcase.model.AppModel
import za.co.dvt.android.showcase.repository.AppRepository
import javax.inject.Inject

/**
 * @author rebeccafranks
 * @since 2017/06/28.
 */
class ViewAppViewModel : ViewModel(), ShowcaseComponent.Injectable {

    var app: AppModel? = null
    @Inject
    lateinit var appRepository: AppRepository

    fun loadApp(appId: String): Flowable<AppModel> {
        Timber.d("loadApp called with $appId")
        return appRepository.getAppById(appId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())

    }

    override fun inject(component: ShowcaseComponent) {
        component.inject(this)
    }

}