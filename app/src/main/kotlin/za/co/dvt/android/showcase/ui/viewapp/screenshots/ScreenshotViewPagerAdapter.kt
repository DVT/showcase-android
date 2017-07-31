package za.co.dvt.android.showcase.ui.viewapp.screenshots

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

/**
 * @author rebeccafranks
 * *
 * @since 2017/07/31.
 */

class ScreenshotViewPagerAdapter(fragmentManager: FragmentManager, val listScreenshots: ArrayList<String>) : FragmentStatePagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment {
        return ScreenshotFragment.newInstance(listScreenshots[position])
    }

    override fun getCount(): Int {
        return listScreenshots.size
    }

}
