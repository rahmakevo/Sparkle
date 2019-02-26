package ke.co.ekenya.ksiundu.sparkle.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import ke.co.ekenya.ksiundu.sparkle.fragments.InquiryFragment;
import ke.co.ekenya.ksiundu.sparkle.fragments.TransactionsFragment;

public class WalletAdapter extends FragmentPagerAdapter {
    public WalletAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new TransactionsFragment();
            case 1:
                return new InquiryFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
