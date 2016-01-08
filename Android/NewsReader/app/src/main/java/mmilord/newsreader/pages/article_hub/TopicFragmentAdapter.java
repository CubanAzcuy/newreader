package mmilord.newsreader.pages.article_hub;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.SparseArray;
import android.view.ViewGroup;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

import mmilord.newsreader.common.ui.SmartFragmentStatePagerAdapter;
import mmilord.newsreader.models.Topic;

/**
 * Created by milord on 01-Jan-16.
 */
public class TopicFragmentAdapter extends SmartFragmentStatePagerAdapter {

    private ArrayList<Topic> _topics;

    public TopicFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    public void setCollection(ArrayList<Topic> topics) {
        _topics = topics;
    }

    // Returns total number of pages
    @Override
    public int getCount() {
        if(_topics == null)
            return 0;
        else
            return _topics.size();
    }

    // Returns the fragment to display for that page
    @Override
    public Fragment getItem(int position) {
        return TopicFragment.newInstance(position, _topics.get(position));
    }

    // Returns the page title for the top indicator
    @Override
    public CharSequence getPageTitle(int position) {
        return "Page " + position;
    }

}
