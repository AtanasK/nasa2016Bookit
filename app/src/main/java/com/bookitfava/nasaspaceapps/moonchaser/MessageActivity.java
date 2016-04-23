package com.bookitfava.nasaspaceapps.moonchaser;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
    }

    public void bBackClick(View view) {
        Intent main = new Intent(this, MainActivity.class);
        startActivity(main);
        onStop();
    }

    public void bSendClick(View view) {
        EditText message = (EditText)findViewById(R.id.etMessage);
        String messageText = message.getText().toString();

        Intent discover = new Intent(this, DiscoverActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("message", messageText);
        discover.putExtras(bundle);
        startActivity(discover);
        onStop();
    }
}
