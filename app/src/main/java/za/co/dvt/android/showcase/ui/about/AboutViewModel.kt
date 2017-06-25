package za.co.dvt.android.showcase.ui.about

import android.arch.lifecycle.ViewModel
import za.co.dvt.android.showcase.injection.ShowcaseComponent

/**
 * @author rebeccafranks
 * @since 2017/06/07.
 */
class AboutViewModel : ViewModel(), ShowcaseComponent.Injectable {
    override fun inject(component: ShowcaseComponent) {
        component.inject(this)
    }

}