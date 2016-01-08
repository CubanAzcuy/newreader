package mmilord.newsreader.views.common.interfaces;

import android.view.ViewGroup;

import mmilord.newsreader.views.common.ui.BaseViewHolder;

/**
 * Created by robertgross on 1/8/16.
 */
public interface BaseViewHolderFactory {
    public BaseViewHolder generateViewHolder(ViewGroup parent);
}

