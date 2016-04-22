package com.bookitfava.nasaspaceapps.moonchaser.func;

import android.graphics.Bitmap;
import android.widget.TextView;

/**
 * Created by AtanasK on 22-Apr-16.
 */
public class Story {
    private Bitmap image;
    private String text;
    private boolean isDouble;
    private Bitmap secondImage;
    private String secondText;
    private boolean isSeen;

    public Story(Bitmap image, String text) {
        this.image = image;
        this.text = text;
        isDouble = false;
        isSeen = false;
    }

    public Story(Bitmap image, String text, Bitmap image2, String text2) {
        this.image = image;
        this.text = text;
        secondImage = image2;
        secondText = text2;
        isDouble = true;
        isSeen = false;
    }

    public Bitmap getFirstImage() {
        return image;
    }

    public void setFirstImage(Bitmap image) {
        this.image = image;
    }

    public Bitmap getSecondImage() {
        return secondImage;
    }

    public void setSecondImage(Bitmap image) {
        secondImage = image;
    }

    public String getFirstText() {
        return text;
    }

    public void setFirstText(String text) {
        this.text = text;
    }

    public String getSecondText() {
        return secondText;
    }

    public void setSecondText(String text) {
        secondText = text;
    }

    public boolean isSeen() {
        return isSeen;
    }

    public void setSeen(boolean isSeen) {
        this.isSeen = isSeen;
    }

    public boolean isDouble() {
        return isDouble;
    }
}
