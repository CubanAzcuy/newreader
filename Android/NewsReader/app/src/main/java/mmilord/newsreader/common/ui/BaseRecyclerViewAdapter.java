package mmilord.newsreader.common.ui;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

import mmilord.newsreader.common.interfaces.BaseViewHolderFactory;

/**
 * Created by robertgross on 1/8/16.
 */
public class BaseRecyclerViewAdapter <T> extends RecyclerView.Adapter<BaseViewHolder> {

    protected BaseViewHolderFactory _basic;
    protected List<T> _items;

    public BaseRecyclerViewAdapter(BaseViewHolderFactory baseViewHolderFactory){
        _basic = baseViewHolderFactory;
    }

    public void setCollection(List<T> items){
        _items = items;
    }

    @Override
    public int getItemCount() {
        return _items.size();
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return _basic.generateViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder viewHolder, int position) {
        viewHolder.bind(_items.get(position));
    }
}