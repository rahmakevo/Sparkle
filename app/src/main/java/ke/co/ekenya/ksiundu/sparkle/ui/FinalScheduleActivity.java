package ke.co.ekenya.ksiundu.sparkle.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import ke.co.ekenya.ksiundu.sparkle.R;
import spencerstudios.com.bungeelib.Bungee;

public class FinalScheduleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_schedule);

        ImageView finalBack = findViewById(R.id.finalScheduleBack);
        finalBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FinalScheduleActivity.this, SchedulePayment.class));
                Bungee.fade(FinalScheduleActivity.this);
            }
        });

        Button btnFinal = findViewById(R.id.order_status);
        btnFinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FinalScheduleActivity.this, OrderDetailActivity.class));
                Bungee.slideLeft(FinalScheduleActivity.this);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Bungee.fade(FinalScheduleActivity.this);
    }
}
