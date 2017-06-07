package za.co.dvt.android.showcase.ui.listapps


import za.co.dvt.android.showcase.repository.AppRepository

class ListAppsPresenter(private val appRepository: AppRepository) {

    fun loadApps() {
        /*
         appRepository.listApps
                 .doOnSubscribe { _ -> view.showLoadingIndicator() }
                 .doOnSuccess { _ -> view.hideLoadingIndicator() }
                 .doOnError { _ -> view.hideLoadingIndicator() }
                 .subscribeOn(Schedulers.io())
                 .observeOn(AndroidSchedulers.mainThread())
                 .subscribe(object : MaybeObserver<List<AppModel>> {
                     override fun onSubscribe(d: Disposable) {

                     }

                     override fun onSuccess(appModels: List<AppModel>) {
                         Timber.d("onSuccess:" + appModels.toString())
                         if (appModels.isEmpty()) {
                             view.showNoApps()
                             return
                         }
                         view.showApps(appModels)
                     }

                     override fun onError(e: Throwable) {
                         Timber.e("onError:", e)
                         if (e is IOException) {
                             view.showNoInternetError()
                         } else {
                             view.showGenericError()
                         }
                     }

                     override fun onComplete() {

                     }
                 })*/
    }
}
