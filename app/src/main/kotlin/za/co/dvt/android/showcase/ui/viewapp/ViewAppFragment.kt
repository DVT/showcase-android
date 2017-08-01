package za.co.dvt.android.showcase.ui.viewapp

import android.arch.lifecycle.LifecycleFragment
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.content.Intent.ACTION_VIEW
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import timber.log.Timber
import za.co.dvt.android.showcase.R
import za.co.dvt.android.showcase.ShowcaseApplication
import za.co.dvt.android.showcase.databinding.FragmentAppDetailBinding
import za.co.dvt.android.showcase.injection.ShowcaseFactory
import za.co.dvt.android.showcase.model.AppModel
import za.co.dvt.android.showcase.ui.viewapp.screenshots.ScreenshotActivity
import za.co.dvt.android.showcase.ui.viewapp.screenshots.ScreenshotAdapter
import za.co.dvt.android.showcase.ui.viewapp.screenshots.ScreenshotNavigator


/**
 * @author rebeccafranks
 * *
 * @since 2017/04/13
 */
class ViewAppFragment : LifecycleFragment(), AppDetailNavigator {


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
        setupAppStoreObservable()
        setupScreenshotRecyclerView()
        return viewBinding.root
    }

    fun setupAppStoreObservable() {
        viewAppViewModel.openAppStore.observe(this, Observer<AppModel> { appModel: AppModel? ->
            appModel?.let {
                openPlayStoreLink(appModel.androidPackageName)
            }
        })
    }

    private fun openPlayStoreLink(androidPackageName: String?) {
        try {
            val appStoreIntent = Intent(ACTION_VIEW, Uri.parse("market://details?id=" + androidPackageName))
            appStoreIntent.`package` = "com.android.vending"

            startActivity(appStoreIntent)
        } catch (exception: android.content.ActivityNotFoundException) {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + androidPackageName)))
        }

    }

    private fun setupScreenshotRecyclerView() {
        screenshotRecyclerView = viewBinding.recyclerViewAppScreenshots
        screenshotAdapter = ScreenshotAdapter(ArrayList(), screenshotNavigator)
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

    private val screenshotNavigator: ScreenshotNavigator = object : ScreenshotNavigator {
        override fun onScreenshotClicked(screenshotUrl: String) {
            Timber.d("onScreenshotClicked: $screenshotUrl")
            viewAppViewModel.app?.let { app ->
                val position = app.screenshots?.indexOf(screenshotUrl)
                position?.let {
                    ScreenshotActivity.startActivity(ArrayList(app.screenshots), position, context)
                }
            }

        }

    }

    private fun setupViewModel() {
        viewAppViewModel = ViewModelProviders
                .of(this, ShowcaseFactory(activity.application as ShowcaseApplication))
                .get(ViewAppViewModel::class.java)
        viewBinding.appDetailNavigator = this
        selectedApp?.let { selectedApp ->
            viewAppViewModel.loadApp(selectedApp).subscribe { item ->
                viewBinding.appModel = item
                if (item.screenshots != null) {
                    screenshotAdapter = ScreenshotAdapter(item.screenshots!!, screenshotNavigator)
                    screenshotRecyclerView.adapter = screenshotAdapter
                } else {
                    screenshotRecyclerView.visibility = View.GONE
                }

            }
        }

    }

    override fun installApp(app: AppModel) {
        viewAppViewModel.installApp(app)
    }
}
