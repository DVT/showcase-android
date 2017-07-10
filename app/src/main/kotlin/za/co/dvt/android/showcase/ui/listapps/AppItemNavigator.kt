package za.co.dvt.android.showcase.ui.listapps

import za.co.dvt.android.showcase.model.AppModel

/**
 * @author rebeccafranks
 * *
 * @since 2017/06/22.
 */

interface AppItemNavigator {
    fun onAppClick(app: AppModel)
}
