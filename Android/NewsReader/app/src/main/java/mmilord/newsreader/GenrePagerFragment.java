package mmilord.newsreader;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by milord on 06-Jan-16.
 */
public class GenrePagerFragment extends Fragment {

    public static final String ARG_PAGE = "page", ARG_TITLE = "title";
    private int pageNumber;
    private String title;
    private RecyclerView recyclerView;
    private final int visibleThreshold = 40;
    private boolean scrollingLoading = true;
    private RecyclerElementAdapter recyclerElementAdapter;
    private List<String> elements = new ArrayList<>();

    public static GenrePagerFragment create(int pageNumber, String title) {
        GenrePagerFragment fragment = new GenrePagerFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, pageNumber);
        args.putString(ARG_TITLE, title);
        fragment.setArguments(args);
        return fragment;
    }

    public GenrePagerFragment() { }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            pageNumber = getArguments().getInt(ARG_PAGE);
            title = getArguments().getString(ARG_TITLE);
        }
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_genre, container, false);

        ((TextView) rootView.findViewById(R.id.text_genre_header)).setText("News");

        for (int i = 0; i < 10; i++) {
            this.elements.add(i, "Open article " + i);
        }

        final LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_articles);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new HorizontalSpaceRecyclerItemDecoration(5));
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if (dy > 0) {
                    int visibleItemCount = layoutManager.getChildCount();
                    int totalItemCount = layoutManager.getItemCount();
                    int pastVisibleItem = layoutManager.findFirstVisibleItemPosition();

                    if (scrollingLoading) {
                        if ((visibleItemCount + pastVisibleItem) >= totalItemCount) {
                            scrollingLoading = false;
                            recyclerElementAdapter.add();
                        }
                    }

                    if(!scrollingLoading && (totalItemCount - visibleItemCount) <= (pastVisibleItem + visibleThreshold))
                        scrollingLoading = true;
                }
            }
        });

        recyclerElementAdapter = new RecyclerElementAdapter(getContext(), elements, getFragmentManager());

        recyclerView.setAdapter(recyclerElementAdapter);
        //recyclerElementAdapter.add();

        return rootView;
    }

    public int getPageNumber() {
        return pageNumber;
    }
}
