package za.co.dvt.android.showcase.presentation.listapps;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import za.co.dvt.android.showcase.R;


public class AppViewHolder extends RecyclerView.ViewHolder {

    TextView textViewAppName;
    TextView textViewDescription;
    ImageView imageViewAppIcon;

    public AppViewHolder(View view) {
        super(view);
        textViewAppName = (TextView) view.findViewById(R.id.text_view_app_name);
        textViewDescription = (TextView) view.findViewById(R.id.text_view_app_description);
        imageViewAppIcon = (ImageView) view.findViewById(R.id.image_view_app_icon);
    }

}