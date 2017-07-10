package za.co.dvt.android.showcase.ui.listapps

import android.support.v7.widget.RecyclerView
import android.view.View
import za.co.dvt.android.showcase.databinding.ListItemAppBinding
import za.co.dvt.android.showcase.model.AppModel


class AppViewHolder(view: View, val binding: ListItemAppBinding) : RecyclerView.ViewHolder(view) {

    fun bind(app: AppModel, appItemNavigator: AppItemNavigator) {
        binding.appInfo = app
        binding.navigator = appItemNavigator
        binding.executePendingBindings()
    }
}