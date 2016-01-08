package mmilord.newsreader.pages.article_hub.factory;

import android.support.v4.app.Fragment;

import mmilord.newsreader.common.interfaces.BaseFragmentFactory;
import mmilord.newsreader.models.Topic;
import mmilord.newsreader.pages.article_hub.TopicFragment;

/**
 * Created by robertgross on 1/8/16.
 */
public class TopicFragmentFactroy implements BaseFragmentFactory<Topic> {

    @Override
    public Fragment generateFragment(int position, Topic topic) {
        return TopicFragment.newInstance(position, topic);
    }
}
