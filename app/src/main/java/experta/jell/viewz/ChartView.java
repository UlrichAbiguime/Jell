package experta.jell.viewz;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AnimationUtils;

import experta.jell.utilz.Dynamics;

/**
 * Created by ulrich on 15-9-14.
 *
 *
 * A view in charge of drawing a chart using the float
 * values given to it in params.
 */
public class ChartView extends View {

    Paint paint;
    private Dynamics[] datapoints;

    private void init() {
        paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(3);
        paint.setColor(Color.WHITE);
    }

    public ChartView(Context context) {
        super(context);
        init();
    }

    public ChartView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ChartView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ChartView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    public void setChartData (Dynamics[] newDatapoints) {
       /* this.data = data.clone();
        invalidate();*/
        long now = AnimationUtils.currentAnimationTimeMillis();
        if (datapoints == null || datapoints.length != newDatapoints.length) {
            datapoints = new Dynamics[newDatapoints.length];
            for (int i = 0; i < newDatapoints.length; i++) {
                datapoints[i] =  new Dynamics(40, 0.8f);
                datapoints[i].setPosition(newDatapoints[i].getTargetPos(), now);
                datapoints[i].setTargetPosition (newDatapoints[i].getTargetPos(), now);
            }
            invalidate();
        } else {
            for (int i = 0; i < newDatapoints.length; i++) {
                datapoints[i].setTargetPosition (newDatapoints[i].getTargetPos(), now);
            }
            removeCallbacks(animator);
            post (animator);
        }
    }

    private Runnable animator = new Runnable() {
        @Override
        public void run() {
            boolean sheduleNewFrame  = false;
            long now = AnimationUtils.currentAnimationTimeMillis();
            for (Dynamics datapoint : datapoints) {
                datapoint.update(now);
                if (!datapoint.isAtRest()) {
                    sheduleNewFrame = true;
                }
            }
            if (sheduleNewFrame) {
                postDelayed(this, 15);
            }
            invalidate();
        }
    };


    public float getPosY (float value, float maxValue) {

        float height = getHeight() - getPaddingTop() - getPaddingBottom();
        // scale it down.
        value = (value / maxValue) * height; // scale it up or down.
        value = height - value;  // renverse it.
        value+=getPaddingTop();    // offset for padding
        return value;
    }


    @Override
    protected void onDraw(Canvas canvas) {

//        super.onDraw(canvas);
        float maxPoint = getMax (datapoints);
        Path pathLine = new Path();
        pathLine.moveTo(getPosX(0), getPosY(datapoints[0].getPosition(), maxPoint));
        for (int i = 1; i < datapoints.length; i++) {
            pathLine.lineTo(getPosX(i), getPosY(datapoints[i].getPosition(), maxPoint));
        }
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(2);
        paint.setColor(Color.WHITE);
        paint.setAntiAlias(true);
        paint.setShadowLayer(4, 2, 2, 0x80000000);
        /*rounded path*/
        paint.setDither(true);                    // set the dither to true
        paint.setStrokeJoin(Paint.Join.ROUND);    // set the join to round you want
        paint.setStrokeCap(Paint.Cap.ROUND);      // set the paint cap to round too
        paint.setPathEffect(new CornerPathEffect(10));
        canvas.drawPath(pathLine, paint);

        // save... scale down ... restore

    }

    private float getPosX(int index) {

        float width = getWidth() - getPaddingLeft() - getPaddingRight();
        float section = width / (datapoints.length-1);
        float posX = (index)*section;
        posX += getPaddingLeft();
        return posX;
    }

    private float getMax(Dynamics[] data) {
        float max = 0;
        for (Dynamics d: data) {
            if (d.getPosition() > max)
                max = d.getPosition();
        }
        return max;
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int size = 0;
        int width = getMeasuredWidth();
        int height = getMeasuredHeight();
        if (width == height) {
            size = height;
        } else {
            size = width;
        }
        setMeasuredDimension(size, size);
    }
}
