package za.co.riggaroo.datecountdown.injection

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import za.co.dvt.android.showcase.ShowcaseApplication

/**
 * @author rebeccafranks
 * @since 2017/06/02.
 */
@Module
class ApplicationModule(private val countdownApplication: ShowcaseApplication) {

    @Provides
    fun applicationContext(): Context = countdownApplication

    @Provides
    fun application(): Application = countdownApplication
}