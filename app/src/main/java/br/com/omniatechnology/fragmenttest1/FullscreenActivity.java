package br.com.omniatechnology.fragmenttest1;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class FullscreenActivity extends FragmentActivity implements IFragmentCommunication{

    private static final int NUM_PAGES = 3;
    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;

    private User user;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen);

        viewPager = findViewById(R.id.pager);

        pagerAdapter = new ScreenSlidePageAdapter(getSupportFragmentManager());
        pagerAdapter.notifyDataSetChanged();
        viewPager.setAdapter(pagerAdapter);
        viewPager.setPageTransformer(true, new ZoomOutPageTransformer());
        viewPager.addOnPageChangeListener(pageChangeListener);

        user = new User();


    }

    public void openFragment(int position){
       viewPager.setCurrentItem(position);


    }

    @Override
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public User getUser() {
        return user;
    }



    public static class ScreenSlidePageAdapter extends FragmentStatePagerAdapter {

        List<Fragment> fragments;

        public ScreenSlidePageAdapter(FragmentManager fm) {
            super(fm);
            fragments = new ArrayList<>();
            fragments.add(new Frag1());
            fragments.add(new Frag2());
            fragments.add(new Frag3());

        }


        @Override
        public Fragment getItem(int i) {

            return fragments.get(i);


        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }


    private ViewPager.OnPageChangeListener pageChangeListener = new ViewPager.OnPageChangeListener() {

        int currentPosition = 0;

        @Override
        public void onPageSelected(int newPosition) {

            Fragment fragment = ((ScreenSlidePageAdapter) pagerAdapter ).getItem(currentPosition);
            ((InterfacesClass.FragmentLifecycle) fragment ).onPauseFragment();

            Fragment fragmentShow = ((ScreenSlidePageAdapter) pagerAdapter ).getItem(newPosition);
            ((InterfacesClass.FragmentLifecycle) fragmentShow ).onResumeFragment();

            currentPosition = newPosition;
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) { }

        public void onPageScrollStateChanged(int arg0) { }
    };


}
