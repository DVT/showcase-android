package za.co.dvt.android.showcase.ui.viewapp.screenshots

import android.support.v7.widget.RecyclerView
import android.view.View
import za.co.dvt.android.showcase.databinding.ListItemScreenshotBinding

/**
 * @author rebeccafranks
 * @since 2017/07/19.
 */
class ScreenshotViewHolder(itemView: View, val binding: ListItemScreenshotBinding, val screenshotNavigator: ScreenshotNavigator) : RecyclerView.ViewHolder(itemView) {

    fun bind(screenshotUrl: String?) {
        binding.screenshotUrl = screenshotUrl
        binding.screenshotNavigator = screenshotNavigator
        binding.executePendingBindings()

    }
}