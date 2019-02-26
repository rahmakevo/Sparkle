package ke.co.ekenya.ksiundu.sparkle.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

import ke.co.ekenya.ksiundu.sparkle.R;
import ke.co.ekenya.ksiundu.sparkle.adapter.NotificationAdapter;
import ke.co.ekenya.ksiundu.sparkle.model.NotificationModel;
import spencerstudios.com.bungeelib.Bungee;

public class NotificationsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);

        ImageView notifyBack = findViewById(R.id.notificationsBack);
        notifyBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NotificationsActivity.this, HomeActivity.class));
                Bungee.fade(NotificationsActivity.this);
            }
        });

        RecyclerView mNotificationList = findViewById(R.id.recyclerViewNotifications);
        mNotificationList.setLayoutManager(new LinearLayoutManager(this));
        mNotificationList.setItemAnimator(new DefaultItemAnimator());
        NotificationAdapter mNotifyAdapter = new NotificationAdapter(getList(), this);
        mNotificationList.setAdapter(mNotifyAdapter);
    }

    private ArrayList<NotificationModel> getList() {
        ArrayList<NotificationModel> mNotifyList = new ArrayList<>();
        mNotifyList.add(new NotificationModel(R.drawable.ic_delivered, "Successfully Delivered",
                "Hey John! Your order 2017110987 has been successfully delivered to you. Please help us to serve you more better services by giving feedback and rating this order",
                "12 Nov"));
        mNotifyList.add(new NotificationModel(R.drawable.ic_delivered, "Your order is out for delivery", "Delivery guy will reach to you between 12:00 PM - 02:00 PM on Monday, 10 November 2017",
                "12 Nov"));
        mNotifyList.add(new NotificationModel(R.drawable.ic_in_process, "Your order is now in-process", "Your order is now in process. It will be shipped within 48 Hours.",
                "10 Nov"));
        return mNotifyList;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Bungee.fade(NotificationsActivity.this);
    }
}
