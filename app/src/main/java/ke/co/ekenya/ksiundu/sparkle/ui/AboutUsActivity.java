package ke.co.ekenya.ksiundu.sparkle.ui;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import ke.co.ekenya.ksiundu.sparkle.R;
import ke.co.ekenya.ksiundu.sparkle.adapter.AboutAdapter;
import spencerstudios.com.bungeelib.Bungee;

public class AboutUsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        ImageView aboutBack = findViewById(R.id.aboutUsBack);
        aboutBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AboutUsActivity.this, HomeActivity.class));
                Bungee.fade(AboutUsActivity.this);
            }
        });

        TextView mServices = findViewById(R.id.textAboutServices);
        TextView mAbout = findViewById(R.id.textAboutPager);
        TextView mReviews = findViewById(R.id.textAboutReviews);

        final ViewPager mAboutPager = findViewById(R.id.viewPagerAbout);
        mAboutPager.setOffscreenPageLimit(3);

        mServices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAboutPager.setCurrentItem(0);
            }
        });

        mAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAboutPager.setCurrentItem(1);
            }
        });

        mReviews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAboutPager.setCurrentItem(2);
            }
        });

        AboutAdapter mAdapter = new AboutAdapter(getSupportFragmentManager());
        mAboutPager.setAdapter(mAdapter);

        mAboutPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

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
        Bungee.fade(AboutUsActivity.this);
    }
}
