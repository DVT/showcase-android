package za.co.dvt.android.showcase.ui.listapps

import android.arch.lifecycle.ViewModel
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import za.co.dvt.android.showcase.injection.ShowcaseComponent
import za.co.dvt.android.showcase.model.AppModel
import za.co.dvt.android.showcase.repository.AppRepository
import javax.inject.Inject

/**
 * @author rebeccafranks
 * *
 * @since 2017/06/07.
 */

open class ListAppsViewModel : ViewModel(), ShowcaseComponent.Injectable {

    @Inject
    lateinit var appRepository: AppRepository

    fun getAppList(): Flowable<List<AppModel>> = appRepository.listApps()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())


    override fun inject(component: ShowcaseComponent) {
        component.inject(this)
    }
}
