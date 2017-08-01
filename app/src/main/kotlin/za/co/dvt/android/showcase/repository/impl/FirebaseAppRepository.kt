package za.co.dvt.android.showcase.repository.impl

import com.google.firebase.database.FirebaseDatabase
import io.reactivex.Flowable
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

    override fun getAppById(appId: String): Flowable<AppModel> {
        return RxFirebaseDatabase.observeValueEvent(firebaseDatabase.getReference("apps").child(appId),
                DataSnapshotMapper.of(AppModel::class.java))
    }

    override fun listApps(): Flowable<List<AppModel>> {
        return RxFirebaseDatabase.observeValueEvent(firebaseDatabase.getReference("apps"),
                DataSnapshotMapper.listOf(AppModel::class.java))
    }

}
