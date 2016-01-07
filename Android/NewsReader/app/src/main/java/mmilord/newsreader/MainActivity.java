package mmilord.newsreader;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private GenrePagerFragment genrePagerFragment;
    private ViewPager genrePagerView;
    private GenrePagerAdapter genrePagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        genrePagerView = (ViewPager) findViewById(R.id.pager_genre);
        genrePagerAdapter = new GenrePagerAdapter(getSupportFragmentManager());
        genrePagerView.setAdapter(genrePagerAdapter);
        genrePagerView.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) { }
        });

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        genrePagerFragment = new GenrePagerFragment();
        fragmentTransaction.add(R.id.pager_genre, genrePagerFragment).commit();
    }

    @Override
    public void onBackPressed() {
        if (genrePagerView.getCurrentItem() == 0)
            super.onBackPressed();
        else
            genrePagerView.setCurrentItem(genrePagerView.getCurrentItem() - 1);
    }

    public void switchContent(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.pager_genre, fragment).commit();

    }
}
