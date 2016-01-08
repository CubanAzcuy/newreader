package mmilord.newsreader.pages.article_hub;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import mmilord.newsreader.R;
import mmilord.newsreader.common.ui.BaseRecyclerViewAdapter;
import mmilord.newsreader.models.Article;
import mmilord.newsreader.models.Topic;
import mmilord.newsreader.pages.article_hub.factory.ArticleCardViewHolderFactory;

/**
 * Created by milord on 06-Jan-16.
 */
public class TopicFragment extends Fragment{

    @Bind(R.id.text_genre_header)
    TextView _textHeader;

    @Bind(R.id.recycler_articles)
    RecyclerView _articleFeed;

    private int _pageNumber;
    private Topic _topic;

    private BaseRecyclerViewAdapter<Article> _articleFeedAdapter;
    private ArticleCardViewHolderFactory _articleCardViewHolderFactory = new ArticleCardViewHolderFactory();
    private ArrayList<Article> _elements = new ArrayList<>();

    public static TopicFragment newInstance(int pageNumber, Topic topic) {
        TopicFragment fragment = new TopicFragment();
        fragment.setTopic(topic);
        fragment.setPageNumber(pageNumber);

        return fragment;
    }

    public TopicFragment() { }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_genre, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle bundle){

        _textHeader.setText(_topic.getTitle());

        Article article;
        for (int i = 0; i < 10; i++) {
            article = new Article("Open article " + i);
            _elements.add(i, article);
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);

        _articleFeed.setLayoutManager(layoutManager);
        _articleFeedAdapter = new BaseRecyclerViewAdapter<Article>(_articleCardViewHolderFactory);
        _articleFeedAdapter.setCollection(_elements);
        _articleFeed.setAdapter(_articleFeedAdapter);
    }

    public int getPageNumber() {
        return _pageNumber;
    }

    public void setTopic(Topic topic) {
        _topic = topic;
    }

    public void setPageNumber(int pageNumber) {
        _pageNumber = pageNumber;
    }

    public void onClick(Article object) {
        int index = _elements.indexOf(object);
        _elements.remove(object);
        _articleFeedAdapter.setCollection(_elements);
        _articleFeedAdapter.notifyItemRemoved(index);
        _articleFeedAdapter.notifyItemRangeChanged(index, _elements.size());
    }


}
