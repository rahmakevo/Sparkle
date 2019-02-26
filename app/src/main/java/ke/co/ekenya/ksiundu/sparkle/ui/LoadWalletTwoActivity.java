package ke.co.ekenya.ksiundu.sparkle.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import ke.co.ekenya.ksiundu.sparkle.R;
import spencerstudios.com.bungeelib.Bungee;

public class LoadWalletTwoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_wallet_two);

        ImageView walletBack = findViewById(R.id.walletTwoBack);
        walletBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoadWalletTwoActivity.this, LoadWalletActivity.class));
                Bungee.fade(LoadWalletTwoActivity.this);
            }
        });

        Button btnLoad = findViewById(R.id.btnLoadNumber);
        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoadWalletTwoActivity.this, FinalScheduleActivity.class));
                Bungee.slideLeft(LoadWalletTwoActivity.this);
                finish();
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Bungee.fade(LoadWalletTwoActivity.this);
    }
}
