package ke.co.ekenya.ksiundu.sparkle.auth;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import ke.co.ekenya.ksiundu.sparkle.R;
import ke.co.ekenya.ksiundu.sparkle.ui.HomeActivity;
import spencerstudios.com.bungeelib.Bungee;

public class LoginActivity extends AppCompatActivity {
    private ProgressDialog mLoginDialog;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mLoginDialog = new ProgressDialog(this);
        mAuth = FirebaseAuth.getInstance();
        // forgot password
        TextView textForgot = findViewById(R.id.textForgot);
        textForgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, ForgotPasswordActivity.class));
                Bungee.slideLeft(LoginActivity.this);
            }
        });

        final EditText mLoginEmail = findViewById(R.id.editTextLoginEmail);
        final EditText mLoginPass = findViewById(R.id.editTextLoginPass);

        // sign in
        Button btnSingIn = findViewById(R.id.btnSignIn);
        btnSingIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mLoginEmail.getText().toString().trim();
                String password = mLoginPass.getText().toString().trim();

                if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)) {
                    mLoginDialog.setTitle("Authenticating Client");
                    mLoginDialog.setMessage("Please wait while we verify your client credentials");
                    mLoginDialog.setCanceledOnTouchOutside(false);
                    mLoginDialog.show();

                    verify_user(email, password);
                }
            }
        });

        // registration
        final TextView textRegister = findViewById(R.id.textRegister);
        textRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterOneActivity.class));
                Bungee.slideLeft(LoginActivity.this);
            }
        });
    }

    private void verify_user(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            mLoginDialog.dismiss();
                            startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                            Bungee.slideLeft(LoginActivity.this);
                        }
                    }
                });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Bungee.fade(LoginActivity.this);
    }
}
