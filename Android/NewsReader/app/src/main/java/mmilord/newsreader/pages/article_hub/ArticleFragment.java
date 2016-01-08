package mmilord.newsreader.pages.article_hub;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import mmilord.newsreader.R;

/**
 * Created by milord on 07-Jan-16.
 */
public class ArticleFragment extends Fragment {

    public static final String ARG_TITLE = "title";
    private String articleNum;

    public static ArticleFragment newInstance(String articleNum) {
        ArticleFragment fragment = new ArticleFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TITLE, articleNum);
        fragment.setArguments(args);
        return fragment;
    }

    public ArticleFragment() { }

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            articleNum = getArguments().getString(ARG_TITLE);
        }
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_article, container, false);

        ((TextView) rootView.findViewById(R.id.text_article_title)).setText(articleNum);

        return rootView;
    }
}
