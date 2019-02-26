package ke.co.ekenya.ksiundu.sparkle.helper;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import ke.co.ekenya.ksiundu.sparkle.R;

public class NotificationViewHolder extends RecyclerView.ViewHolder {
    public ImageView mNotifyImage;
    public TextView mNotifyTitle, mNotifyStatus, mNotifyDate;
    public NotificationViewHolder(View itemView) {
        super(itemView);

        mNotifyImage = itemView.findViewById(R.id.imageNotificationSingle);
        mNotifyTitle = itemView.findViewById(R.id.textNotificationTitle);
        mNotifyStatus = itemView.findViewById(R.id.textNotificationStatus);
        mNotifyDate = itemView.findViewById(R.id.textNotificationDate);
    }
}
