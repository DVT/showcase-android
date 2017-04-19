package za.co.dvt.android.showcase.presentation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import za.co.dvt.android.showcase.R;
import za.co.dvt.android.showcase.presentation.about.AboutFragment;
import za.co.dvt.android.showcase.presentation.contact.ContactUsFragment;
import za.co.dvt.android.showcase.presentation.listapps.ListAppsFragment;

public class MainNavigationActivity extends AppCompatActivity {

    private FrameLayout frameLayout;

    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener
            = item -> {
        switch (item.getItemId()) {
            case R.id.navigation_home:
                showScreen(ListAppsFragment.newInstance());
                return true;
            case R.id.navigation_about:
                showScreen(AboutFragment.newInstance());
                return true;
            case R.id.navigation_contact:
                showScreen(ContactUsFragment.newInstance());
                return true;
        }
        return false;
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_navigation);

        frameLayout = (FrameLayout) findViewById(R.id.fragment_content);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
        navigation.setSelectedItemId(R.id.navigation_home);
    }

    public void showScreen(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_content, fragment);
        fragmentTransaction.commit();
    }

    public static Intent createIntent(Context context) {
        return new Intent(context, MainNavigationActivity.class);
    }
}
