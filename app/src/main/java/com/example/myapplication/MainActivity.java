package com.example.myapplication;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.graphics.PointF;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

/**
 * @author root
 */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    CircleView circleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        circleView = findViewById(R.id.cv_circle_view);
    }

    public void clickMe(View view) {

//        Log.d(TAG, "clickMe: ");
//        ObjectAnimator objectAnimator = ObjectAnimator.ofInt(circleView, "color", 0xffff0000, 0xff00ff00);
//        objectAnimator.setEvaluator(new ArgbEvaluator());
//        objectAnimator.start();
        ObjectAnimator animator =
                ObjectAnimator.ofObject(circleView, "point",
                        new PointEvaluator(), new PointF(100, 100), new PointF(200, 200));
        animator.start();
    }
}
