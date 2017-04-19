package za.co.dvt.android.showcase.presentation.contact;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import za.co.dvt.android.showcase.R;

public class ContactUsFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact, container, false);
        return view;
    }

    public static ContactUsFragment newInstance() {

        Bundle args = new Bundle();

        ContactUsFragment fragment = new ContactUsFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
