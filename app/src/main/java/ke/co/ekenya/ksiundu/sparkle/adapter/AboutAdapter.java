package ke.co.ekenya.ksiundu.sparkle.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import ke.co.ekenya.ksiundu.sparkle.fragments.AboutFragment;
import ke.co.ekenya.ksiundu.sparkle.fragments.ReviewsFragment;
import ke.co.ekenya.ksiundu.sparkle.fragments.ServiceFragment;

public class AboutAdapter extends FragmentPagerAdapter {
    public AboutAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new ServiceFragment();
            case 1:
                return new AboutFragment();
            case 2:
                return new ReviewsFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
