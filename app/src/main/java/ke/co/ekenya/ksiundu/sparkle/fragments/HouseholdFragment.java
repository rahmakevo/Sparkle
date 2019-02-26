package ke.co.ekenya.ksiundu.sparkle.fragments;


import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import ke.co.ekenya.ksiundu.sparkle.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HouseholdFragment extends Fragment {
    View mRootView;
    int handTowel = 0;
    int bathTowel = 0;
    int bathMat = 0;
    int apron = 0;
    int carpetOne = 0;
    int carpetTwo = 0;
    public HouseholdFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mRootView = inflater.inflate(R.layout.fragment_household, container, false);
        //Image HandTowel
        ImageView imageHandTowel = mRootView.findViewById(R.id.circleImagePlusBeddingKingSheet);
        imageHandTowel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handTowel = handTowel + 1;
                displayHandTowel(handTowel);
            }
        });
        ImageView imageHandTowelMinus = mRootView.findViewById(R.id.circleImageMinusMen);
        imageHandTowelMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handTowel = handTowel - 1;
                displayHandTowel(handTowel);
            }
        });
        //Image BathTowel
        ImageView imageBathPlus = mRootView.findViewById(R.id.circleImagePlusMenShirt);
        imageBathPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bathTowel = bathTowel + 1;
                displayBathTowel(bathTowel);
            }
        });
        ImageView imageBathMinus = mRootView.findViewById(R.id.circleImageMinusMenShirt);
        imageBathMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bathTowel = bathTowel - 1;
                displayBathTowel(bathTowel);
            }
        });
        //Image BathMat
        ImageView imageMatPlus = mRootView.findViewById(R.id.circleImagePlusMenTrouser);
        imageMatPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bathMat = bathMat + 1;
                displayMat(bathMat);
            }
        });
        ImageView imageMatMinus = mRootView.findViewById(R.id.circleImageMinusMenTrouser);
        imageMatMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bathMat = bathMat - 1;
                displayMat(bathMat);
            }
        });
        //Image Apron
        ImageView imageApronPlus = mRootView.findViewById(R.id.circleImagePlusMenJeans);
        imageApronPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                apron = apron + 1;
                displayApron(apron);
            }
        });
        ImageView imageApronMinus = mRootView.findViewById(R.id.circleImageMinusMenJeans);
        imageApronMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                apron = apron - 1;
                displayApron(apron);
            }
        });
        //Image Small Carpet
        ImageView imageCarpetOnePlus = mRootView.findViewById(R.id.circleImagePlusMenBlazer);
        imageCarpetOnePlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                carpetOne = carpetOne + 1;
                displayCarpetOne(carpetOne);
            }
        });
        ImageView imageCarpetOneMinus = mRootView.findViewById(R.id.circleImageMinusMenBlazer);
        imageCarpetOneMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                carpetOne = carpetOne - 1;
                displayCarpetOne(carpetOne);
            }
        });
        //Image Large Carpet
        ImageView imageCarpetTwoPlus = mRootView.findViewById(R.id.circleImagePlusMenJacket);
        imageCarpetTwoPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                carpetTwo = carpetTwo + 1;
                displayCarpetTwo(carpetTwo);
            }
        });
        ImageView imageCarpetTwoMinus = mRootView.findViewById(R.id.circleImageMinusMenJacket);
        imageCarpetTwoMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                carpetTwo = carpetTwo - 1;
                displayCarpetTwo(carpetTwo);
            }
        });
        return mRootView;
    }

    private void displayCarpetTwo(int carpetTwo) {
        final TextView textCarpetTwoCount = mRootView.findViewById(R.id.textNumberMenJacket);
        textCarpetTwoCount.setText("" + carpetTwo);
    }

    private void displayCarpetOne(int carpetOne) {
        final TextView textCarpetOneCount = mRootView.findViewById(R.id.textNumberMenBlazer);
        textCarpetOneCount.setText("" + carpetOne);
    }

    private void displayApron(int apron) {
        final TextView textApronCount = mRootView.findViewById(R.id.textNumberMenJeans);
        textApronCount.setText("" + apron);
    }

    private void displayMat(int bathMat) {
        final TextView textMatCount = mRootView.findViewById(R.id.textNumberMenTrouser);
        textMatCount.setText("" + bathMat);
    }

    private void displayBathTowel(int bathTowel) {
        final TextView textBathCount = mRootView.findViewById(R.id.textNumberMenShirt);
        textBathCount.setText("" + bathTowel);
    }

    private void displayHandTowel(int handTowel) {
        final TextView textHandCount = mRootView.findViewById(R.id.textNumberBeddingKingSheet);
        textHandCount.setText("" + handTowel);
    }

}
