package za.co.dvt.android.showcase.ui.viewapp

import android.arch.lifecycle.ViewModel
import io.reactivex.MaybeObserver
import io.reactivex.disposables.Disposable
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

    fun loadApp(appId: String) {
        appRepository.getAppById(appId).subscribe(object : MaybeObserver<AppModel> {
            override fun onComplete() {

            }

            override fun onError(e: Throwable?) {

            }

            override fun onSubscribe(d: Disposable?) {

            }

            override fun onSuccess(appModel: AppModel?) {
                appModel?.let {
                    app = appModel
                }
            }

        })
    }

    override fun inject(component: ShowcaseComponent) {
        component.inject(this)
    }

}