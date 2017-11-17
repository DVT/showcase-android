package za.co.dvt.android.showcase.ui.viewapp.screenshots

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import za.co.dvt.android.showcase.databinding.FragmentScreenshotBinding

/**
 * @author rebeccafranks
 * @since 2017/07/23.
 */
class ScreenshotFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = FragmentScreenshotBinding.inflate(inflater)
        val screenshotUrl = arguments.getString(SCREENSHOT_URL)
        view.screenshotUrl = screenshotUrl
        return view.root
    }

    companion object {
        private val SCREENSHOT_URL = "screenshot_url"

        fun newInstance(screenshotUrl: String): ScreenshotFragment {
            val bundle = Bundle()
            bundle.putString(SCREENSHOT_URL, screenshotUrl)
            val screenshotFragment = ScreenshotFragment()
            screenshotFragment.arguments = bundle
            return screenshotFragment
        }


    }
}