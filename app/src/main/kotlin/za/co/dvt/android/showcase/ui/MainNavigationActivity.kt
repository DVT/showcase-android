package za.co.dvt.android.showcase.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.widget.FrameLayout
import za.co.dvt.android.showcase.R
import za.co.dvt.android.showcase.ui.about.AboutFragment
import za.co.dvt.android.showcase.ui.contact.ContactUsFragment
import za.co.dvt.android.showcase.ui.listapps.ListAppsFragment


class MainNavigationActivity : AppCompatActivity() {

    private var frameLayout: FrameLayout? = null

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item: MenuItem ->
        when (item.itemId) {
            R.id.navigation_home -> {
                showScreen(ListAppsFragment.newInstance())
                true
            }

            R.id.navigation_about -> {
                showScreen(AboutFragment.newInstance())
                true
            }
            R.id.navigation_contact -> {
                showScreen(ContactUsFragment.newInstance())
                true
            }
            else -> false
        }

    }

    private var selectedItem: Int = 0
    private lateinit var navigationView: BottomNavigationView

    private val SELECTED_FRAGMENT_BUNDLE = "selected_fragment"

    override fun onSaveInstanceState(outState: Bundle?, outPersistentState: PersistableBundle?) {
        super.onSaveInstanceState(outState, outPersistentState)
        selectedItem = navigationView.selectedItemId
        outState?.putInt(SELECTED_FRAGMENT_BUNDLE, selectedItem)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_navigation)

        frameLayout = findViewById(R.id.fragment_content)

        navigationView = findViewById<BottomNavigationView>(R.id.navigation)
        navigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        selectedItem = savedInstanceState?.getInt(SELECTED_FRAGMENT_BUNDLE) ?: R.id.navigation_home
        navigationView.selectedItemId = selectedItem
    }

    fun showScreen(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_content, fragment)
        fragmentTransaction.commit()
    }

    companion object {

        fun createIntent(context: Context): Intent {
            return Intent(context, MainNavigationActivity::class.java)
        }
    }
}
