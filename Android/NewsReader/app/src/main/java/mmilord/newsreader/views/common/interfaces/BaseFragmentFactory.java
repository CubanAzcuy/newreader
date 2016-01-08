package mmilord.newsreader.views.common.interfaces;

import android.support.v4.app.Fragment;

/**
 * Created by robertgross on 1/8/16.
 */

public interface BaseFragmentFactory<T> {
    public Fragment generateFragment(int position, T t);

}