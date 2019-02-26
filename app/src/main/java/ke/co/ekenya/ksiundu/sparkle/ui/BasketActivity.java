package ke.co.ekenya.ksiundu.sparkle.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import ke.co.ekenya.ksiundu.sparkle.R;
import spencerstudios.com.bungeelib.Bungee;

public class BasketActivity extends AppCompatActivity {
    int imageBasketMen = 0;
    int relativeWashFold = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket);

        ImageView basketBack = findViewById(R.id.basketBack);
        basketBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BasketActivity.this, WashFoldActivity.class));
                Bungee.fade(BasketActivity.this);
            }
        });

        final RelativeLayout mWashFoldLayout = findViewById(R.id.relativeLayoutBasketMen);
        final ImageView imageViewMenWashFold = findViewById(R.id.imageViewBasketMen);
        if (imageBasketMen == 0) {
            imageViewMenWashFold.setImageResource(R.drawable.ic_plus_circle_outline);
        }
        imageViewMenWashFold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageBasketMen = 1;
                if (relativeWashFold == 0) {
                    mWashFoldLayout.setVisibility(View.VISIBLE);
                    relativeWashFold = 1;
                } else if (relativeWashFold == 1) {
                    mWashFoldLayout.setVisibility(View.GONE);
                    relativeWashFold = 0;
                }

                if (imageBasketMen == 1) {
                    imageViewMenWashFold.setImageResource(R.drawable.ic_plus_circle_outline);
                    imageBasketMen = 0;
                }
            }
        });

        Button btnSchedule = findViewById(R.id.btnSchedulePickUp);
        btnSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BasketActivity.this, SchedulePickUp.class));
                Bungee.slideLeft(BasketActivity.this);
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Bungee.fade(BasketActivity.this);
    }
}
