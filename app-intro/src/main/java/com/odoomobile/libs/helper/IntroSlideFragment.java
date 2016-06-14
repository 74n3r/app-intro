package com.odoomobile.libs.helper;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.odoomobile.libs.R;

public class IntroSlideFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view;
        IntroSlide slide = getSlide();
        view = inflater.inflate(R.layout.intro_slide_view, container, false);
        view.setBackgroundResource(slide.background_color);
        TextView title = (TextView) view.findViewById(R.id.slideTitle);
        TextView content = (TextView) view.findViewById(R.id.slideContent);
        title.setText(slide.title_res_id);
        content.setText(slide.content_res_id);
        title.setTextColor(ContextCompat.getColor(getContext(), slide.text_color));
        content.setTextColor(ContextCompat.getColor(getContext(), slide.text_color));
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    private IntroSlide getSlide() {
        return getArguments().getParcelable(PagerAdapter.KEY_SLIDE);
    }

    private int getPosition() {
        return getArguments().getInt(PagerAdapter.KEY_POSITION);
    }

    public interface SliderBuilderListener {
        View getCustomView(Context context, IntroSlide item,
                           ViewGroup parent);
    }
}
