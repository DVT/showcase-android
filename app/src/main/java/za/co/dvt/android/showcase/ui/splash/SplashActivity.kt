package za.co.dvt.android.showcase.ui.splash

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.annotation.MainThread
import android.support.annotation.StringRes
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.google.firebase.auth.FirebaseAuth

import za.co.dvt.android.showcase.R
import za.co.dvt.android.showcase.ui.MainNavigationActivity
import za.co.dvt.android.showcase.ui.login.LoginActivity

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
            if (FirebaseAuth.getInstance().currentUser == null) {
                signIn()
            } else {
                signedInSuccess()
            }
        }, 1000)

    }

    fun signIn() {
        startActivityForResult(LoginActivity.createIntent(this), RC_SIGN_IN)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RC_SIGN_IN) {
            handleSignInResponse(resultCode)
            return
        }

        showSnackbar(R.string.unknown_response)
    }

    private fun signedInSuccess() {
        startActivity(MainNavigationActivity.createIntent(this))
        finish()
    }

    private fun handleSignInResponse(resultCode: Int) {
        if (resultCode == Activity.RESULT_OK) {
            signedInSuccess()
        } else if (resultCode == Activity.RESULT_CANCELED) {
            finish()
        }

        showSnackbar(R.string.unknown_sign_in_response)
    }


    @MainThread
    private fun showSnackbar(@StringRes errorMessageRes: Int) {
        Snackbar.make(rootView, errorMessageRes, Snackbar.LENGTH_LONG).show()
    }

    companion object {
        private val RC_SIGN_IN = 1
    }


}
