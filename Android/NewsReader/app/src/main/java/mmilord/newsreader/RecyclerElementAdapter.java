package mmilord.newsreader;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by milord on 06-Jan-16.
 */
public class RecyclerElementAdapter extends RecyclerView.Adapter<RecyclerElementAdapter.ViewHolder> {

    private Context context;
    private FragmentManager fragmentManager;
    private List<String> elements = new ArrayList<String>();

    public RecyclerElementAdapter(Context context, List<String> elements, FragmentManager fragmentManager) {
        this.context = context;
        this.fragmentManager = fragmentManager;
        this.elements = elements;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements /*View.OnClickListener,*/ View.OnLongClickListener {
        public final LinearLayout linearLayout;
        public final TextView titleArticle;

        public ViewHolder(View view) {
            super(view);
            view.setClickable(true);
            view.setOnLongClickListener(this);

            titleArticle = (TextView) view.findViewById(R.id.recycler_element_article_title);
            linearLayout = (LinearLayout) view.findViewById(R.id.recycler_lienar_container);
        }

        /*@Override
        public void onClick (View view) {
            Toast.makeText(context, "Short click, article opening", Toast.LENGTH_SHORT).show();
            Fragment fragment = new ArticleFragment();
            FragmentManager fragmentManager = ((MainActivity) context).getSupportFragmentManager();
            //if (fragment != null)
            //    switchFragment(fragment);
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.pager_genre, fragment).addToBackStack("article").commit();
        }*/

        @Override
        public boolean onLongClick (View view) {
            elements.remove(getAdapterPosition());
            notifyItemRemoved(getAdapterPosition());
            notifyItemRangeChanged(getAdapterPosition(), getItemCount());
            return true;
        }
    }

    @Override
    public ViewHolder onCreateViewHolder (ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(this.context).inflate(R.layout.recycler_element, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder (ViewHolder holder, final int position) {
        holder.titleArticle.setText("lkjkl;jh l;llkjljk");
    }

    public void add() {
        int count = elements.size();
        int newSize = count + 5;
        for (; count < newSize; count++) {
            elements.add(count, "Open article " + count);
        }

        notifyDataSetChanged();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return this.elements.size();
    }

    private void switchFragment (Fragment fragment) {
        if (context == null)
            return;
        if (context instanceof MainActivity) {
            MainActivity feeds = (MainActivity) context;
            feeds.switchContent(fragment);
        }
    }
}
