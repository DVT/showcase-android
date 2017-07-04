package za.co.dvt.android.showcase.ui.viewapp

import android.arch.lifecycle.LifecycleActivity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import za.co.dvt.android.showcase.R

/**
 * @author rebeccafranks
 * @since 2017/06/28.
 */
class ViewAppActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app_detail)

    }

    companion object {
        val ARG_APP_ID = "app_id_arg"
    }


}