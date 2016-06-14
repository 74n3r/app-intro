package com.odoomobile.libs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.odoomobile.libs.helper.IntroSlide;
import com.odoomobile.libs.helper.IntroViewPager;
import com.odoomobile.libs.helper.PagerAdapter;

import java.util.List;
import java.util.Vector;

public abstract class AppIntroActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    public static final String TAG = AppIntroActivity.class.getCanonicalName();
    private List<IntroSlide> introSlides = new Vector<>();
    private int activeSlide;

    private PagerAdapter pagerAdapter;
    private IntroViewPager introViewPager;
    private boolean skipButtonEnabled = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppIntro_Theme);
        setContentView(R.layout.app_intro_main);

        introViewPager = (IntroViewPager) findViewById(R.id.appIntroViewPager);
        introViewPager.addOnPageChangeListener(this);
    }

    public void addSlide(IntroSlide slide) {
        introSlides.add(slide);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        pagerAdapter = new PagerAdapter(this, getSupportFragmentManager(), introSlides);
        introViewPager.setAdapter(pagerAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        onAppIntroClose();
    }

    public void setSkipButtonEnabled(boolean enabled) {
        skipButtonEnabled = enabled;
    }

    public abstract void onDoneClick();

    public abstract void onSkipClick();

    public abstract void onAppIntroClose();

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
