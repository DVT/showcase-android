package za.co.dvt.android.showcase.repository.impl

import com.google.firebase.database.FirebaseDatabase
import io.reactivex.Flowable
import io.reactivex.Maybe
import za.co.dvt.android.rxjava2firebase.DataSnapshotMapper
import za.co.dvt.android.rxjava2firebase.RxFirebaseDatabase
import za.co.dvt.android.showcase.model.AppModel
import za.co.dvt.android.showcase.model.Office
import za.co.dvt.android.showcase.repository.OfficesRepository

/**
 * @author rebeccafranks
 * @since 2017/06/25.
 */
class FirebaseOfficesRepository(val firebaseDatabase: FirebaseDatabase) : OfficesRepository {

    override fun getOffices(): Flowable<List<Office>> {
        return RxFirebaseDatabase.observeValueEvent(firebaseDatabase.getReference("offices"),
                DataSnapshotMapper.listOf(Office::class.java))
    }

}