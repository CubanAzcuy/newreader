package mmilord.newsreader.pages.article_hub;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;

import mmilord.newsreader.models.Article;
import mmilord.newsreader.common.ui.BaseViewHolder;

/**
 * Created by milord on 06-Jan-16.
 */
public class ArticleFeedAdpater extends RecyclerView.Adapter<BaseViewHolder> {

    protected ArrayList<Article> _articles;

    public void setCollection(ArrayList<Article> items){
        _articles = items;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return ArticleCardViewHolder.newInstance(parent);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.bind(_articles.get(position));
    }

    @Override
    public int getItemCount() {
        return _articles.size();
    }
}

