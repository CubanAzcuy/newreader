package mmilord.newsreader;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.Bind;

/**
 * Created by robertgross on 1/7/16.
 */
public class ArticleCardViewHolder extends BaseViewHolder<Article> implements View.OnClickListener {

    Article _article;

    @Bind(R.id.recycler_element_article_title)
    TextView _title;

    public static ArticleCardViewHolder newInstance(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.article_card, parent, false);
        ArticleCardViewHolder viewHolder = new ArticleCardViewHolder(view);
        return viewHolder;
    }

    public ArticleCardViewHolder(View view) {
        super(view);
        view.setOnClickListener(this);
    }


    @Override
    public void bind(Article task) {
        super.bind(task);
        _article = task;
        _title.setText(task.getTitle());
    }

    @Override
    public void onClick(View view){
        if(view.getContext() instanceof ButtonClicked){
            ButtonClicked buttonClicked = (ButtonClicked) view.getContext();
            buttonClicked.onClick(_article);
        }
    }


}
