package za.co.dvt.android.showcase.presentation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import za.co.dvt.android.showcase.R;
import za.co.dvt.android.showcase.presentation.listapps.ListAppsFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(android.R.id.content, ListAppsFragment.newInstance());
        fragmentTransaction.commit();
    }

    public static Intent createIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }
}
