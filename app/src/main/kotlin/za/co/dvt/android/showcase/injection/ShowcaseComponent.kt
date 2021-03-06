package za.co.dvt.android.showcase.injection;

import dagger.Component
import za.co.dvt.android.showcase.ui.about.AboutViewModel
import za.co.dvt.android.showcase.ui.contact.ContactUsViewModel
import za.co.dvt.android.showcase.ui.listapps.ListAppsViewModel
import za.co.dvt.android.showcase.ui.login.LoginViewModel
import za.co.dvt.android.showcase.ui.viewapp.ViewAppViewModel
import za.co.riggaroo.datecountdown.injection.ApplicationModule
import javax.inject.Singleton

/**
 * @author rebeccafranks
 * @since 2017/06/07.
 */

@Singleton
@Component(modules = arrayOf(ShowcaseModule::class, ApplicationModule::class))
interface ShowcaseComponent {

    fun inject(aboutViewModel: AboutViewModel)

    fun inject(loginViewModel: LoginViewModel)

    fun inject(aboutViewModel: ListAppsViewModel)

    fun inject(contactUsViewModel: ContactUsViewModel)

    interface Injectable {
        fun inject(component: ShowcaseComponent)
    }

    fun inject(viewAppViewModel: ViewAppViewModel)


}

