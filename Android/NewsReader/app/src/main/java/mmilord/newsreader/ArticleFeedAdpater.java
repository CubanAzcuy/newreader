package mmilord.newsreader;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

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

