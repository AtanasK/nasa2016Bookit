package com.bookitfava.nasaspaceapps.moonchaser;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.themoon);

        stories = new Story[]{new Story(bitmap, "Proben tekst"), new Story(bitmap, "Proben tekst 2"), new Story(bitmap, "Proben tekst 3")};


        // inicirame sho e sho
        firstImage = (ImageView) findViewById(R.id.firstImage);
        secondImage = (ImageView) findViewById(R.id.secondImage);

        firstText = (TextView) findViewById(R.id.firstText);
        secondText = (TextView) findViewById(R.id.secondText);
        // done so iniciranje

        // setiraj gi views
        Story chosenOne = generateNewStory();
        setNewStory(chosenOne);

    }

    public Story generateNewStory() {
        Random rand = new Random();
        int storyPicker = rand.nextInt(stories.length); // Picknavme story

        return stories[storyPicker];
    }

    public void setNewStory(Story newStory) {
        firstImage.setImageBitmap(newStory.getFirstImage());
        firstText.setText(newStory.getFirstText());
    }

    public void onClickBack(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        onStop();
    }

    public void onClickShare(View view) {
        // TODO ovde
    }

    public void onClickMore(View view) {
        Story story = generateNewStory();
        setNewStory(story);
    }

}
