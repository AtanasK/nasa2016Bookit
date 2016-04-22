package com.bookitfava.nasaspaceapps.moonchaser;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class DiscoverActivity extends AppCompatActivity implements SensorEventListener {
    private CustomDrawableView cdv;
    private Bitmap bmMoon;
    private int x;
    private int y;
    private SensorManager sensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        cdv = new CustomDrawableView(this);
        setContentView(R.layout.activity_discover);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            x = (int)event.values[0];
            y = (int)event.values[1];
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onStop() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.CUPCAKE) {
            sensorManager.unregisterListener(this);
        }
        super.onStop();
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        //izlishno
    }

    public class CustomDrawableView extends View {

        public CustomDrawableView(Context context) {
            super(context);
            bmMoon = BitmapFactory.decodeResource(getResources(), R.drawable.themoon);
        }

        protected void onDraw(Canvas canvas) {
            canvas.drawBitmap(bmMoon, x, y, new Paint());
            invalidate();
        }

    }
}
