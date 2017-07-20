package za.co.dvt.android.showcase.ui.viewapp

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import timber.log.Timber
import za.co.dvt.android.showcase.databinding.ListItemScreenshotBinding

/**
 * @author rebeccafranks
 * @since 2017/07/19.
 */
class ScreenshotAdapter(val screenshots: List<String>) : RecyclerView.Adapter<ScreenshotViewHolder>() {


    override fun getItemCount(): Int {
        return screenshots.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ScreenshotViewHolder {
        val view = ListItemScreenshotBinding.inflate(LayoutInflater.from(parent?.context))
        val viewHolder = ScreenshotViewHolder(view.root, view)
        return viewHolder

    }

    override fun onBindViewHolder(holder: ScreenshotViewHolder?, position: Int) {
        val item = screenshots[position]
        Timber.d("Screenshot Url: $item at $position ")
        holder?.bind(item)
    }

}