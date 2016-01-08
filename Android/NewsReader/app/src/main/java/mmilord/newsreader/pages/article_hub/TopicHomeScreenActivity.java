package mmilord.newsreader.pages.article_hub;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.Bind;
import butterknife.ButterKnife;
import mmilord.newsreader.R;
import mmilord.newsreader.common.interfaces.ButtonClicked;
import mmilord.newsreader.models.Article;

public class TopicHomeScreenActivity extends AppCompatActivity implements ButtonClicked<Article> {
    
    @Bind(R.id.pager_genre)
    protected ViewPager genrePagerView;

    private TopicFragment _topicFragment;
    private TopicPagerAdapter _topicPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.topic_homescreen_activity);
        ButterKnife.bind(this);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

      /*  _topicPagerAdapter = new TopicPagerAdapter(getSupportFragmentManager());
        genrePagerView.setAdapter(_topicPagerAdapter);
        genrePagerView.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) { }
        });
*/
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        _topicFragment = new TopicFragment();
        fragmentTransaction.add(R.id.frame_container, _topicFragment).commit();
    }

    @Override
    public void onBackPressed() {
        if (genrePagerView.getCurrentItem() == 0)
            super.onBackPressed();
        else
            genrePagerView.setCurrentItem(genrePagerView.getCurrentItem() - 1);
    }

    public void switchContent(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.pager_genre, fragment).commit();

    }

    @Override
    public void onClick(Article object) {
        _topicFragment.onClick(object);
    }
}
