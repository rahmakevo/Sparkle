package ke.co.ekenya.ksiundu.sparkle.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import ke.co.ekenya.ksiundu.sparkle.R;
import ke.co.ekenya.ksiundu.sparkle.helper.NotificationViewHolder;
import ke.co.ekenya.ksiundu.sparkle.model.NotificationModel;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationViewHolder> {
    ArrayList<NotificationModel> mNotificationList;
    Context context;

    public NotificationAdapter(ArrayList<NotificationModel> mNotificationList, Context context) {
        this.mNotificationList = mNotificationList;
        this.context = context;
    }

    @NonNull
    @Override
    public NotificationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mRootView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_notification, parent, false);
        return new NotificationViewHolder(mRootView);
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationViewHolder holder, int position) {
        holder.mNotifyImage.setImageResource(mNotificationList.get(position).getImage());
        holder.mNotifyTitle.setText(mNotificationList.get(position).getTitle());
        holder.mNotifyStatus.setText(mNotificationList.get(position).getStatus());
        holder.mNotifyDate.setText(mNotificationList.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return mNotificationList.size();
    }
}
