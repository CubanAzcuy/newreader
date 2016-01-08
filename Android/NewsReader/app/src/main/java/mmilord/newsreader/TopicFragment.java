package mmilord.newsreader;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by milord on 06-Jan-16.
 */
public class TopicFragment extends Fragment{

    @Bind(R.id.text_genre_header)
    TextView _textHeader;

    @Bind(R.id.recycler_articles)
    RecyclerView _articleFeed;

    private String _title;
    private int _pageNumber;

    private ArticleFeedAdpater _articleFeedAdapter;
    private ArrayList<Article> _elements = new ArrayList<>();

    public static TopicFragment newInstance(int pageNumber, String title) {
        TopicFragment fragment = new TopicFragment();
        fragment.setTitle(title);
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

        _textHeader.setText(_title);

        Article article;
        for (int i = 0; i < 10; i++) {
            article = new Article("Open article " + i);
            _elements.add(i, article);
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);

        _articleFeed.setLayoutManager(layoutManager);
        _articleFeedAdapter = new ArticleFeedAdpater();
        _articleFeedAdapter.setCollection(_elements);
        _articleFeed.setAdapter(_articleFeedAdapter);
    }

    public int getPageNumber() {
        return _pageNumber;
    }

    public void setTitle(String title) {
        _title = title;
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
