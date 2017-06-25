package za.co.dvt.android.showcase.repository.impl

import com.google.firebase.database.FirebaseDatabase
import io.reactivex.Maybe
import za.co.dvt.android.showcase.model.Office
import za.co.dvt.android.showcase.repository.OfficesRepository

/**
 * @author rebeccafranks
 * @since 2017/06/25.
 */
class FirebaseOfficesRepository(val firebaseDatabase: FirebaseDatabase) : OfficesRepository {

    override fun getOffices(): Maybe<List<Office>> {
        return Maybe.just(listOf(Office("Johannesburg", "+2742524", "info@dvt.com", 24.05, -25.2, "Address"),
                Office(
                        "Johannesburg", "+2742524", "info@dvt.com", 24.05, -25.2, "Address"
                )

        ))
    }

}