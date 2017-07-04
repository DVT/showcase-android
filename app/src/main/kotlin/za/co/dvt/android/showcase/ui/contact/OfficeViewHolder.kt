package za.co.dvt.android.showcase.ui.contact

import android.support.v7.widget.RecyclerView
import android.view.View
import za.co.dvt.android.showcase.databinding.ListItemOfficeBinding
import za.co.dvt.android.showcase.model.Office


/**
 * @author rebeccafranks
 * @since 2017/06/25.
 */
class OfficeViewHolder(view: View, val binding: ListItemOfficeBinding) : RecyclerView.ViewHolder(view) {


    fun bind(office: Office, itemNavigator: OfficeItemNavigator) {
        binding.office = office
        binding.itemNavigator = itemNavigator
        binding.executePendingBindings()

    }


}
