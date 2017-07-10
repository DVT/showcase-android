package za.co.dvt.android.showcase.ui.viewapp

import android.arch.lifecycle.LifecycleFragment
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.firebase.database.FirebaseDatabase
import za.co.dvt.android.showcase.R
import za.co.dvt.android.showcase.ShowcaseApplication
import za.co.dvt.android.showcase.databinding.FragmentAppDetailBinding
import za.co.dvt.android.showcase.injection.ShowcaseFactory

/**
 * @author rebeccafranks
 * *
 * @since 2017/04/13
 */
class ViewAppFragment : LifecycleFragment() {

    lateinit var viewAppViewModel: ViewAppViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val viewBinding = FragmentAppDetailBinding.inflate(inflater)
        setupViewModel()
        setupToolbar(viewBinding)
        viewBinding.appViewModel = viewAppViewModel

        return viewBinding.root
    }

    private fun setupToolbar(view: FragmentAppDetailBinding) {
        (activity as AppCompatActivity).let { act ->
            act.setSupportActionBar(view.toolbar)
            act.supportActionBar?.let { actionBar ->
                actionBar.setDisplayHomeAsUpEnabled(true)
                actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back)
            }
        }

    }

    private fun setupViewModel() {
        viewAppViewModel = ViewModelProviders
                .of(this, ShowcaseFactory(activity.application as ShowcaseApplication))
                .get(ViewAppViewModel::class.java)
        viewAppViewModel.loadApp("1")
    }

}
