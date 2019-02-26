package ke.co.ekenya.ksiundu.sparkle.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import ke.co.ekenya.ksiundu.sparkle.fragments.OngoingOrders;
import ke.co.ekenya.ksiundu.sparkle.fragments.PastOrders;

public class AllOrdersFragment extends FragmentPagerAdapter {
    public AllOrdersFragment(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new OngoingOrders();
            case 1:
                return new PastOrders();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
