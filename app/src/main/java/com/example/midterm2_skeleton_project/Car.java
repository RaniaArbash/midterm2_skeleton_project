package com.example.midterm2_skeleton_project;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.RequiresApi;

public class Car implements Parcelable {

    String OwnerName;
    Bitmap imageData;
    int year;
    String model;

    protected Car(Parcel in) {
        OwnerName = in.readString();
        imageData = in.readParcelable(Bitmap.class.getClassLoader());
        year = in.readInt();
        model = in.readString();
    }

    public static final Creator<Car> CREATOR = new Creator<Car>() {
        @Override
        public Car createFromParcel(Parcel in) {
            return new Car(in);
        }

        @Override
        public Car[] newArray(int size) {
            return new Car[size];
        }
    };

    public Car() {

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(OwnerName);
        dest.writeParcelable(imageData, flags);
        dest.writeInt(year);
        dest.writeString(model);
    }
}
