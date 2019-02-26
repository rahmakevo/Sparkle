package ke.co.ekenya.ksiundu.sparkle.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import ke.co.ekenya.ksiundu.sparkle.R;
import spencerstudios.com.bungeelib.Bungee;

public class OrderDetailActivity extends AppCompatActivity {
    private int mWashFoldShow = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);

        final RelativeLayout mWashFoldLayout = findViewById(R.id.relativeLayoutWashFold);

        TextView mDetails = findViewById(R.id.textWashUpFoldDetails);
        mDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mWashFoldShow == 0) {
                    mWashFoldLayout.setVisibility(View.VISIBLE);
                    mWashFoldShow = 1;
                } else if (mWashFoldShow == 1) {
                    mWashFoldLayout.setVisibility(View.GONE);
                    mWashFoldShow = 0;
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Bungee.fade(OrderDetailActivity.this);
    }
}
