package com.example.myapplication;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author root
 */
public class CameraView extends View {

    private Camera camera = new Camera();
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public CameraView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    {
        camera.rotateX(30);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.translate(100,100);
        camera.applyToCanvas(canvas);
        canvas.translate(-100, -100);
        canvas.drawBitmap(getAvator(100), 100, 100, paint);
    }


    private Bitmap getAvator(int outWidth) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.outWidth = outWidth;
        options.outHeight = outWidth;
        return BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher, options);
    }
}
