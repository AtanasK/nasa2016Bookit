package com.bookitfava.nasaspaceapps.moonchaser;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ReceiveMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_messages);

        Bundle bundle = getIntent().getExtras();
        String messageText = bundle.getString("message");

        TextView message = (TextView)findViewById(R.id.tvMessage);
        message.setText(messageText);

        TextView from = (TextView)findViewById(R.id.tvFrom);
        from.setText("From: DemoUser");
    }

    public void bBackClick(View view) {
        Intent main = new Intent(this, MainActivity.class);
        startActivity(main);
        onStop();
    }

    public void bRespondClick(View view) {
        Intent response = new Intent(this, MessageActivity.class);
        startActivity(response);
        onStop();
    }
}
