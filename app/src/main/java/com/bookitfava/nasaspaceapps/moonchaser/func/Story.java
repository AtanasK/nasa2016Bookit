package com.bookitfava.nasaspaceapps.moonchaser.func;

import android.graphics.Bitmap;
import android.widget.TextView;

/**
 * Created by AtanasK on 22-Apr-16.
 */
public class Story {
    private Bitmap image;
    private String text;
    private Bitmap secondImage;
    private String secondText;
    private boolean isDouble;
    private boolean isSeen;

    public Story(Bitmap image, String text, Bitmap second, String vtor) {
        this.image = image;
        this.text = text;
        secondImage = second;
        secondText = vtor;
        isDouble = true;
        isSeen = false;
    }

    public Bitmap getFirstImage() {
        return image;
    }

    public Bitmap getSecondImage() {
        return secondImage;
    }

    public String getSecondText() {
        return secondText;
    }

    public void setFirstImage(Bitmap image) {
        this.image = image;
    }

    public String getFirstText() {
        return text;
    }

    public void setFirstText(String text) {
        this.text = text;
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
