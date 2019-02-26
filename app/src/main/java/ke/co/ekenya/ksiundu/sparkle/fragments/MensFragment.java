package ke.co.ekenya.ksiundu.sparkle.fragments;


import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import ke.co.ekenya.ksiundu.sparkle.R;
import ke.co.ekenya.ksiundu.sparkle.helper.CustomPref;
import ke.co.ekenya.ksiundu.sparkle.ui.BasketActivity;
import spencerstudios.com.bungeelib.Bungee;

/**
 * A simple {@link Fragment} subclass.
 */
public class MensFragment extends Fragment {
    int countShirt = 0;
    int countTShirt = 0;
    int countTrouser = 0;
    int countJeans = 0;
    int countBlazer = 0;
    int countJacket = 0;
    int countTotal = 0;
    View mRootView;
    public MensFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mRootView = inflater.inflate(R.layout.fragment_mens, container, false);
        // TShirt ImageView
        ImageView imageTShirtPlus = mRootView.findViewById(R.id.circleImagePlusMen);
        imageTShirtPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countShirt = countShirt + 1;
                display(countShirt);
            }
        });
        ImageView imageTShirtMinus = mRootView.findViewById(R.id.circleImageMinusMen);
        imageTShirtMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countShirt = countShirt - 1;
                display(countShirt);
            }
        });
        // Shirt imageView
        ImageView imageShirtPlus = mRootView.findViewById(R.id.circleImagePlusMenShirt);
        imageShirtPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countTShirt = countTShirt + 1;
                displayShirt(countTShirt);
            }
        });
        ImageView imageShirtMinus = mRootView.findViewById(R.id.circleImageMinusMenShirt);
        imageShirtMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countTShirt = countTShirt - 1;
                displayShirt(countTShirt);
            }
        });
        // Trouser imageView
        ImageView imageTrouserPlus = mRootView.findViewById(R.id.circleImagePlusMenTrouser);
        imageTrouserPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countTrouser = countTrouser + 1;
                displayTrouser(countTrouser);
            }
        });
        ImageView imageTrouserMinus = mRootView.findViewById(R.id.circleImageMinusMenTrouser);
        imageTrouserMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countTrouser = countTrouser - 1;
                displayTrouser(countTrouser);
            }
        });
        //Jeans ImageView
        ImageView imageJeansPlus = mRootView.findViewById(R.id.circleImagePlusMenJeans);
        imageJeansPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countJeans = countJeans + 1;
                displayJeans(countJeans);
            }
        });
        ImageView imageJeansMinus = mRootView.findViewById(R.id.circleImageMinusMenJeans);
        imageJeansMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countJeans = countJeans - 1;
                displayJeans(countJeans);
            }
        });
        //Blazer ImageView
        ImageView imageBlazerPlus = mRootView.findViewById(R.id.circleImagePlusMenBlazer);
        imageBlazerPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countBlazer = countBlazer + 1;
                displayBlazer(countBlazer);
            }
        });
        ImageView imageBlazerMinus = mRootView.findViewById(R.id.circleImageMinusMenBlazer);
        imageBlazerMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countBlazer = countBlazer - 1;
                displayBlazer(countBlazer);
            }
        });
        //Jacket ImageView
        ImageView imageJacketPlus = mRootView.findViewById(R.id.circleImagePlusMenJacket);
        imageJacketPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countJacket = countJacket + 1;
                displayJacket(countJacket);
            }
        });
        ImageView imageJacketMinus = mRootView.findViewById(R.id.circleImageMinusMenJacket);
        imageJacketMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countJacket = countJacket - 1;
                displayJacket(countJacket);
            }
        });
        return mRootView;
    }

    private void displayJacket(int countJacket) {
        //Jacket Text
        final TextView textJacketCount = mRootView.findViewById(R.id.textNumberMenJacket);
        textJacketCount.setText("" + countJacket);
    }

    private void displayBlazer(int countBlazer) {
        //Blazer Text
        final TextView mBlazerCount = mRootView.findViewById(R.id.textNumberMenBlazer);
        mBlazerCount.setText("" + countBlazer);
    }

    private void displayJeans(int countJeans) {
        //Jeans Text
        final TextView mJeansCount = mRootView.findViewById(R.id.textNumberMenJeans);
        mJeansCount.setText("" + countJeans);
    }

    private void displayTrouser(int countTrouser) {
        //Trouser Text
        final TextView mTrouserCount = mRootView.findViewById(R.id.textNumberMenTrouser);
        mTrouserCount.setText("" + countTrouser);
    }

    private void displayShirt(int countTShirt) {
        //Shirt Text
        final TextView mShirtCount = mRootView.findViewById(R.id.textNumberMenShirt);
        mShirtCount.setText("" + countTShirt);
    }

    private void display(int count) {
        //TShirt Text
        final TextView mTShirtCount = mRootView.findViewById(R.id.textNumberMenTShirt);
        mTShirtCount.setText("" + count);
    }


}
