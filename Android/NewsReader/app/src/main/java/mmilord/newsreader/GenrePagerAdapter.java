package mmilord.newsreader;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

/**
 * Created by milord on 06-Jan-16.
 */
public class GenrePagerAdapter extends SmartFragmentStatePagerAdapter {

    private static final int NUM_PAGES = 5;

    public GenrePagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {

        return GenrePagerFragment.create(position, "NEWS");
    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }
}
