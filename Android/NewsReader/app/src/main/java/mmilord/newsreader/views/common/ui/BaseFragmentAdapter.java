package mmilord.newsreader.views.common.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import java.util.List;

import mmilord.newsreader.views.common.interfaces.BaseFragmentFactory;

/**
 * Created by robertgross on 1/8/16.
 */
public class BaseFragmentAdapter<T> extends SmartFragmentStatePagerAdapter {

    protected List<T> _items;
    protected BaseFragmentFactory _factory;

    public BaseFragmentAdapter(FragmentManager fm, BaseFragmentFactory factory) {
        super(fm);
        _factory = factory;
    }

    public void setCollection(List<T> items) {
        _items = items;
    }

    // Returns total number of pages
    @Override
    public int getCount() {
        if(_items == null)
            return 0;
        else
            return _items.size();
    }

    // Returns the fragment to display for that page
    @Override
    public Fragment getItem(int position) {
        return _factory.generateFragment(position, _items.get(position));
    }

    // Returns the page title for the top indicator
    @Override
    public CharSequence getPageTitle(int position) {
        return "Page " + position;
    }

}
