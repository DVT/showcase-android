package za.co.dvt.android.showcase.presentation.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.MainThread;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import za.co.dvt.android.showcase.R;
import za.co.dvt.android.showcase.presentation.MainNavigationActivity;

/**
 * @author rebeccafranks
 * @since 2017/04/13
 */

public class SplashActivity extends AppCompatActivity {
    private static final int RC_SIGN_IN = 1;
    private static final String TAG = "SplashActivity";
    private View rootView;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        rootView = findViewById(R.id.root_splash);
        Handler handler = new Handler();
        handler.postDelayed(() -> {
         /*   if (FirebaseAuth.getInstance().getCurrentUser() == null) {
                signIn();
            } else {*/
            signedInSuccess();
            // }
        }, 1000);

    }

    public void signIn() {
     /*   startActivityForResult(
                AuthUI.getInstance().createSignInIntentBuilder().setTheme(R.style.AppTheme).setLogo(R.drawable.dvt_logo)
                        .setProviders(getSelectedProviders()).setIsSmartLockEnabled(false)
                        .setAllowNewEmailAccounts(true).build(), RC_SIGN_IN);
 */
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            //       handleSignInResponse(resultCode, data);
            return;
        }

        showSnackbar(R.string.unknown_response);
    }

    private void signedInSuccess() {
        startActivity(MainNavigationActivity.createIntent(this));
        finish();
    }

   /* @MainThread
    private void handleSignInResponse(int resultCode, Intent data) {
        IdpResponse response = IdpResponse.fromResultIntent(data);
        Log.d(TAG, "IdpResponse:" + response);
        // Successfully signed in
        if (resultCode == ResultCodes.OK) {

            signedInSuccess();
            return;
        } else {
            finish();
            // Sign in failed
            if (response == null) {
                // User pressed back button
                showSnackbar(R.string.sign_in_cancelled);

                return;
            }

            if (response.getErrorCode() == ErrorCodes.NO_NETWORK) {
                showSnackbar(R.string.no_internet_connection);
                return;
            }

            if (response.getErrorCode() == ErrorCodes.UNKNOWN_ERROR) {
                showSnackbar(R.string.unknown_error);
                return;
            }
        }

        showSnackbar(R.string.unknown_sign_in_response);
    }
*/
   /* @MainThread
    private List<AuthUI.IdpConfig> getSelectedProviders() {
        List<AuthUI.IdpConfig> selectedProviders = new ArrayList<>();

        selectedProviders.add(new AuthUI.IdpConfig.Builder(AuthUI.EMAIL_PROVIDER).build());
        selectedProviders.add(new AuthUI.IdpConfig.Builder(AuthUI.GOOGLE_PROVIDER).build());
        return selectedProviders;
    }*/


    @MainThread
    private void showSnackbar(@StringRes int errorMessageRes) {
        Snackbar.make(rootView, errorMessageRes, Snackbar.LENGTH_LONG).show();
    }

}
