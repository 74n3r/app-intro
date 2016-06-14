package com.odoomobile.libs.helper;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

import java.util.List;
import java.util.Vector;

public class IntroViewPager extends ViewPager {

    private List<IntroSlide> slides = new Vector<>();

    public IntroViewPager(Context context) {
        super(context);
        init(context);
    }

    public IntroViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {

    }

}
