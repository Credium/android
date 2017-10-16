package org.androidtown.mysignalapplication;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;

import org.androidtown.mysignalapplication.Adapter.PagerFragmentAdapter;
import org.androidtown.mysignalapplication.Fragments.HomeFragment;
import org.androidtown.mysignalapplication.Fragments.MoreFragment;
import org.androidtown.mysignalapplication.Fragments.MyPageFragment;
import org.androidtown.mysignalapplication.Fragments.NoticeFragment;

public class MainActivity extends AppCompatActivity
        implements ViewPager.OnPageChangeListener,
        HomeFragment.OnFragmentInteractionListener,
        MoreFragment.OnFragmentInteractionListener,
        MyPageFragment.OnFragmentInteractionListener,
        NoticeFragment.OnFragmentInteractionListener {

    ViewPager viewPager;
    BottomNavigationView navigation;
    MenuItem mItem;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    viewPager.setCurrentItem(0);
                    return true;
                case R.id.navigation_mypage:
                    viewPager.setCurrentItem(1);
                    return true;
                case R.id.navigation_notifications:
                    viewPager.setCurrentItem(2);
                    return true;
                case R.id.navigation_more:
                    viewPager.setCurrentItem(3);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.viewpager);

        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        // Set up the ViewPager with the sections adapter.
        viewPager.setAdapter(new PagerFragmentAdapter(getSupportFragmentManager()));;
        viewPager.addOnPageChangeListener(this);
        viewPager.setCurrentItem(0);
        mItem = navigation.getMenu().getItem(0);
        viewPager.setOffscreenPageLimit(4);

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    View.OnClickListener movePageListener = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            int tag = (int) v.getTag();
            viewPager.setCurrentItem(tag);
        }
    };


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        if (mItem != null) {
            mItem.setChecked(false);
        }
        mItem = navigation.getMenu().getItem(position);
        mItem.setChecked(true);

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
