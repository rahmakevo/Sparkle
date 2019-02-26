package ke.co.ekenya.ksiundu.sparkle.helper;

import android.content.Context;
import android.content.SharedPreferences;

public class CustomPref {

    Context context;

    public CustomPref(Context context) {
        this.context = context;
    }

    public void saveBeddingsCount(int mKingCount, int mSingleSheet, int mDoubleCount, int mCaseCount, int mPillowCount, int mDuvet) {
        SharedPreferences mBeddingsPref = context.getSharedPreferences("beddingsPref", Context.MODE_PRIVATE);
        SharedPreferences.Editor mBeddingsEditor = mBeddingsPref.edit();
        mBeddingsEditor.putInt("king", mKingCount);
        mBeddingsEditor.putInt("single", mSingleSheet);
        mBeddingsEditor.putInt("doubleCount", mDoubleCount);
        mBeddingsEditor.putInt("case", mCaseCount);
        mBeddingsEditor.putInt("pillow", mPillowCount);
        mBeddingsEditor.putInt("duvet", mDuvet);
        mBeddingsEditor.commit();
    }


    public void saveMensCount(int countTShirt, int countShirt, int countTrouser, int countJeans, int countJacket, int countBlazer) {
        SharedPreferences mMensPref = context.getSharedPreferences("mensPref", Context.MODE_PRIVATE);
        SharedPreferences.Editor mMensEditor = mMensPref.edit();
    }
}
