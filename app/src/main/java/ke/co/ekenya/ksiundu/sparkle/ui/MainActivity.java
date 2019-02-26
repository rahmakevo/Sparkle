package ke.co.ekenya.ksiundu.sparkle.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ViewListener;

import ke.co.ekenya.ksiundu.sparkle.R;
import ke.co.ekenya.ksiundu.sparkle.auth.LoginActivity;
import spencerstudios.com.bungeelib.Bungee;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // main carousel
        CarouselView mMainView = findViewById(R.id.carouselView);
        mMainView.setPageCount(4);
        mMainView.setViewListener(new ViewListener() {
            @Override
            public View setViewForPosition(int position) {
                View mRootView = null;
                if (position == 0) {
                    mRootView = getLayoutInflater().inflate(R.layout.first_carousel, null);
                    Button btnStart = mRootView.findViewById(R.id.btnStart);
                    btnStart.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            
                        }
                    });
                } else if (position == 1) {
                    mRootView = getLayoutInflater().inflate(R.layout.second_carousel, null);
                } else if (position == 2) {
                    mRootView = getLayoutInflater().inflate(R.layout.third_carousel, null);
                } else if (position == 3) {
                    mRootView = getLayoutInflater().inflate(R.layout.fourth_carousel, null);
                    Button btnOrder = mRootView.findViewById(R.id.btnOrderNow);
                    btnOrder.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            startActivity(new Intent(MainActivity.this, LoginActivity.class));
                            Bungee.slideLeft(MainActivity.this);
                        }
                    });
                }
                return mRootView;
            }
        });

    }
}
