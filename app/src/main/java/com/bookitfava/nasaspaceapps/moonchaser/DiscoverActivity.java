package com.bookitfava.nasaspaceapps.moonchaser;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class DiscoverActivity extends AppCompatActivity implements SensorEventListener {

    public class MyView extends SurfaceView implements Runnable {

        Bitmap themoon;
        Bitmap background;
        SurfaceHolder holder;
        public Thread thread;
        boolean isRunning;
        public int x;
        public int y;
        public int z;

        public MyView(Context context) {
            super(context);
            holder = getHolder();
            thread = new Thread(this);
            isRunning = true;
            x = 0;
            y = 0;
            z = 0;
            themoon = BitmapFactory.decodeResource(context.getResources(), R.drawable.ful);
            background = BitmapFactory.decodeResource(context.getResources(), R.drawable.background);
            thread.start();
        }

        public void run() {
            while (isRunning) {
                if (!holder.getSurface().isValid()) {
                    continue;
                }
                Canvas canvas = holder.lockCanvas();
                if (canvas == null)
                    continue;
                canvas.drawBitmap(background, 0, 0, null);
                canvas.drawBitmap(themoon, -x, y , null);
                holder.unlockCanvasAndPost(canvas);
            }
        }
    }

    private MyView myview;
    SensorManager sm;
    String message;
    Bundle bandl;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bandl = getIntent().getExtras();
        if(bandl != null)
            message = bandl.getString("message");
        myview = new MyView(this);
        sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        sm.registerListener(this, sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
        setContentView(myview);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myview.isRunning = false;
        try {
            myview.thread.join();
            myview.themoon.recycle();
            myview.background.recycle();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            if((int)event.values[0] > -2 && (int)event.values[0] < 2 && (int)event.values[1] > -2 && (int)event.values[1] < 2 && (int)event.values[2] > -11 && (int)event.values[2] < -8) {
                boolean flag = true;
                if(message != null) {
                    Intent risiv = new Intent(this, ReceiveMessageActivity.class);
                    risiv.putExtras(bandl);
                    startActivity(risiv);
                    flag = false;
                }
                else if (flag) {
                    Intent stori = new Intent(this, StoryActivity.class);
                    startActivity(stori);
                }
            }
            myview.x = (int) event.values[0] * 90;
            myview.y = (int) event.values[1] * 90;
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
