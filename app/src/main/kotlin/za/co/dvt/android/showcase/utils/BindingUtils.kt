package za.co.dvt.android.showcase.utils

import android.databinding.BindingAdapter
import android.text.TextUtils
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.google.firebase.storage.FirebaseStorage

/**
 * @author rebeccafranks
 * *
 * @since 2017/07/10.
 */
@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, image: String?) {
    image?.let {
        if (!TextUtils.isEmpty(image)) {
            Glide.with(view.context).using(FirebaseImageLoader())
                    .load(FirebaseStorage.getInstance().getReference(image))
                    .into(view)
        }
    }

}
