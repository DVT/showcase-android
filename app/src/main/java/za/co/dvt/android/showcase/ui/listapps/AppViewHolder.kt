package za.co.dvt.android.showcase.ui.listapps

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView

import za.co.dvt.android.showcase.R


class AppViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    var textViewAppName: TextView = view.findViewById(R.id.text_view_app_name)
    var textViewDescription: TextView = view.findViewById(R.id.text_view_app_description)
    var imageViewAppIcon: ImageView = view.findViewById(R.id.image_view_app_icon)

}