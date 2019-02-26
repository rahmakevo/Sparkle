package ke.co.ekenya.ksiundu.sparkle.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import de.hdodenhof.circleimageview.CircleImageView;
import ke.co.ekenya.ksiundu.sparkle.R;
import spencerstudios.com.bungeelib.Bungee;

public class LoadWalletActivity extends AppCompatActivity {
    int imageStatus = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_wallet);

        ImageView walletBack = findViewById(R.id.loadWalletBack);
        walletBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoadWalletActivity.this, SchedulePayment.class));
                Bungee.fade(LoadWalletActivity.this);
            }
        });

        CircleImageView imageSafaricom = findViewById(R.id.imageViewSafaricom);
        CircleImageView imageTelecom = findViewById(R.id.imageViewTelecom);
        CircleImageView imageAirtel = findViewById(R.id.imageViewAirtel);

        imageTelecom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageStatus = 1;
            }
        });

        imageAirtel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageStatus = 2;
            }
        });

        if (imageStatus == 0) {
            imageSafaricom.setBackground(getDrawable(R.drawable.circle_image_view));
            imageTelecom.setBackground(getDrawable(R.drawable.circle_image_four));
            imageAirtel.setBackground(getDrawable(R.drawable.circle_image_four));
        } else if (imageStatus == 1) {
            imageSafaricom.setBackground(getDrawable(R.drawable.circle_image_four));
            imageTelecom.setBackground(getDrawable(R.drawable.circle_image_view));
            imageAirtel.setBackground(getDrawable(R.drawable.circle_image_four));
        } else if (imageStatus == 2) {
            imageSafaricom.setBackground(getDrawable(R.drawable.circle_image_four));
            imageTelecom.setBackground(getDrawable(R.drawable.circle_image_four));
            imageAirtel.setBackground(getDrawable(R.drawable.circle_image_view));
        }

        Button btnLoad = findViewById(R.id.buttonLoadAmount);
        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoadWalletActivity.this, LoadWalletTwoActivity.class));
                Bungee.slideLeft(LoadWalletActivity.this);
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Bungee.fade(LoadWalletActivity.this);
    }
}
