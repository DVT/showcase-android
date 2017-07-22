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
import za.co.dvt.android.showcase.R
import za.co.dvt.android.showcase.ShowcaseApplication
import za.co.dvt.android.showcase.injection.ShowcaseFactory


class AboutFragment : LifecycleFragment() {


    lateinit var aboutViewModel: AboutViewModel


    fun openTwitter(twitterUserName: String) {

        try {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("twitter://user?screen_name=" + twitterUserName)))
        } catch (e: Exception) {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/" + twitterUserName)))
        }

    }

    fun openFacebook(facebookUserName: String) {
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/" + facebookUserName)))
    }

    fun openWebsite(websiteUrl: String) {
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(websiteUrl)))
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_about, container, false)

        val twitterButton = view.findViewById<Button>(R.id.buttonTwitter)
        val facebookButton = view.findViewById<Button>(R.id.buttonFacebook)
        val websiteButton = view.findViewById<Button>(R.id.buttonWebsite)

        twitterButton.setOnClickListener { aboutViewModel.openTwitter() }
        facebookButton.setOnClickListener { aboutViewModel.openFacebook() }
        websiteButton.setOnClickListener { aboutViewModel.openWebsite() }

        setupViewModel()
        return view
    }

    private fun setupViewModel() {
        aboutViewModel = ViewModelProviders.of(this,
                ShowcaseFactory(activity.application as ShowcaseApplication))
                .get(AboutViewModel::class.java)
        aboutViewModel.openWebsite.observe(this, Observer<String> { websiteUrl: String? ->
            websiteUrl?.let {
                openWebsite(websiteUrl)
            }
        })
        aboutViewModel.openFacebook.observe(this, Observer<String> { facebookPageName ->
            facebookPageName?.let {
                openFacebook(facebookPageName)
            }
        })
        aboutViewModel.openTwitter.observe(this, Observer<String> { twitterName ->
            twitterName?.let {
                openTwitter(twitterName)
            }
        })
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
