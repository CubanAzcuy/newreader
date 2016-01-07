package mmilord.newsreader;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by milord on 06-Jan-16.
 */
public class HorizontalSpaceRecyclerItemDecoration extends RecyclerView.ItemDecoration {
    private final int horizontalSpaceHeight;

    public HorizontalSpaceRecyclerItemDecoration(int horizontalSpaceHeight) {
        this.horizontalSpaceHeight = horizontalSpaceHeight;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        if (parent.getChildAdapterPosition(view) != parent.getAdapter().getItemCount() - 1)
            outRect.right = horizontalSpaceHeight;
    }
}
