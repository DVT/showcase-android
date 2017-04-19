package za.co.dvt.android.showcase.presentation.listapps;


import java.util.List;

import za.co.dvt.android.showcase.model.AppModel;
import za.co.dvt.android.showcase.presentation.base.MvpPresenter;
import za.co.dvt.android.showcase.presentation.base.MvpView;

public interface ListAppsContract {

    interface View extends MvpView {

        void showApps(List<AppModel> appModelList);

        void showNoInternetError();

        void showGenericError();

        void showLoadingIndicator();

        void hideLoadingIndicator();

        void showNoApps();
    }

    interface Presenter extends MvpPresenter<View> {

        void loadApps();

    }
}
