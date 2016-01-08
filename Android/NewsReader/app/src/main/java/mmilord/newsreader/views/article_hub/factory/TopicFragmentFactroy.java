package mmilord.newsreader.views.article_hub.factory;

import android.support.v4.app.Fragment;

import mmilord.newsreader.views.common.interfaces.BaseFragmentFactory;
import mmilord.newsreader.viewmodel.TopicViewModel;
import mmilord.newsreader.views.article_hub.TopicFragment;

/**
 * Created by robertgross on 1/8/16.
 */
public class TopicFragmentFactroy implements BaseFragmentFactory<TopicViewModel> {

    @Override
    public Fragment generateFragment(int position, TopicViewModel topicViewModel) {
        return TopicFragment.newInstance(position, topicViewModel);
    }
}
