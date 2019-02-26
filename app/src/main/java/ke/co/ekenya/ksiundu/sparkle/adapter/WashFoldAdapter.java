package ke.co.ekenya.ksiundu.sparkle.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import ke.co.ekenya.ksiundu.sparkle.fragments.BeddingFragment;
import ke.co.ekenya.ksiundu.sparkle.fragments.HouseholdFragment;
import ke.co.ekenya.ksiundu.sparkle.fragments.MensFragment;
import ke.co.ekenya.ksiundu.sparkle.fragments.WomensFragment;

public class WashFoldAdapter extends FragmentPagerAdapter {
    public WashFoldAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new MensFragment();
            case 1:
                return new WomensFragment();
            case 2:
                return new BeddingFragment();
            case 3:
                return new HouseholdFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        super.getPageTitle(position);
        switch (position) {
            case 0:
                return "Men's";
            case 1:
                return "Women's";
            case 2:
                return "Bedding's";
            case 3:
                return "Household";
        }
        return null;
    }
}
