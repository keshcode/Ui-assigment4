package com.example.keshav.iblive;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.keshav.iblive.fragment.DiscoverFragment;
import com.example.keshav.iblive.fragment.MapRequestFragment;
import com.example.keshav.iblive.fragment.MyNetworkFragment;
import com.example.keshav.iblive.fragment.MyPostFragment;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        FragmentStatePagerAdapter mStatePagerAdapter = new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(final int position) {
                if (position == 0) {
                    DiscoverFragment discoverFragment = new DiscoverFragment();
                    return discoverFragment;
                }
                else if(position == 1) {
                    MyPostFragment myPostFragment = new MyPostFragment();
                    return myPostFragment;
                }
                else if(position ==2) {
                    MyNetworkFragment myNetworkFragment = new MyNetworkFragment();
                    return myNetworkFragment;
                }
                MapRequestFragment mapRequestFragment = new MapRequestFragment();
                return mapRequestFragment;
            }

            @Override
            public int getCount() {
                return 4;
            }
        };
        viewPager.setAdapter(mStatePagerAdapter);
    }
    public void init(){
        viewPager = (ViewPager) findViewById(R.id.vpShowOption);
    }
}
