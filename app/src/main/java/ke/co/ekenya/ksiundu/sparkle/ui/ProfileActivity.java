package ke.co.ekenya.ksiundu.sparkle.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import ke.co.ekenya.ksiundu.sparkle.R;
import ke.co.ekenya.ksiundu.sparkle.auth.LoginActivity;
import spencerstudios.com.bungeelib.Bungee;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ImageView backImage = findViewById(R.id.imageViewProfileBack);
        backImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileActivity.this, HomeActivity.class));
                Bungee.fade(ProfileActivity.this);
            }
        });

        ImageView logoutImage = findViewById(R.id.imageLogout);
        logoutImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileActivity.this, LoginActivity.class));
                Bungee.fade(ProfileActivity.this);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Bungee.fade(ProfileActivity.this);
    }

    @Override
    protected void onStart() {
        super.onStart();

        final TextView mProfileName = findViewById(R.id.textProfileName);
        final TextView mProfileNumber = findViewById(R.id.textProfileNumber);
        final TextView mProfileEmail = findViewById(R.id.textProfileEmail);

        FirebaseDatabase mUsersDb = FirebaseDatabase.getInstance();
        DatabaseReference mUserRef = mUsersDb.getReference();

        FirebaseUser mUser = FirebaseAuth.getInstance().getCurrentUser();
        String mUid = mUser.getUid();

        mUserRef.child("users").child(mUid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot != null) {
                    String first_name = dataSnapshot.child("first_name").getValue().toString().trim();
                    String last_name = dataSnapshot.child("last_name").getValue().toString().trim();

                    String full_name = first_name + " " + last_name;

                    String email = dataSnapshot.child("email").getValue().toString().trim();
                    String phone_number = dataSnapshot.child("phone_number").getValue().toString().trim();

                    mProfileName.setText(full_name);
                    mProfileNumber.setText(phone_number);
                    mProfileEmail.setText(email);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
