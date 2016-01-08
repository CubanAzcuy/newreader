package mmilord.newsreader.pages.article_hub;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import mmilord.newsreader.pages.SmartFragmentStatePagerAdapter;

/**
 * Created by milord on 06-Jan-16.
 */
public class TopicPagerAdapter extends SmartFragmentStatePagerAdapter {

    private static final int NUM_PAGES = 5;

    public TopicPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {

        return TopicFragment.newInstance(position, "NEWS");
    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }
}
