package com.bookitfava.nasaspaceapps.moonchaser;

import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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

    public static Random rand = new Random();

    private Story[] stories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_discover);

        Bitmap moonmon = BitmapFactory.decodeResource(getResources(), R.drawable.moonmon);
        Bitmap maps = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
        Bitmap fullmoonimg = BitmapFactory.decodeResource(getResources(), R.drawable.fullmoonimg);
        Bitmap newmoon = BitmapFactory.decodeResource(getResources(), R.drawable.newmoon);

        stories = new Story[]{
                new Story(moonmon, "The moon goes around the Earth\nwith around 3700km per hour.", maps, "That's like going from Europe to the US in less then 2 hours.\n" +
                        "That's a lot!"),
                new Story(fullmoonimg, "When the moon is behind the Earth it is a full circle, that is called a full moon!", newmoon, "When the moon is in front of the Earth, we can't see it. That is called a new moon!")
        };

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
        int storyPicker = rand.nextInt(stories.length); // Picknavme story

        return stories[storyPicker];
    }

    public void setNewStory(Story newStory) {
        firstImage.setImageBitmap(newStory.getFirstImage());
        firstText.setText(newStory.getFirstText());
        Log.v("OVDEDEBUG", newStory.getSecondText());
        secondImage.setImageBitmap(newStory.getSecondImage());
        secondText.setText(newStory.getSecondText());
    }

    public void onClickBack(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void onClickShare(View view) {
        try {
            // TODO: This part does not work properly based on my test
            Intent fbIntent = new Intent(Intent.ACTION_SEND);
            fbIntent.setType("text/plain");
            fbIntent.putExtra(Intent.EXTRA_TEXT, "Did you know: " + firstText);
            fbIntent.putExtra(Intent.EXTRA_STREAM, "www.example.com");
            fbIntent.addCategory(Intent.CATEGORY_LAUNCHER);
            fbIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                    | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
            fbIntent.setComponent(new ComponentName("com.facebook.katana",
                    "com.facebook.composer.shareintent.ImplicitShareIntentHandler"));

            startActivity(fbIntent);
            return;
        } catch (Exception e) {
            // User doesn't have Facebook app installed. Try sharing through browser.
        }

        // If we failed (not native FB app installed), try share through SEND
        String sharerUrl = "https://www.facebook.com/sharer/sharer.php?u=" + "example.com&t=BookItToTheMoon";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(sharerUrl));
        startActivity(i);
    }

    public void onClickMore(View view) {
        Story story = generateNewStory();
        setNewStory(story);
    }

}