package za.co.dvt.android.showcase.presentation.listapps;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

import za.co.dvt.android.showcase.R;
import za.co.dvt.android.showcase.model.AppModel;
import za.co.dvt.android.showcase.repository.impl.FirebaseAppRepository;

/**
 * @author rebeccafranks
 * @since 2017/04/13
 */

public class ListAppsFragment extends Fragment implements ListAppsContract.View {

    ListAppsContract.Presenter listAppsPresenter;
    RecyclerView recyclerView;
    private AppAdapter recyclerViewAdapter;


    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container,
                             @Nullable final Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_list_apps, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.recycler_view_apps);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerViewAdapter = new AppAdapter(null, getContext());
        recyclerView.setAdapter(recyclerViewAdapter);
        listAppsPresenter = new ListAppsPresenter(
                new FirebaseAppRepository(FirebaseDatabase.getInstance())); //TODO Extract into injection classes
        listAppsPresenter.attachView(this);
        listAppsPresenter.loadApps();

        return v;
    }

    @Override
    public void showApps(final List<AppModel> appModelList) {
        Toast.makeText(getContext(), "got apps", Toast.LENGTH_LONG).show();
        recyclerViewAdapter.setItems(appModelList);
    }

    @Override
    public void showNoInternetError() {

    }

    @Override
    public void showGenericError() {

    }

    public static ListAppsFragment newInstance() {
        return new ListAppsFragment();
    }
}
