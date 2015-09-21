package experta.jell.viewz;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

import experta.jell.commonLogs.L;

/**
 * Created by ulrich on 15-9-15.
 *
 * things that need to be implemented.
 *
 * - snapping from one page to another one.
 * - the fact that i can take use of the inherent to android
 *      viewz, just like a scrollview...
 * - but when the scrollview get to it's bottom and then,
 *      the user keep scrolling... snap to the next page.
 *
 * - CAN WE SPECIFY SIZE OF THE CONTENT OF A PARENT？
 *  IF IT IS THE CASE， THEN SPECIFY IT， AND WHEN
 *  THE USER SCROLLZ TO THE BOTTOM， FINISH WITH IT BY
 *  SNAPPING TO THE NEXT PAGE。
 *
 *
 * - what i want to do it send different kind of actions
 * to the child and to the parent under different condi-
 * tions.
 */


public class AbPager extends ScrollView {

    public AbPager(Context context) {
        super(context);
    }

    public AbPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AbPager(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public AbPager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
    }

   /* @Override
    public boolean onTouchEvent(MotionEvent event) {

        int action = MotionEventCompat.getActionMasked(event);
        switch (action){
            case MotionEvent.ACTION_DOWN:
                L.d("action down");
                return true;
            case MotionEvent.ACTION_MOVE:
                L.d("action move");
                return true;
            case MotionEvent.ACTION_UP:
                L.d("action up");
                return true;
            case MotionEvent.ACTION_CANCEL:
                L.d("action cancel");
                return true;
            case MotionEvent.ACTION_OUTSIDE:
                L.d("action outside");
                return true;
            default:
                super.onTouchEvent(event);
                break;
        }
        return super.onTouchEvent(event);
    }
*/

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return super.onInterceptTouchEvent(ev);
        /* je vais pas me fatiguer a faire du design. je vais plutot me
        * concentrer sur le sys, c'est le plus important.
        *
        * - ya les samples que je peux pas recuperer actuellement et qui me
        * posent un super problem. mais bon, on va gerer.*/
    }


    /*1- step, put viewz inside the viewgroup according to their
    * matchparent size, and then, make it scroll
    *
    *
    * 2- learn to snapp from one position to another one using options.
    *
    *
    * 3- finalize stuffs. */

    /*
    *
    * - an abpager is something that should really be thought before doing,
    *   something you can only succeed after more and more practicing, because
    *   you need to know what to keep in memory and what to let.
    * */

}
