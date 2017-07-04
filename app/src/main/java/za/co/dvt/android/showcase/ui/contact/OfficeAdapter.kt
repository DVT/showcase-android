package za.co.dvt.android.showcase.ui.contact

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.google.firebase.storage.FirebaseStorage
import za.co.dvt.android.showcase.databinding.ListItemOfficeBinding
import za.co.dvt.android.showcase.model.Office
import za.co.dvt.android.showcase.utils.FirebaseImageLoader

/**
 * @author rebeccafranks
 * @since 2017/06/25.
 */
class OfficeAdapter(private var items: List<Office>, private var itemNavigator: OfficeItemNavigator) : RecyclerView.Adapter<OfficeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OfficeViewHolder {
        val itemBinding = ListItemOfficeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val officeViewHolder = OfficeViewHolder(itemBinding.root, itemBinding)
        return officeViewHolder
    }

    override fun onBindViewHolder(holder: OfficeViewHolder, position: Int) {
        val office = items[position]
        holder.bind(office, itemNavigator)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setItems(offices: List<Office>) {
        this.items = offices
        notifyDataSetChanged()
    }
}

@BindingAdapter("imageUrl")
public fun loadImage(view: ImageView, image: String) {
    if (!TextUtils.isEmpty(image)) {
        Glide.with(view.context).using(FirebaseImageLoader()).load(FirebaseStorage.getInstance().getReference(image))
                .into(view)
    }
}

