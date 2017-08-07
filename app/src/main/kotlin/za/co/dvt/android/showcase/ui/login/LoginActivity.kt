package za.co.dvt.android.showcase.ui.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import za.co.dvt.android.showcase.R

/**
 * @author rebeccafranks
 * @since 2017/06/08.
 */
class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setBackgroundDrawableResource(R.drawable.blue_background)
        setContentView(R.layout.activity_login_screen)
    }

    companion object {
        fun createIntent(context: Context) = Intent(context, LoginActivity::class.java)
    }
}