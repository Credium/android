package org.androidtown.mysignalapplication.Adapter;

import android.support.v4.app.FragmentStatePagerAdapter;

import org.androidtown.mysignalapplication.Fragments.HomeFragment;
import org.androidtown.mysignalapplication.Fragments.MoreFragment;
import org.androidtown.mysignalapplication.Fragments.MyPageFragment;
import org.androidtown.mysignalapplication.Fragments.NoticeFragment;

public class PagerFragmentAdapter extends FragmentStatePagerAdapter{

    public PagerFragmentAdapter(android.support.v4.app.FragmentManager fm)
    {
        super(fm);
    }
    @Override
    public android.support.v4.app.Fragment getItem(int position)
    {
        switch(position)
        {
            case 0:
                return new HomeFragment();
            case 1:
                return new MyPageFragment();
            case 2:
                return new NoticeFragment();
            case 3:
                return new MoreFragment();
            default:
                return null;
        }
    }
    @Override
    public int getCount()
    {
        return 4;
    }
}

