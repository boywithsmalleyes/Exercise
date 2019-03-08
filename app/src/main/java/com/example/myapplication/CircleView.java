package com.example.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * @author root
 */
public class CircleView extends View {

    private static final String TAG = "CircleView";
    PointF point;
    Paint paint;

    public int color = 0xffff0000;

    {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);

        point = new PointF(100, 100);
    }

    public CircleView(Context context) {
        super(context);
    }

    public CircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PointF getPoint () {
        return point;
    }

    public void setPoint(PointF point) {
        this.point = point;
        invalidate();
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d(TAG, "onDraw: ");
        canvas.save();
        paint.setColor(color);
        canvas.drawCircle(point.x, point.y, 50, paint);
        canvas.restore();
    }
}
