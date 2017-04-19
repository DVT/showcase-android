package za.co.dvt.android.showcase.presentation.listapps;


import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.Maybe;
import za.co.dvt.android.showcase.model.AppModel;
import za.co.dvt.android.showcase.repository.AppRepository;
import za.co.dvt.android.showcase.utils.FakeDataGenerator;
import za.co.dvt.android.showcase.utils.RxSchedulersOverrideRule;

import static org.mockito.Matchers.anyListOf;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ListAppsPresenterTest {


    private static final List<AppModel> FAKE_DATA = FakeDataGenerator.generateApps();

    private ListAppsPresenter listAppsPresenter;

    @Mock
    ListAppsContract.View view;

    @Mock
    AppRepository appRepository;

    @Rule
    public RxSchedulersOverrideRule rxSchedulersOverrideRule = new RxSchedulersOverrideRule();


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        listAppsPresenter = new ListAppsPresenter(appRepository);
        listAppsPresenter.attachView(view);
    }

    @Test
    public void loadApps_RepositorySuccess_ShowsApps() {
        when(appRepository.getListApps()).thenReturn(Maybe.just(FAKE_DATA));

        listAppsPresenter.loadApps();

        verify(view).showLoadingIndicator();
        verify(view).hideLoadingIndicator();
        verify(view).showApps(FAKE_DATA);

    }

    @Test
    public void loadApps_RepositoryNoApps_ShowsErrorNoApps() {
        when(appRepository.getListApps()).thenReturn(Maybe.just(new ArrayList<>()));

        listAppsPresenter.loadApps();

        verify(view).showLoadingIndicator();
        verify(view).hideLoadingIndicator();
        verify(view, never()).showApps(anyListOf(AppModel.class));
        verify(view).showNoApps();

    }

    @Test
    public void loadApps_RepositoryError_ShowsError() {
        when(appRepository.getListApps()).thenReturn(Maybe.error(new IOException("No Internet")));

        listAppsPresenter.loadApps();

        verify(view).showLoadingIndicator();
        verify(view).hideLoadingIndicator();
        verify(view, never()).showApps(anyListOf(AppModel.class));
        verify(view).showNoInternetError();
    }

    @Test
    public void loadApps_RepositoryOtherError_ShowsGenericError() {
        when(appRepository.getListApps()).thenReturn(Maybe.error(new NumberFormatException()));

        listAppsPresenter.loadApps();

        verify(view).showLoadingIndicator();
        verify(view).hideLoadingIndicator();
        verify(view, never()).showApps(anyListOf(AppModel.class));
        verify(view).showGenericError();
    }
}
