package com.odoomobile.libs.helper;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;
import java.util.Vector;

public class PagerAdapter extends FragmentStatePagerAdapter {
    public static final String KEY_POSITION = "key_pos";
    public static final String KEY_SLIDE = "slide_item";
    private Context context;
    private List<IntroSlide> slides = new Vector<>();

    public PagerAdapter(Context context, FragmentManager manager, List<IntroSlide> slides) {
        super(manager);
        this.context = context;
        this.slides.addAll(slides);
        notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int position) {
        IntroSlideFragment fragment = new IntroSlideFragment();
        Bundle data = new Bundle();
        data.putInt(KEY_POSITION, position);
        data.putParcelable(KEY_SLIDE, slides.get(position));
        fragment.setArguments(data);
        return fragment;
    }

    @Override
    public int getCount() {
        return slides.size();
    }

}
