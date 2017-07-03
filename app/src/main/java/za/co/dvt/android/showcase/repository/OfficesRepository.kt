package za.co.dvt.android.showcase.repository

import io.reactivex.Flowable
import za.co.dvt.android.showcase.model.Office

/**
 * @author rebeccafranks
 * @since 2017/06/25.
 */
interface OfficesRepository {
    fun getOffices(): Flowable<List<Office>>
}