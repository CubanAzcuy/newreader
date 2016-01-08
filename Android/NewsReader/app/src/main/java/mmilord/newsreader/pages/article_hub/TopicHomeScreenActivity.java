package mmilord.newsreader.pages.article_hub;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import mmilord.newsreader.R;
import mmilord.newsreader.common.interfaces.ButtonClicked;
import mmilord.newsreader.models.Article;
import mmilord.newsreader.models.Topic;

public class TopicHomeScreenActivity extends AppCompatActivity implements ButtonClicked<Article> {
    
    @Bind(R.id.pager_genre)
    protected ViewPager genrePagerView;

    private TopicFragment _topicFragment;
    private TopicFragmentAdapter _topicPagerAdapter;

    ArrayList<Topic> _topics = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.topic_homescreen_activity);
        ButterKnife.bind(this);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        _topics.add(new Topic("News"));
        _topics.add(new Topic("News"));
        _topics.add(new Topic("News"));

        _topicPagerAdapter = new TopicFragmentAdapter(getSupportFragmentManager());
        _topicPagerAdapter.setCollection(_topics);
        genrePagerView.setAdapter(_topicPagerAdapter);
        _topicPagerAdapter.notifyDataSetChanged();
    }


    @Override
    public void onClick(Article object) {

        if(_topicPagerAdapter.getRegisteredFragment(genrePagerView.getCurrentItem()) instanceof TopicFragment) {
            TopicFragment currentFragment = (TopicFragment) _topicPagerAdapter.getRegisteredFragment(genrePagerView.getCurrentItem());
            currentFragment.onClick(object);
        }
    }
}
