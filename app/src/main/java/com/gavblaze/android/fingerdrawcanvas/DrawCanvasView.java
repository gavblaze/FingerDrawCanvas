package com.gavblaze.android.fingerdrawcanvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.support.v4.content.res.ResourcesCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class DrawCanvasView extends View {
    private Paint mPaint;
    private Path mPath;
    private float mCx, mCy;
    private int mBackGroundColor;
    private int mDrawColor;


    public DrawCanvasView(Context context) {
        super(context);
        init();
    }

    public DrawCanvasView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DrawCanvasView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    public void init() {

        mBackGroundColor = ResourcesCompat.getColor(getResources(), R.color.opaque_orange, null);
        mDrawColor = ResourcesCompat.getColor(getResources(), R.color.opaque_yellow, null);

        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(mDrawColor);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(12);

        mPath = new Path();

        setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                mCx = event.getX();
                mCy = event.getY();

                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        mPath.moveTo(mCx, mCy);
                        break;
                    case MotionEvent.ACTION_MOVE:
                        v.performClick();
                        mPath.lineTo(mCx, mCy);
                        invalidate();
                        break;
                    default:
                        //do nothing
                }
                return true;
            }
        });
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(mBackGroundColor);
        canvas.drawPath(mPath, mPaint);
    }
}
