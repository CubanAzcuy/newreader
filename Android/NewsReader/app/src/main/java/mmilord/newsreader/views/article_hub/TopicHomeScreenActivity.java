package mmilord.newsreader.views.article_hub;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import mmilord.newsreader.R;
import mmilord.newsreader.views.common.interfaces.ButtonClicked;
import mmilord.newsreader.views.common.ui.BaseFragmentAdapter;
import mmilord.newsreader.views.common.ui.animations.ZoomOutPageTransformer;
import mmilord.newsreader.viewmodel.ArticleViewModel;
import mmilord.newsreader.viewmodel.TopicViewModel;
import mmilord.newsreader.views.article_hub.factory.TopicFragmentFactroy;

public class TopicHomeScreenActivity extends AppCompatActivity implements ButtonClicked<ArticleViewModel> {
    
    @Bind(R.id.pager_genre)
    protected ViewPager _topicViewPager;

    private BaseFragmentAdapter<TopicViewModel> _topicPagerAdapter;
    private TopicFragmentFactroy _topicBaseFragmentFactory = new TopicFragmentFactroy();
    ArrayList<TopicViewModel> _topicViewModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.topic_homescreen_activity);
        ButterKnife.bind(this);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        _topicViewModels.add(new TopicViewModel("News"));
        _topicViewModels.add(new TopicViewModel("News"));
        _topicViewModels.add(new TopicViewModel("News"));

        _topicPagerAdapter = new BaseFragmentAdapter(getSupportFragmentManager(), _topicBaseFragmentFactory);
        _topicPagerAdapter.setCollection(_topicViewModels);
        _topicViewPager.setAdapter(_topicPagerAdapter);
        _topicViewPager.setPageTransformer(true, new ZoomOutPageTransformer());
        _topicPagerAdapter.notifyDataSetChanged();
    }


    @Override
    public void onClick(ArticleViewModel object) {

        if(_topicPagerAdapter.getRegisteredFragment(_topicViewPager.getCurrentItem()) instanceof TopicFragment) {
            TopicFragment currentFragment = (TopicFragment) _topicPagerAdapter.getRegisteredFragment(_topicViewPager.getCurrentItem());
            currentFragment.onClick(object);
        }
    }
}
