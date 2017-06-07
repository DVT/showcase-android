package za.co.dvt.android.showcase.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.annotation.MainThread
import android.support.annotation.StringRes
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.View

import za.co.dvt.android.showcase.R
import za.co.dvt.android.showcase.ui.MainNavigationActivity

/**
 * @author rebeccafranks
 * *
 * @since 2017/04/13
 */

class SplashActivity : AppCompatActivity() {
    private lateinit var rootView: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        rootView = findViewById(R.id.root_splash)
        val handler = Handler()
        handler.postDelayed({
            /*   if (FirebaseAuth.getInstance().getCurrentUser() == null) {
                signIn();
            } else {*/
            signedInSuccess()
            // }
        }, 1000)

    }

    fun signIn() {
        /*   startActivityForResult(
                AuthUI.getInstance().createSignInIntentBuilder().setTheme(R.style.AppTheme).setLogo(R.drawable.dvt_logo)
                        .setProviders(getSelectedProviders()).setIsSmartLockEnabled(false)
                        .setAllowNewEmailAccounts(true).build(), RC_SIGN_IN);
 */
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RC_SIGN_IN) {
            //       handleSignInResponse(resultCode, data);
            return
        }

        showSnackbar(R.string.unknown_response)
    }

    private fun signedInSuccess() {
        startActivity(MainNavigationActivity.createIntent(this))
        finish()
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
    private fun showSnackbar(@StringRes errorMessageRes: Int) {
        Snackbar.make(rootView, errorMessageRes, Snackbar.LENGTH_LONG).show()
    }

    companion object {
        private val RC_SIGN_IN = 1
        private val TAG = "SplashActivity"
    }

}
