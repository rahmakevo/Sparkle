package ke.co.ekenya.ksiundu.sparkle.ui;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import ke.co.ekenya.ksiundu.sparkle.R;
import ke.co.ekenya.ksiundu.sparkle.adapter.WalletAdapter;
import spencerstudios.com.bungeelib.Bungee;

public class WalletActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet);

        TextView mTransactions = findViewById(R.id.textWalletTransactions);
        TextView mInquiry = findViewById(R.id.textWalletInquiry);

        final ViewPager mWalletPager = findViewById(R.id.viewPagerWallet);

        mTransactions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mWalletPager.setCurrentItem(0);
            }
        });

        mInquiry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mWalletPager.setCurrentItem(1);
            }
        });

        WalletAdapter mAdapter = new WalletAdapter(getSupportFragmentManager());
        mWalletPager.setOffscreenPageLimit(2);
        mWalletPager.setAdapter(mAdapter);

        mWalletPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
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

        ImageView backButton = findViewById(R.id.backButtonWallet);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WalletActivity.this, HomeActivity.class));
                Bungee.fade(WalletActivity.this);
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Bungee.fade(WalletActivity.this);
    }
}
