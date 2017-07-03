package za.co.dvt.android.showcase.ui.contact

import za.co.dvt.android.showcase.model.Office

/**
 * @author rebeccafranks
 * *
 * @since 2017/07/03.
 */

interface OfficeItemNavigator {
    fun navigate(office: Office)
    fun email(office: Office)
    fun call(office: Office)
}
