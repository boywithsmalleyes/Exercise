package com.example.myapplication;

import android.animation.TypeEvaluator;
import android.graphics.PointF;

/**
 * @author root
 */
public class PointEvaluator implements TypeEvaluator<PointF> {
    private PointF newPoint = new PointF();

    @Override
    public PointF evaluate(float fraction, PointF startValue, PointF endValue) {
        float x = startValue.x + fraction * (endValue.x - startValue.x);
        float y = startValue.y + fraction * (endValue.y - startValue.y);
        newPoint.set(x, y);
        return newPoint;
    }
}
