package za.co.dvt.android.showcase.injection

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import za.co.dvt.android.showcase.DvtShowcaseApplication

/**
 * @author rebeccafranks
 * *
 * @since 2017/06/07.
 */

class ShowcaseFactory(private val application: DvtShowcaseApplication) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val t = super.create(modelClass)
        if (t is ShowcaseComponent.Injectable) {
            t.inject(application.showcaseComponent)
        }
        return t
    }
}
