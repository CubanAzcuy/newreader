package mmilord.newsreader.common.ui;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by robertgross on 1/7/16.
 */
public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {

    private T _data;

    public BaseViewHolder(View view) {
        super(view);

        ButterKnife.bind(this, view);
    }

    public BaseViewHolder(View view, boolean inject) {
        super(view);

        if(inject)
            ButterKnife.bind(this, view);
    }

    public void bind(T data) {

    }
}
