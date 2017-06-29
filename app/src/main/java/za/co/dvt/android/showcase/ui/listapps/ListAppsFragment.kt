package za.co.dvt.android.showcase.ui.listapps

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import io.reactivex.MaybeObserver
import io.reactivex.disposables.Disposable
import timber.log.Timber
import za.co.dvt.android.showcase.R
import za.co.dvt.android.showcase.ShowcaseApplication
import za.co.dvt.android.showcase.injection.ShowcaseFactory
import za.co.dvt.android.showcase.model.AppModel
import za.co.dvt.android.showcase.ui.viewapp.ViewAppActivity

/**
 * @author rebeccafranks
 * *
 * @since 2017/04/13
 */

class ListAppsFragment : Fragment(), ListAppsNavigator {

    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerViewAdapter: AppAdapter
    private lateinit var progressBar: ProgressBar
    private lateinit var errorTextView: TextView
    private lateinit var listAppsViewModel: ListAppsViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_list_apps, container, false)
        setupRecyclerView(v)
        setupToolbar(v)
        setupErrorViews(v)
        setupViewModel()
        return v
    }

    private fun setupViewModel() {
        listAppsViewModel = ViewModelProviders.of(this,
                ShowcaseFactory(activity.application as ShowcaseApplication))
                .get(ListAppsViewModel::class.java)
        listAppsViewModel.getAppList().subscribe(object : MaybeObserver<List<AppModel>> {
            override fun onSubscribe(d: Disposable?) {
            }

            override fun onSuccess(items: List<AppModel>) {
                hideLoadingIndicator()
                showApps(items)
            }

            override fun onComplete() {

            }

            override fun onError(e: Throwable?) {
                Timber.e("Exception getting apps:", e)
            }
        })
    }

    private fun setupErrorViews(v: View) {
        progressBar = v.findViewById(R.id.progress_bar) as ProgressBar
        errorTextView = v.findViewById(R.id.text_view_error_msg) as TextView
    }

    private fun setupToolbar(v: View) {
        val toolbar = v.findViewById(R.id.toolbar) as Toolbar
        toolbar.setTitle(R.string.list_apps_title)
    }

    private fun setupRecyclerView(v: View) {
        recyclerView = v.findViewById(R.id.recycler_view_apps) as RecyclerView
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = layoutManager
        recyclerViewAdapter = AppAdapter(ArrayList(), context, this)
        recyclerView.adapter = recyclerViewAdapter
        val dividerItemDecoration = DividerItemDecoration(recyclerView.context,
                layoutManager.orientation)
        recyclerView.addItemDecoration(dividerItemDecoration)
    }

    fun showApps(appModelList: List<AppModel>) {
        recyclerView.visibility = View.VISIBLE
        recyclerViewAdapter.setItems(appModelList)
    }

    fun showNoInternetError() {
        showError(getString(R.string.load_apps_no_internet))
    }

    private fun showError(error: String) {
        errorTextView.visibility = View.VISIBLE
        errorTextView.text = error
    }

    fun showGenericError() {
        showError(getString(R.string.load_apps_generic_error))
    }

    fun showLoadingIndicator() {
        progressBar.visibility = View.VISIBLE
    }

    fun hideLoadingIndicator() {
        progressBar.visibility = View.INVISIBLE
    }

    fun showNoApps() {
        showError(getString(R.string.load_apps_no_apps))
    }

    override fun onAppClick(app: AppModel) {
        val bundle = Bundle()
        bundle.putString(ViewAppActivity.ARG_APP_ID, app.id)

        startActivity(Intent(activity, ViewAppActivity::class.java), bundle)
    }

    companion object {

        fun newInstance(): ListAppsFragment {
            return ListAppsFragment()
        }
    }
}
