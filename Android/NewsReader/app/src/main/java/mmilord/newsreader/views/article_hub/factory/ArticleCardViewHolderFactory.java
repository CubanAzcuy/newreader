package mmilord.newsreader.views.article_hub.factory;

import android.view.ViewGroup;

import mmilord.newsreader.views.common.interfaces.BaseViewHolderFactory;
import mmilord.newsreader.views.common.ui.BaseViewHolder;
import mmilord.newsreader.views.article_hub.ArticleCardViewHolder;

/**
 * Created by robertgross on 1/8/16.
 */
public class ArticleCardViewHolderFactory implements BaseViewHolderFactory {
    @Override
    public BaseViewHolder generateViewHolder(ViewGroup parent) {
        return ArticleCardViewHolder.newInstance(parent);
    }
}
