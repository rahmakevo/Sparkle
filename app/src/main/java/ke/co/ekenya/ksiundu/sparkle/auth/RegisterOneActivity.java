package ke.co.ekenya.ksiundu.sparkle.auth;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import ke.co.ekenya.ksiundu.sparkle.R;
import spencerstudios.com.bungeelib.Bungee;

public class RegisterOneActivity extends AppCompatActivity {
    ProgressDialog mRegOneDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_one);

        mRegOneDialog = new ProgressDialog(this);

        final EditText mFirstName = findViewById(R.id.editTextFirstName);
        final EditText mLastName = findViewById(R.id.editTextLastName);
        final EditText mSurName = findViewById(R.id.editTextSurName);
        final EditText mNumber = findViewById(R.id.editTextRegNumber);

        ImageView backButton = findViewById(R.id.registerOneBack);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterOneActivity.this, LoginActivity.class));
                Bungee.fade(RegisterOneActivity.this);
            }
        });

        Button btnNext = findViewById(R.id.btnRegisterNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String first_name = mFirstName.getText().toString().trim();
                String last_name = mLastName.getText().toString().trim();
                String surname = mSurName.getText().toString().trim();
                String phone_number = mNumber.getText().toString().trim();

                if (!TextUtils.isEmpty(first_name) && !TextUtils.isEmpty(last_name) && !TextUtils.isEmpty(surname) && !TextUtils.isEmpty(phone_number)) {
                    Intent mRegIntent = new Intent(RegisterOneActivity.this, RegisterTwoActivity.class);
                    mRegIntent.putExtra("first_name", first_name);
                    mRegIntent.putExtra("last_name", last_name);
                    mRegIntent.putExtra("surname", surname);
                    mRegIntent.putExtra("phone_number", phone_number);
                    startActivity(mRegIntent);
                    Bungee.slideLeft(RegisterOneActivity.this);
                } else {
                    Toast.makeText(RegisterOneActivity.this, "Please ensure you have entered all your contact details", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Bungee.fade(RegisterOneActivity.this);
    }
}
