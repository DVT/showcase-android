package za.co.dvt.android.showcase.presentation.listapps;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import za.co.dvt.android.showcase.R;
import za.co.dvt.android.showcase.model.AppModel;

public class AppAdapter extends RecyclerView.Adapter<AppViewHolder> {
    private final Context context;
    private List<AppModel> items;

    public AppAdapter(List<AppModel> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public AppViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_app, parent, false);
        return new AppViewHolder(v);
    }

    @Override
    public void onBindViewHolder(AppViewHolder holder, int position) {
        AppModel item = items.get(position);
        holder.textViewAppName.setText(item.name());

    }

    @Override
    public int getItemCount() {
        if (items == null) {
            return 0;
        }
        return items.size();
    }

    public void setItems(final List<AppModel> appModelList) {
        this.items = appModelList;
        notifyDataSetChanged();
    }
}