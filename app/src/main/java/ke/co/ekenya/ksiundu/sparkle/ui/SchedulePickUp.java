package ke.co.ekenya.ksiundu.sparkle.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import ke.co.ekenya.ksiundu.sparkle.R;
import spencerstudios.com.bungeelib.Bungee;

public class SchedulePickUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_pick_up);

        ImageView scheduleBack = findViewById(R.id.schedulePickUpBack);
        scheduleBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SchedulePickUp.this, BasketActivity.class));
                Bungee.fade(SchedulePickUp.this);
            }
        });

        Button btnContinue = findViewById(R.id.btnContinueDateTime);
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SchedulePickUp.this, ScheduleDateTime.class));
                Bungee.slideLeft(SchedulePickUp.this);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Bungee.fade(SchedulePickUp.this);
    }
}
