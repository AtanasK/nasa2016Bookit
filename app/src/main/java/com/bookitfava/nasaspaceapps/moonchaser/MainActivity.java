package com.bookitfava.nasaspaceapps.moonchaser;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView logo = (ImageView)findViewById(R.id.ivLogo);
        Bitmap logoImage = BitmapFactory.decodeResource(getResources(), R.drawable.themoon);
        logo.setImageBitmap(logoImage);
    }

    public void bDiscoverClick(View view) {
        Intent intent = new Intent(this, DiscoverActivity.class);
        startActivity(intent);
        onStop();
    }

    public void bShareClick(View view) {
        Intent message = new Intent(this, MessageActivity.class);
        startActivity(message);
        onStop();
    }
}
