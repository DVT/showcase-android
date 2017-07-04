package za.co.dvt.android.showcase.injection

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import timber.log.Timber
import za.co.dvt.android.showcase.ShowcaseApplication

/**
 * @author rebeccafranks
 * *
 * @since 2017/06/07.
 */

class ShowcaseFactory(private val application: ShowcaseApplication) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val t = super.create(modelClass)
        if (t is ShowcaseComponent.Injectable) {
            t.inject(application.showcaseComponent)
        } else {
            Timber.d("item is not of type ShowcaseComponent.Injectable")
        }
        return t
    }
}
