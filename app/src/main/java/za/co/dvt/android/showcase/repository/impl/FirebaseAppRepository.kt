package za.co.dvt.android.showcase.repository.impl

import com.google.firebase.database.FirebaseDatabase

import io.reactivex.Maybe
import za.co.dvt.android.showcase.model.AppModel
import za.co.dvt.android.showcase.repository.AppRepository

/**
 * @author rebeccafranks
 * *
 * @since 2017/04/13
 */

class FirebaseAppRepository(private val firebaseDatabase: FirebaseDatabase) : AppRepository {

    override fun listApps(): Maybe<List<AppModel>> {
        return Maybe.just(listOf(AppModel("DStv Now", "Watch DStv on the Go!", true, client = "DStv"),
                AppModel("EMF", "Events Management", true, client = "EMF")
        ))
    }

}
