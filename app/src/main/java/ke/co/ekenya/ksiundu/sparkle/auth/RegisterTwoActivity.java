package ke.co.ekenya.ksiundu.sparkle.auth;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

import ke.co.ekenya.ksiundu.sparkle.R;
import ke.co.ekenya.ksiundu.sparkle.ui.HomeActivity;
import spencerstudios.com.bungeelib.Bungee;

public class RegisterTwoActivity extends AppCompatActivity {
    private ProgressDialog mRegTwoDialog;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_two);
        
        mRegTwoDialog = new ProgressDialog(this);
        mAuth = FirebaseAuth.getInstance();

        final EditText mEmail = findViewById(R.id.editTextEmailAddress);
        final EditText mPass = findViewById(R.id.editTextPassword);
        final EditText mConfirmPass = findViewById(R.id.editTextConfirmPassword);

        final String first_name = getIntent().getStringExtra("first_name");
        final String last_name = getIntent().getStringExtra("last_name");
        final String surname = getIntent().getStringExtra("surname");
        final String phone_number = getIntent().getStringExtra("phone_number");

        ImageView btnBack = findViewById(R.id.registerTwoBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterTwoActivity.this, RegisterOneActivity.class));
                Bungee.fade(RegisterTwoActivity.this);
            }
        });

        Button btnFinish = findViewById(R.id.btnFinishRegister);
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mEmail.getText().toString().trim();
                String password = mPass.getText().toString().trim();
                String confirm_pass = mConfirmPass.getText().toString().trim();

                if (confirm_pass.equals(password)) {
                    if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password) && !TextUtils.isEmpty(confirm_pass)) {
                        mRegTwoDialog.setTitle("Creating new Client!");
                        mRegTwoDialog.setMessage("Please wait while we create a client account for you at Sparkle");
                        mRegTwoDialog.setCanceledOnTouchOutside(false);
                        mRegTwoDialog.show();

                        createUser(first_name, last_name, surname, phone_number, email, password);
                    }

                }
            }
        });
    }

    private void createUser(final String first_name, final String last_name, final String surname, final String phone_number, final String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser mUserId = mAuth.getCurrentUser();
                            String mUid = mUserId.getUid();

                            FirebaseDatabase mUsersDb = FirebaseDatabase.getInstance();
                            DatabaseReference mUsersRef = mUsersDb.getReference();
                            HashMap<String, String> mUserMap = new HashMap<>();
                            mUserMap.put("first_name", first_name);
                            mUserMap.put("last_name", last_name);
                            mUserMap.put("surname", surname);
                            mUserMap.put("phone_number", phone_number);
                            mUserMap.put("email", email);
                            mUsersRef.child("users").child(mUid).setValue(mUserMap)
                                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if (task.isSuccessful()) {
                                                mRegTwoDialog.dismiss();
                                                startActivity(new Intent(RegisterTwoActivity.this, HomeActivity.class));
                                                Bungee.slideLeft(RegisterTwoActivity.this);
                                                finish();
                                            }
                                        }
                                    });
                        }
                    }
                });
    }

}
