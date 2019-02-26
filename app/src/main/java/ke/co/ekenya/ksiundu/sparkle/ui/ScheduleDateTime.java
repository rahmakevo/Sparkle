package ke.co.ekenya.ksiundu.sparkle.ui;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TimePicker;
import android.widget.Toast;

import ke.co.ekenya.ksiundu.sparkle.R;
import spencerstudios.com.bungeelib.Bungee;

public class ScheduleDateTime extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_date_time);

        ImageView btnBack = findViewById(R.id.scheduleDateTimeBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ScheduleDateTime.this, SchedulePickUp.class));
                Bungee.fade(ScheduleDateTime.this);
            }
        });

        final DatePicker pickUpDate = findViewById(R.id.pick_up_date);
        Button btnGetPickDate = findViewById(R.id.btnGetPickUpDate);
        btnGetPickDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder builder = new StringBuilder();
                builder.append("Pick Up Date : ");
                builder.append((pickUpDate.getDayOfMonth()+"/"));
                builder.append((pickUpDate.getMonth() + 1) + "/");
                builder.append((pickUpDate.getYear()));
                Toast.makeText(ScheduleDateTime.this, builder.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        final TimePicker pickUpTime = findViewById(R.id.pickup_time);
        Button btnGetPickTime = findViewById(R.id.btnGetPickUpTime);
        btnGetPickTime.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                StringBuilder builder = new StringBuilder();
                builder.append("Pick Up Time is ");
                builder.append(pickUpTime.getCurrentHour()+" : ");
                builder.append(pickUpTime.getCurrentMinute());
                Toast.makeText(ScheduleDateTime.this, builder.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        final DatePicker deliveryDate = findViewById(R.id.deliveryDatePicker);
        Button btnGetDeliveryDate = findViewById(R.id.btnGetDeliveryDate);
        btnGetDeliveryDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder builder = new StringBuilder();
                builder.append("Delivery Date : ");
                builder.append(deliveryDate.getDayOfMonth()+"/");
                builder.append((deliveryDate.getMonth() + 1)+ "/");
                builder.append(deliveryDate.getYear()+"/");
                Toast.makeText(ScheduleDateTime.this, builder.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        final TimePicker deliveryTime = findViewById(R.id.deliveryTimePicker);
        Button btnGetDeliveryTime = findViewById(R.id.btnGetDeliveryTime);
        btnGetDeliveryTime.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                StringBuilder builder = new StringBuilder();
                builder.append("Delivery Time is ");
                builder.append(deliveryTime.getCurrentHour()+" : ");
                builder.append(deliveryTime.getCurrentMinute());
                Toast.makeText(ScheduleDateTime.this, builder.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        Button btnDateTime = findViewById(R.id.btnContinuePayment);
        btnDateTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ScheduleDateTime.this, SchedulePayment.class));
                Bungee.slideLeft(ScheduleDateTime.this);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Bungee.fade(ScheduleDateTime.this);
    }
}
