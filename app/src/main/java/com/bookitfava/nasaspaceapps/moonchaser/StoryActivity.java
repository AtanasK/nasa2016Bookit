package com.bookitfava.nasaspaceapps.moonchaser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bookitfava.nasaspaceapps.moonchaser.func.Story;

import java.util.Random;

public class StoryActivity extends AppCompatActivity {

    // prva slika
    ImageView firstImage;
    // vtora slika
    ImageView secondImage;
    // prv pasus
    TextView firstText;
    // vtor pasus
    TextView secondText;

    private Story[] stories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_discover);

        stories = new Story[]{new Story(), new Story(), new Story()};

        Random rand = new Random();
        int storyPicker = rand.nextInt(stories.length); // Picknavme story

        // inicirame sho e sho
        firstImage = (ImageView) findViewById(R.id.firstImage);
        secondImage = (ImageView) findViewById(R.id.secondImage);

        firstText = (TextView) findViewById(R.id.firstText);
        secondText = (TextView) findViewById(R.id.secondText);
        // done so iniciranje


    }


}
