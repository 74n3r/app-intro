package com.odoomobile.libs.helper;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;

import java.util.Arrays;

public class IntroSlide implements Parcelable {

    public Integer title_res_id, content_res_id, background_color = android.R.color.white,
            text_color = android.R.color.black;
    public Integer image_res_id;
    public String[] permissions;
    public Bundle extra = Bundle.EMPTY;

    public IntroSlide() {

    }

    protected IntroSlide(Parcel in) {
        title_res_id = in.readInt();
        content_res_id = in.readInt();
        background_color = in.readInt();
        text_color = in.readInt();
        image_res_id = in.readInt();
        extra = in.readBundle(getClass().getClassLoader());
        permissions = in.createStringArray();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(title_res_id);
        dest.writeInt(content_res_id);
        dest.writeInt(background_color);
        dest.writeInt(text_color);
        dest.writeInt(image_res_id);
        dest.writeBundle(extra);
        dest.writeStringArray(permissions);
    }

    public static final Creator<IntroSlide> CREATOR = new Creator<IntroSlide>() {
        @Override
        public IntroSlide createFromParcel(Parcel in) {
            return new IntroSlide(in);
        }

        @Override
        public IntroSlide[] newArray(int size) {
            return new IntroSlide[size];
        }
    };

    public IntroSlide setTitle(@StringRes int title_res_id) {
        this.title_res_id = title_res_id;
        return this;
    }

    public IntroSlide setContent(@StringRes int content_res_id) {
        this.content_res_id = content_res_id;
        return this;
    }

    public IntroSlide setImage(@DrawableRes int image_res_id) {
        this.image_res_id = image_res_id;
        return this;
    }

    public IntroSlide requiredPermissions(String... permissions) {
        this.permissions = permissions;
        return this;
    }

    public IntroSlide setBackground(@ColorRes int color) {
        background_color = color;
        return this;
    }

    public IntroSlide setTextColor(@ColorRes int color) {
        text_color = color;
        return this;
    }

    public IntroSlide setExtra(Bundle data) {
        extra = data;
        return this;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public String toString() {
        return "IntroSlide{" +
                "title_res_id=" + title_res_id +
                ", content_res_id=" + content_res_id +
                ", background_color=" + background_color +
                ", text_color=" + text_color +
                ", image_res_id=" + image_res_id +
                ", permissions=" + Arrays.toString(permissions) +
                ", extra=" + extra +
                '}';
    }
}
