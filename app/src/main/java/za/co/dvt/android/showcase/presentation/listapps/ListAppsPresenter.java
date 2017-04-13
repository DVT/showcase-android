package za.co.dvt.android.showcase.presentation.listapps;


import java.util.List;

import io.reactivex.MaybeObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;
import za.co.dvt.android.showcase.model.AppModel;
import za.co.dvt.android.showcase.presentation.base.BasePresenter;
import za.co.dvt.android.showcase.repository.AppRepository;

public class ListAppsPresenter extends BasePresenter<ListAppsContract.View> implements ListAppsContract.Presenter {


    private final AppRepository appRepository;

    public ListAppsPresenter(AppRepository appRepository) {
        this.appRepository = appRepository;
    }

    @Override
    public void loadApps() {
        appRepository.getListApps().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MaybeObserver<List<AppModel>>() {
                    @Override
                    public void onSubscribe(final Disposable d) {

                    }

                    @Override
                    public void onSuccess(final List<AppModel> appModels) {
                        Timber.d("onSuccess:" + appModels.toString());
                        getView().showApps(appModels);
                    }

                    @Override
                    public void onError(final Throwable e) {
                        Timber.e("onError:", e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
