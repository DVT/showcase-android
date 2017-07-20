package za.co.dvt.android.showcase.ui.viewapp

import android.arch.lifecycle.LifecycleFragment
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
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

    lateinit var viewBinding: FragmentAppDetailBinding

    var selectedApp: String? = null

    lateinit var screenshotRecyclerView: RecyclerView
    lateinit var screenshotAdapter: ScreenshotAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewBinding = FragmentAppDetailBinding.inflate(inflater)
        selectedApp = activity.intent.getStringExtra(ViewAppActivity.ARG_APP_ID)
        setHasOptionsMenu(true)
        setupViewModel()
        setupToolbar(viewBinding)
        setupScreenshotRecyclerView()
        return viewBinding.root
    }

    private fun setupScreenshotRecyclerView() {
        screenshotRecyclerView = viewBinding.recyclerViewAppScreenshots
        screenshotAdapter = ScreenshotAdapter(ArrayList())
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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            activity.finish()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setupViewModel() {
        viewAppViewModel = ViewModelProviders
                .of(this, ShowcaseFactory(activity.application as ShowcaseApplication))
                .get(ViewAppViewModel::class.java)
        selectedApp?.let { selectedApp ->
            viewAppViewModel.loadApp(selectedApp).subscribe { item ->
                viewBinding.appModel = item
                if (item.screenshots != null) {
                    screenshotAdapter = ScreenshotAdapter(item.screenshots!!)
                    screenshotRecyclerView.adapter = screenshotAdapter
                } else {
                    screenshotRecyclerView.visibility = View.GONE
                }

            }
        }

    }

}
