package za.co.dvt.android.showcase.repository.impl

import com.google.firebase.database.FirebaseDatabase

import io.reactivex.Maybe
import za.co.dvt.android.rxjava2firebase.DataSnapshotMapper
import za.co.dvt.android.rxjava2firebase.RxFirebaseDatabase
import za.co.dvt.android.showcase.model.AppModel
import za.co.dvt.android.showcase.repository.AppRepository


/**
 * @author rebeccafranks
 * *
 * @since 2017/04/13
 */

class FirebaseAppRepository(private val firebaseDatabase: FirebaseDatabase) : AppRepository {

    override fun getAppById(appId: String): Maybe<AppModel> {
        return Maybe.just(AppModel("1", "DStv Now", "Watch DStv on the Go!", true, client = "DStv"))
    }

    override fun listApps(): Maybe<List<AppModel>> {
        return RxFirebaseDatabase.observeSingleValueEvent(firebaseDatabase.getReference("apps"),
                DataSnapshotMapper.listOf(AppModel::class.java))

    }

}
