package za.co.dvt.android.showcase.ui.listapps

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.ViewGroup

import za.co.dvt.android.showcase.R
import za.co.dvt.android.showcase.model.AppModel

class AppAdapter(private var items: List<AppModel>, private val context: Context) : RecyclerView.Adapter<AppViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_item_app, parent, false)
        return AppViewHolder(v)
    }

    override fun onBindViewHolder(holder: AppViewHolder, position: Int) {
        val (name, shortDescription, _, iconUrl) = items[position]
        holder.textViewAppName.text = name
        holder.textViewDescription.text = shortDescription
        if (!TextUtils.isEmpty(iconUrl)) {
            /*  Glide.with(context).using(new FirebaseImageLoader()).load(getStorageRef(item.getIconUrl()))
                    .into(holder.imageViewAppIcon);*/
        }
    }

    /*   private StorageReference getStorageRef(final String iconUrl) {
        return FirebaseStorage.getInstance().getReference(iconUrl);
    }*/

    override fun getItemCount(): Int {
        return items.size
    }

    fun setItems(appModelList: List<AppModel>) {
        this.items = appModelList
        notifyDataSetChanged()
    }
}