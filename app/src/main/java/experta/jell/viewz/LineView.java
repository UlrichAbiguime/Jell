package experta.jell.viewz;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import experta.jell.commonLogs.L;

/**
 * Created by ulrich on 15-9-14.
 */
public class LineView extends View {

    public int top, left, right, bottom;
    Paint paint;


    private void paintInit() {

        paint = new Paint();
      /*  paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(4);
        paint.setColor(Color.WHITE);
        left = getPaddingLeft();
        top = getPaddingTop();
        right = getWidth() - getPaddingRight();
        bottom = getHeight() - getPaddingBottom();*/
    }

    public LineView(Context context) {
        super(context);
        paintInit ();
    }

    public LineView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paintInit();
    }

    public LineView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paintInit();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public LineView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        paintInit();
    }



    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(1);
        paint.setColor(Color.WHITE);
        left = getPaddingLeft();
        top = getPaddingTop();
        right = getWidth() - getPaddingRight();
        bottom = getHeight() - getPaddingBottom();
        // we draw on the canvas.
        canvas.drawLine(top, left, right, bottom, paint);
    }
}
