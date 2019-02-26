package ke.co.ekenya.ksiundu.sparkle.ui;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import ke.co.ekenya.ksiundu.sparkle.R;
import ke.co.ekenya.ksiundu.sparkle.adapter.AllOrdersFragment;
import spencerstudios.com.bungeelib.Bungee;

public class AllOrdersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_orders);

        ImageView allOrdersBack = findViewById(R.id.allOrdersBack);
        allOrdersBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AllOrdersActivity.this, HomeActivity.class));
                Bungee.fade(AllOrdersActivity.this);
            }
        });

        final TextView textOngoing = findViewById(R.id.textOngoingOrders);
        final TextView textPast = findViewById(R.id.textPastOrders);

        final ViewPager mOrdersPager = findViewById(R.id.viewPagerOrders);
        mOrdersPager.setOffscreenPageLimit(2);

        AllOrdersFragment adapter = new AllOrdersFragment(getSupportFragmentManager());
        mOrdersPager.setAdapter(adapter);

        textOngoing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOrdersPager.setCurrentItem(0);
            }
        });

        textPast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOrdersPager.setCurrentItem(1);
            }
        });

        mOrdersPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position == 0) {
                    textOngoing.setTextColor(getResources().getColor(R.color.colorText));

                    textPast.setTextColor(getResources().getColor(R.color.black_button));
                } else if (position == 1) {
                    textPast.setTextColor(getResources().getColor(R.color.colorText));

                    textOngoing.setTextColor(getResources().getColor(R.color.black_button));
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Bungee.fade(AllOrdersActivity.this);
    }
}
