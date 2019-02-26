package ke.co.ekenya.ksiundu.sparkle.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import ke.co.ekenya.ksiundu.sparkle.R;
import spencerstudios.com.bungeelib.Bungee;

public class Refer_Earn_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refer__earn_);

        ImageView referBack = findViewById(R.id.referEarnBack);
        referBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Refer_Earn_Activity.this, HomeActivity.class));
                Bungee.fade(Refer_Earn_Activity.this);
            }
        });

        final String shareCode = String.valueOf(R.string.refer_code);
        ImageView referEarn = findViewById(R.id.imageViewRefer);
        referEarn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/code");
                shareIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "My Sparkle Code");
                shareIntent.putExtra(Intent.EXTRA_TEXT, shareCode);
                startActivity(Intent.createChooser(shareIntent, "Share Sparkle Code"));
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Bungee.fade(Refer_Earn_Activity.this);
    }
}
