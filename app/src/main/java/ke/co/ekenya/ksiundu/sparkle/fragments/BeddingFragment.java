package ke.co.ekenya.ksiundu.sparkle.fragments;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import ke.co.ekenya.ksiundu.sparkle.R;
import ke.co.ekenya.ksiundu.sparkle.helper.CustomPref;

/**
 * A simple {@link Fragment} subclass.
 */
public class BeddingFragment extends Fragment {
    View mRootView;
    int mKingCount = 0;
    int mSingleSheet = 0;
    int mDoubleCount = 0;
    int mCaseCount = 0;
    int mPillowCount = 0;
    int mDuvet = 0;
    public BeddingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mRootView = inflater.inflate(R.layout.fragment_bedding, container, false);

        //Image KingBedSheet
        ImageView mKingSheet = mRootView.findViewById(R.id.circleImagePlusBeddingKingSheet);
        mKingSheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mKingCount = mKingCount + 1;
                displayKingCount(mKingCount);
            }
        });
        ImageView mKingSheetMinus = mRootView.findViewById(R.id.circleImageMinusMen);
        mKingSheetMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mKingCount = mKingCount - 1;
                displayKingCount(mKingCount);
            }
        });
        //Image BedSheet
        ImageView mBedSheetPlus = mRootView.findViewById(R.id.circleImagePlusMenShirt);
        mBedSheetPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSingleSheet = mSingleSheet + 1;
                displaySingleSheet(mSingleSheet);
            }
        });
        ImageView mBedSheetMinus = mRootView.findViewById(R.id.circleImageMinusMenShirt);
        mBedSheetMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSingleSheet = mSingleSheet - 1;
                displaySingleSheet(mSingleSheet);
            }
        });
        //Image DoubleSheet
        ImageView mDoubleSheetPlus = mRootView.findViewById(R.id.circleImagePlusMenTrouser);
        mDoubleSheetPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDoubleCount = mDoubleCount + 1;
                displayDoubleSheet(mDoubleCount);
            }
        });
        ImageView mDoubleSheetMinus = mRootView.findViewById(R.id.circleImageMinusMenTrouser);
        mDoubleSheetMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDoubleCount = mDoubleCount - 1;
                displayDoubleSheet(mDoubleCount);
            }
        });
        //Image PillowCase
        ImageView mCasePlus = mRootView.findViewById(R.id.circleImagePlusMenJeans);
        mCasePlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCaseCount = mCaseCount + 1;
                displayCase(mCaseCount);
            }
        });
        ImageView mCaseMinus = mRootView.findViewById(R.id.circleImageMinusMenJeans);
        mCaseMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCaseCount = mCaseCount - 1;
                displayCase(mCaseCount);
            }
        });
        //Image Pillow
        ImageView mPillowPlus = mRootView.findViewById(R.id.circleImagePlusMenBlazer);
        mPillowPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPillowCount = mPillowCount + 1;
                displayPillow(mPillowCount);
            }
        });
        ImageView mPillowMinus = mRootView.findViewById(R.id.circleImageMinusMenBlazer);
        mPillowMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPillowCount = mPillowCount - 1;
                displayPillow(mPillowCount);
            }
        });
        //Image Duvet
        ImageView mDuvetImage = mRootView.findViewById(R.id.circleImagePlusMenJacket);
        mDuvetImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDuvet = mDuvet + 1;
                displayDuvet(mDuvet);
            }
        });
        ImageView mDuvetMinus = mRootView.findViewById(R.id.circleImageMinusMenJacket);
        mDuvetMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDuvet = mDuvet - 1;
                displayDuvet(mDuvet);
            }
        });
        saveBeddingsCount(mKingCount, mSingleSheet, mDoubleCount, mCaseCount, mPillowCount, mDuvet);
        return mRootView;
    }

    private void displayDuvet(int mDuvet) {
        final TextView mDuvetText = mRootView.findViewById(R.id.textNumberMenJacket);
        mDuvetText.setText("" + mDuvet);
    }

    private void displayPillow(int mPillowCount) {
        final TextView mPillowText = mRootView.findViewById(R.id.textNumberMenBlazer);
        mPillowText.setText("" + mPillowCount);
    }

    private void displayCase(int mCaseCount) {
        final TextView mCaseText = mRootView.findViewById(R.id.textNumberMenJeans);
        mCaseText.setText("" + mCaseCount);
    }

    private void displayDoubleSheet(int mDoubleCount) {
        final TextView mDoubleCountText = mRootView.findViewById(R.id.textNumberMenTrouser);
        mDoubleCountText.setText("" + mDoubleCount);
    }

    private void displaySingleSheet(int mSingleSheet) {
        final TextView mSheetCount = mRootView.findViewById(R.id.textNumberMenShirt);
        mSheetCount.setText("" + mSingleSheet);
    }

    private void displayKingCount(int mKingCount) {
        final TextView mKingCountText = mRootView.findViewById(R.id.textNumberBeddingKingSheet);
        mKingCountText.setText("" + mKingCount);
    }

    private void saveBeddingsCount(int mKingCount, int mSingleSheet, int mDoubleCount, int mCaseCount, int mPillowCount, int mDuvet) {
        new CustomPref(getActivity()).saveBeddingsCount(mKingCount, mSingleSheet, mDoubleCount, mCaseCount, mPillowCount, mDuvet);
    }
}
