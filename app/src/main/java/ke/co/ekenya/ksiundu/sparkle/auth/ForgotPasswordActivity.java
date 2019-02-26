package ke.co.ekenya.ksiundu.sparkle.auth;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ke.co.ekenya.ksiundu.sparkle.R;
import spencerstudios.com.bungeelib.Bungee;

public class ForgotPasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Bungee.fade(ForgotPasswordActivity.this);
    }
}
