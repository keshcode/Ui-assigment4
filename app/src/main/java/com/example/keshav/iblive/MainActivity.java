package com.example.keshav.iblive;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.keshav.iblive.fragment.DiscoverFragment;
import com.example.keshav.iblive.fragment.MapRequestFragment;
import com.example.keshav.iblive.fragment.MyNetworkFragment;
import com.example.keshav.iblive.fragment.MyPostFragment;
import com.example.keshav.iblive.fragment.NewRequest;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    TextView tvTitle,tvDiscover,tvMap,tvMyPost,tvRequests,tvMyNetwork;
    TextView colorstab[];
    ImageView ivGrid,ivList,ivPostFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        tvTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "lol hello", Toast.LENGTH_SHORT).show();
                tvTitle.setBackgroundResource(R.drawable.selector_bottom_bar_btn);
            }
        });
        FragmentStatePagerAdapter mStatePagerAdapter = new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(final int position) {
                if (position == 0) {
                     DiscoverFragment discoverFragment = new DiscoverFragment();
                     tvTitle.setText(R.string.discover);
                    return discoverFragment;
                } else if (position == 2) {
                    MyPostFragment myPostFragment = new MyPostFragment();
                    return myPostFragment;
                } else if (position == 4) {
                    MyNetworkFragment myNetworkFragment = new MyNetworkFragment();
                    return myNetworkFragment;
                } else if (position == 1) {
                    MapRequestFragment mapRequestFragment = new MapRequestFragment();
                    return mapRequestFragment;
                }
                NewRequest newRequest = new NewRequest();
                return newRequest;
            }

            @Override
            public int getCount() {
                return 5;
            }
        };
        viewPager.setAdapter(mStatePagerAdapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                ivGrid.setVisibility(View.VISIBLE);
                ivList.setVisibility(View.VISIBLE);
                ivPostFilter.setVisibility(View.GONE);
                switch(position) {
                    case 0:
                        tvTitle.setText(R.string.discover);
                        break;
                    case 1:
                        tvTitle.setText(R.string.map);
                        ivGrid.setVisibility(View.INVISIBLE);
                        ivList.setVisibility(View.INVISIBLE);
                        break;
                    case 2:
                        tvTitle.setText(R.string.my_posts);
                        ivList.setVisibility(View.GONE);
                        ivGrid.setVisibility(View.GONE);
                        ivPostFilter.setVisibility(View.VISIBLE);
                        break;
                    case 3:
                        tvTitle.setText(R.string.new_requests);
                        ivGrid.setVisibility(View.INVISIBLE);
                        ivList.setVisibility(View.INVISIBLE);
                        break;
                    case 4:
                        tvTitle.setText(R.string.my_network);
                        ivGrid.setVisibility(View.INVISIBLE);
                        ivList.setVisibility(View.INVISIBLE);
                        break;
                    default:
                        break;

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public void init() {
        viewPager = (ViewPager) findViewById(R.id.vpShowOption);
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        ivGrid = (ImageView) findViewById(R.id.ivGrigView);
        ivList = (ImageView) findViewById(R.id.ivlist);
        tvDiscover = (TextView) findViewById(R.id.tvdiscover);
        tvMap = (TextView) findViewById(R.id.tvMap);
        tvMyPost = (TextView) findViewById(R.id.tvMyPost);
        tvRequests = (TextView) findViewById(R.id.tvRequests);
        tvMyNetwork = (TextView) findViewById(R.id.tvMyNetwork);
        ivPostFilter = (ImageView) findViewById(R.id.ivPostFilter);
    }
}
