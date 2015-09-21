package experta.jell.activityz;

import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;

import butterknife.Bind;
import butterknife.ButterKnife;
import experta.jell.R;
import experta.jell.commonLogs.L;
import experta.jell.viewz.AbPager;

public class PagerActivity extends AppCompatActivity implements
        GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener{

    private GestureDetectorCompat mDetector;

    // viewz
    @Bind(R.id.pager)
    AbPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager);
        ButterKnife.bind(this);
        mDetector = new GestureDetectorCompat(this, this);
        mDetector.setOnDoubleTapListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pager, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.mDetector.onTouchEvent(event);
// always need to call the superclass implementation.
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        L.d("onSingleTapConfirmed: "+e.toString());
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        L.d("onDoubleTap: "+e.toString());
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        L.d("onDoubleTapEvent: "+e.toString());
        return true;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        L.d("onDown: "+e.toString());
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        L.d("onShowPress: "+e.toString());
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        L.d("onSingleTapUp: "+e.toString());
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        L.d("onScroll: "+"motion1 "+e1.toString()+" motion2 "+e2.toString()+
                "\n\t\t"+"distanceX "+distanceX+" distanceY "+distanceY);
        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        L.d("onLongPress: "+e.toString());
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        L.d("onFling: " + e1.toString() + e2.toString() +
                "\n\t\t"+"velocityX "+velocityX+" velocityY "+velocityY);
        return true;
    }
}
