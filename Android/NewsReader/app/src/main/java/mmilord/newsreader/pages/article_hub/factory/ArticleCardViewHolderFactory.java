package mmilord.newsreader.pages.article_hub.factory;

import android.view.ViewGroup;

import mmilord.newsreader.common.interfaces.BaseViewHolderFactory;
import mmilord.newsreader.common.ui.BaseViewHolder;
import mmilord.newsreader.pages.article_hub.ArticleCardViewHolder;

/**
 * Created by robertgross on 1/8/16.
 */
public class ArticleCardViewHolderFactory implements BaseViewHolderFactory {
    @Override
    public BaseViewHolder generateViewHolder(ViewGroup parent) {
        return ArticleCardViewHolder.newInstance(parent);
    }
}
