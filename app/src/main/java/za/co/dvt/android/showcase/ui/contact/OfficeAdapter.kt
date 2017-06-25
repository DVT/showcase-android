package za.co.dvt.android.showcase.ui.contact

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import za.co.dvt.android.showcase.databinding.ListItemOfficeBinding
import za.co.dvt.android.showcase.model.Office

/**
 * @author rebeccafranks
 * @since 2017/06/25.
 */
class OfficeAdapter(private var items: List<Office>, private val context: Context) : RecyclerView.Adapter<OfficeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OfficeViewHolder {
        val itemBinding = ListItemOfficeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val officeViewHolder = OfficeViewHolder(itemBinding.root, itemBinding)
        officeViewHolder.initializeMapView()
        return officeViewHolder
    }

    override fun onBindViewHolder(holder: OfficeViewHolder, position: Int) {
        val office = items[position]
        holder.bind(office)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setItems(offices: List<Office>) {
        this.items = offices
        notifyDataSetChanged()
    }
}