package za.co.dvt.android.showcase.ui.about


import android.arch.lifecycle.LifecycleFragment
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import za.co.dvt.android.showcase.DvtShowcaseApplication
import za.co.dvt.android.showcase.R
import za.co.dvt.android.showcase.injection.ShowcaseFactory


class AboutFragment : LifecycleFragment() {


    lateinit var aboutViewModel: AboutViewModel


    fun openTwitter() {
        val twitterUserName = "DVT_Corporate"
        try {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("twitter://user?screen_name=" + twitterUserName)))
        } catch (e: Exception) {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/#!/" + twitterUserName)))
        }

    }

    fun openFacebook() {
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/DVTmedia")))
    }

    fun openWebsite() {
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("http://dvt.co.za")))
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_about, container, false)
        view?.let {
            val twitterButton = it.findViewById(R.id.buttonTwitter) as Button
            val facebookButton = it.findViewById(R.id.buttonFacebook) as Button
            val websiteButton = it.findViewById(R.id.buttonWebsite) as Button

            twitterButton.setOnClickListener { aboutViewModel.openTwitter() }
            facebookButton.setOnClickListener { aboutViewModel.openFacebook() }
            websiteButton.setOnClickListener { aboutViewModel.openWebsite() }
        }

        setupViewModel()
        return view
    }

    private fun setupViewModel() {
        aboutViewModel = ViewModelProviders.of(this,
                ShowcaseFactory(activity.application as DvtShowcaseApplication))
                .get(AboutViewModel::class.java)
        aboutViewModel.openWebsite.observe(this, Observer<Void> { openWebsite() })
        aboutViewModel.openFacebook.observe(this, Observer<Void> { openFacebook() })
        aboutViewModel.openTwitter.observe(this, Observer<Void> { openTwitter() })
    }

    companion object {

        fun newInstance(): AboutFragment {

            val args = Bundle()

            val fragment = AboutFragment()
            fragment.arguments = args
            return fragment
        }
    }
}
