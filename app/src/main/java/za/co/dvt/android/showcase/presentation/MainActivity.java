package za.co.dvt.android.showcase.presentation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import za.co.dvt.android.showcase.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public static Intent createIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }
}
