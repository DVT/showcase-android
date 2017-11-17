package za.co.dvt.android.showcase.ui.viewapp.screenshots

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.Window
import android.view.WindowManager
import za.co.dvt.android.showcase.R


class ScreenshotActivity : AppCompatActivity() {

    private var selectedIndex: Int = -1
    private lateinit var screenshotUrls: ArrayList<String>

    private lateinit var viewPagerAdapter: ScreenshotViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_screenshot)

        screenshotUrls = intent.extras.getStringArrayList(SCREENSHOT_URLS)
        selectedIndex = intent.extras.getInt(SELECTED_INDEX)

        val viewPager = findViewById<ViewPager>(R.id.view_pager)
        viewPagerAdapter = ScreenshotViewPagerAdapter(supportFragmentManager, screenshotUrls)
        viewPager.adapter = viewPagerAdapter
        viewPager.setCurrentItem(selectedIndex, false)

    }

    companion object {

        private val SCREENSHOT_URLS: String = "SCREENSHOT_URLS"
        private val SELECTED_INDEX: String = "SELECTED_INDEX"

        fun startActivity(screenshotUrls: ArrayList<String>, selectedIndex: Int, context: Context) {
            val intent = Intent(context, ScreenshotActivity::class.java)

            intent.putStringArrayListExtra(ScreenshotActivity.SCREENSHOT_URLS, screenshotUrls)
            intent.putExtra(ScreenshotActivity.SELECTED_INDEX, selectedIndex)
            context.startActivity(intent)
        }

    }

}
