package za.co.dvt.android.showcase.ui.listapps

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import za.co.dvt.android.showcase.databinding.ListItemAppBinding
import za.co.dvt.android.showcase.model.AppModel

class AppAdapter(private var items: List<AppModel>, private val appItemNavigator: AppItemNavigator) : RecyclerView.Adapter<AppViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppViewHolder {
        val itemBinding = ListItemAppBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val appViewHolder = AppViewHolder(itemBinding.root, itemBinding)
        return appViewHolder
    }

    override fun onBindViewHolder(holder: AppViewHolder, position: Int) {
        val appItem = items[position]
        holder.bind(appItem, appItemNavigator)
    }


    override fun getItemCount(): Int {
        return items.size
    }

    fun setItems(appModelList: List<AppModel>) {
        this.items = appModelList
        notifyDataSetChanged()
    }
}