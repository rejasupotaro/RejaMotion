package com.rejasupotaro.rejamotionapp.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.entity.mime.content.FileBody;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

public class AnimationEntity implements Parcelable {
    private String mTitle = "";
    private List<Uri> mUriList;
    private List<Bitmap> mBitmapList;
    private int mDelay;

    public AnimationEntity() {
        mUriList = new ArrayList<Uri>();
        mBitmapList = new ArrayList<Bitmap>();
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setDelay(int delay) {
        mDelay = delay;
    }

    public int getDelay() {
        return mDelay;
    }

    public void add(Uri uri, Bitmap bitmap) {
        if (uri == null || bitmap == null) return;

        mUriList.add(uri);
        mBitmapList.add(bitmap);
    }

    public int size() {
        return mUriList.size();
    }

    public List<Bitmap> getBitmapList() {
        return mBitmapList;
    }

    public Bitmap getBitmap(int index) {
        return mBitmapList.get(index);
    }

    public List<Uri> getUriList() {
        return mUriList;
    }

    public List<FileBody> getFileBodyList() {
        List<FileBody> fileBodyList = new ArrayList<FileBody>();

        for (Uri imageUri: mUriList) {
            fileBodyList.add(new FileBody(new File(imageUri.toString())));
        }

        return fileBodyList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mTitle);
        dest.writeList(mUriList);
        //dest.writeList(mBitmapList);
        dest.writeInt(mDelay);
    }

    public static final Parcelable.Creator<AnimationEntity> CREATOR = new Parcelable.Creator<AnimationEntity>() {
        @Override
        public AnimationEntity createFromParcel(Parcel source) {
            return new AnimationEntity(source);
        }

        @Override
        public AnimationEntity[] newArray(int size) {
            return new AnimationEntity[size];
        }
    };

    private AnimationEntity(Parcel source) {
        mTitle = source.readString();
        mUriList = new ArrayList<Uri>();
        source.readList(mUriList, null);
        //source.readList(mBitmapList, null);
        mDelay = source.readInt();
    }
}
