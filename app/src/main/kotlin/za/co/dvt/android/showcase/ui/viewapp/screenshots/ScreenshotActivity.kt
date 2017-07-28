package za.co.dvt.android.showcase.ui.viewapp.screenshots

import android.arch.lifecycle.LifecycleActivity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import za.co.dvt.android.showcase.R


class ScreenshotActivity : LifecycleActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screenshot)
    }

    companion object {

        fun startActivity(screenshotUrl: String, context: Context) {
            val intent = Intent(context, ScreenshotActivity::class.java)

            intent.putExtra(ScreenshotFragment.SCREENSHOT_URL, screenshotUrl)
            context.startActivity(intent)
        }

    }

}
