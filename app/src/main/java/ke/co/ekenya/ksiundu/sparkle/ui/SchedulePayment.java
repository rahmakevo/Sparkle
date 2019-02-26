package ke.co.ekenya.ksiundu.sparkle.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;

import ke.co.ekenya.ksiundu.sparkle.R;
import spencerstudios.com.bungeelib.Bungee;

public class SchedulePayment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_payment);

        ImageView paymentBack = findViewById(R.id.paymentBack);
        paymentBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SchedulePayment.this, ScheduleDateTime.class));
                Bungee.fade(SchedulePayment.this);
            }
        });

        Button btnPayment = findViewById(R.id.btnContinuePayment);
        btnPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SchedulePayment.this, LoadWalletActivity.class));
                Bungee.slideLeft(SchedulePayment.this);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Bungee.fade(SchedulePayment.this);
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.radioButtonWallet:
                if (checked)
                    break;
            case R.id.radioButtonVisa:
                if (checked)
                    break;
            case R.id.radioButtonCash:
                if (checked)
                    break;
        }
    }
}
