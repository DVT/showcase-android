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

   /* override fun getOffices(): Maybe<List<Office>> {
        return Maybe.just(listOf(Office("Johannesburg", "+2742524", "info@dvt.com", 28.03149899999994, -26.122743, "Ground Floor, Victoria Gate South,Hyde Lane Office Park, Hyde Park Lane, Hydepark, Johannesburg, 2196"),
                Office(
                        "Cape Town", "+2742524", "info@dvt.com", 24.05, -25.2, "Address"
                ),
                Office(
                        "Durban", "+2742524", "info@dvt.com", 24.05, -25.2, "Address "
                )

        ))
    }*/

    override fun getOffices(): Flowable<List<Office>> {
        return RxFirebaseDatabase.observeValueEvent(firebaseDatabase.getReference("offices"),
                DataSnapshotMapper.listOf(Office::class.java))
    }

}