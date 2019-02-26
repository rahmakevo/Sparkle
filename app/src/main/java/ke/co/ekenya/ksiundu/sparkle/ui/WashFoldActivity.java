package ke.co.ekenya.ksiundu.sparkle.ui;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import ke.co.ekenya.ksiundu.sparkle.R;
import ke.co.ekenya.ksiundu.sparkle.adapter.WashFoldAdapter;
import ke.co.ekenya.ksiundu.sparkle.helper.CustomPref;
import spencerstudios.com.bungeelib.Bungee;

public class WashFoldActivity extends AppCompatActivity {
    int king, single, doubleCount, pillowCase, pillow, duvet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wash_fold);

        ImageView washFoldBack = findViewById(R.id.washFoldBack);
        washFoldBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WashFoldActivity.this, HomeActivity.class));
                Bungee.fade(WashFoldActivity.this);
            }
        });

        final TextView textMen = findViewById(R.id.textMen);
        final TextView textWomen = findViewById(R.id.textWomen);
        final TextView textBedding = findViewById(R.id.textBedding);
        final TextView textHousehold = findViewById(R.id.textHousehold);

        final ViewPager mWashPager = findViewById(R.id.viewPagerWashFold);
        mWashPager.setOffscreenPageLimit(3);

        WashFoldAdapter mWashAdapter = new WashFoldAdapter(getSupportFragmentManager());
        mWashPager.setAdapter(mWashAdapter);

        textMen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mWashPager.setCurrentItem(0);
            }
        });

        textWomen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mWashPager.setCurrentItem(1);
            }
        });

        textBedding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mWashPager.setCurrentItem(2);
            }
        });

        textHousehold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mWashPager.setCurrentItem(3);
            }
        });

        mWashPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    textMen.setBackground(getDrawable(R.drawable.background_text_view));
                    textMen.setTextColor(getResources().getColor(R.color.bgForgot));

                    textWomen.setTextColor(getResources().getColor(R.color.colorText));
                    textBedding.setTextColor(getResources().getColor(R.color.colorText));
                    textHousehold.setTextColor(getResources().getColor(R.color.colorText));

                    textWomen.setBackgroundColor(getResources().getColor(R.color.bgForgot));
                    textBedding.setBackgroundColor(getResources().getColor(R.color.bgForgot));
                    textHousehold.setBackgroundColor(getResources().getColor(R.color.bgForgot));
                } else if (position == 1) {
                    textWomen.setBackground(getDrawable(R.drawable.background_text_view));
                    textWomen.setTextColor(getResources().getColor(R.color.bgForgot));

                    textMen.setTextColor(getResources().getColor(R.color.colorText));
                    textBedding.setTextColor(getResources().getColor(R.color.colorText));
                    textHousehold.setTextColor(getResources().getColor(R.color.colorText));

                    textMen.setBackgroundColor(getResources().getColor(R.color.bgForgot));
                    textBedding.setBackgroundColor(getResources().getColor(R.color.bgForgot));
                    textHousehold.setBackgroundColor(getResources().getColor(R.color.bgForgot));
                } else if (position == 2) {
                    textBedding.setBackground(getDrawable(R.drawable.background_text_view));
                    textBedding.setTextColor(getResources().getColor(R.color.bgForgot));

                    textMen.setTextColor(getResources().getColor(R.color.colorText));
                    textWomen.setTextColor(getResources().getColor(R.color.colorText));
                    textHousehold.setTextColor(getResources().getColor(R.color.colorText));

                    textMen.setBackgroundColor(getResources().getColor(R.color.bgForgot));
                    textWomen.setBackgroundColor(getResources().getColor(R.color.bgForgot));
                    textHousehold.setBackgroundColor(getResources().getColor(R.color.bgForgot));
                }else if (position == 3) {
                    textHousehold.setBackground(getDrawable(R.drawable.background_text_view));
                    textHousehold.setTextColor(getResources().getColor(R.color.colorWhite));

                    textMen.setTextColor(getResources().getColor(R.color.colorText));
                    textWomen.setTextColor(getResources().getColor(R.color.colorText));
                    textBedding.setTextColor(getResources().getColor(R.color.colorText));

                    textMen.setBackgroundColor(getResources().getColor(R.color.bgForgot));
                    textWomen.setBackgroundColor(getResources().getColor(R.color.bgForgot));
                    textBedding.setBackgroundColor(getResources().getColor(R.color.bgForgot));
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        TextView mBasketDone = findViewById(R.id.textDoneBasket);
        mBasketDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WashFoldActivity.this, BasketActivity.class));
                Bungee.slideLeft(WashFoldActivity.this);
            }
        });


    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Bungee.fade(WashFoldActivity.this);
    }
}
