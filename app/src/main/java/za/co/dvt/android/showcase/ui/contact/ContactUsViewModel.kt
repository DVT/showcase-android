package za.co.dvt.android.showcase.ui.contact

import android.arch.lifecycle.ViewModel
import za.co.dvt.android.showcase.injection.ShowcaseComponent
import za.co.dvt.android.showcase.repository.OfficesRepository
import javax.inject.Inject

/**
 * @author rebeccafranks
 * @since 2017/06/25.
 */
class ContactUsViewModel : ViewModel(), ShowcaseComponent.Injectable {

    override fun inject(component: ShowcaseComponent) {
        component.inject(this)
    }


    @Inject
    lateinit var officesRepository: OfficesRepository


}