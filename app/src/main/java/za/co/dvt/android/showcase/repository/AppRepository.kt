package za.co.dvt.android.showcase.repository

import io.reactivex.Flowable
import io.reactivex.Maybe
import za.co.dvt.android.showcase.model.AppModel

/**
 * @author rebeccafranks
 * *
 * @since 2017/04/13
 */
interface AppRepository {

    fun listApps(): Flowable<List<AppModel>>

    fun getAppById(appId: String): Maybe<AppModel>

}
