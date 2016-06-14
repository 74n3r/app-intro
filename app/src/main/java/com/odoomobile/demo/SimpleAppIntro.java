package com.odoomobile.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.odoomobile.libs.AppIntroActivity;
import com.odoomobile.libs.helper.IntroSlide;

public class SimpleAppIntro extends AppIntroActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addSlide(new IntroSlide()
                .setTitle(R.string.app_name)
                .setContent(R.string.app_content)
                .setBackground(R.color.colorAccent)
                .setTextColor(android.R.color.white));
        addSlide(new IntroSlide()
                .setTitle(R.string.app_name)
                .setContent(R.string.app_content)
                .setBackground(R.color.colorPrimaryDark)
                .setTextColor(android.R.color.white));
//        addSlide(new IntroSlide("Slide A", "This is simple slide A", R.mipmap.ic_launcher));
//        addSlide(new IntroSlide("Slide B", "This is simple slide B", R.mipmap.ic_launcher));
//        addSlide(new IntroSlide("Slide C", "This is simple slide C", R.mipmap.ic_launcher));
//
//        addSlide(new IntroSlide("Quick capture image", "Capture image for customer profile",
//                R.mipmap.ic_launcher).getPermissions(Manifest.permission.CAMERA));
    }

    @Override
    public void onDoneClick() {
        Toast.makeText(SimpleAppIntro.this, "Done Clicked", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSkipClick() {
        Toast.makeText(SimpleAppIntro.this, "Skip button clicked", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAppIntroClose() {
        Toast.makeText(SimpleAppIntro.this, "App Intro Closed", Toast.LENGTH_SHORT).show();
    }
}
