package za.co.dvt.android.showcase.ui.listapps

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import za.co.dvt.android.showcase.R
import za.co.dvt.android.showcase.model.AppModel
import za.co.dvt.android.showcase.utils.FirebaseImageLoader

class AppAdapter(private var items: List<AppModel>, private val context: Context, private val taskNavigator: ListAppsNavigator) : RecyclerView.Adapter<AppViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_item_app, parent, false)
        return AppViewHolder(v)
    }

    override fun onBindViewHolder(holder: AppViewHolder, position: Int) {
        val (_, name, shortDescription, _, iconUrl) = items[position]
        holder.textViewAppName.text = name
        holder.textViewDescription.text = shortDescription
        holder.itemView.tag = items[position]
        holder.itemView.setOnClickListener { view ->
            val app = view.tag as AppModel
            taskNavigator.onAppClick(app)
        }
        if (!TextUtils.isEmpty(iconUrl)) {
            Glide.with(context).using(FirebaseImageLoader()).load(getStorageRef(iconUrl))
                    .into(holder.imageViewAppIcon)
        }
    }

    private fun getStorageRef(iconUrl: String): StorageReference? {
        return FirebaseStorage.getInstance().getReference(iconUrl)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setItems(appModelList: List<AppModel>) {
        this.items = appModelList
        notifyDataSetChanged()
    }
}