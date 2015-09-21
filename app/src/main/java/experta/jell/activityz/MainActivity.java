package experta.jell.activityz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import experta.jell.R;
import experta.jell.utilz.Dynamics;
import experta.jell.viewz.ChartView;
import experta.jell.viewz.DurationTextview;


public class MainActivity extends AppCompatActivity {

    private static final int MAX = 100;
    @Bind(R.id.chartview_annimated)
    ChartView chartViewAnimated;
    @Bind(R.id.chartview) ChartView chartView;
    private Dynamics[][] chartValz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        // make a custom view that inherit from view group
        // and take advantages of its features.
        DurationTextview tv1 = (DurationTextview) findViewById(R.id.durationtextview1);
        tv1.setDuration(25);
        DurationTextview tv2 = (DurationTextview) findViewById(R.id.durationtextview2);
        tv2.setDuration(78);
        DurationTextview tv3 = (DurationTextview) findViewById(R.id.durationtextview3);
        tv3.setDuration(2378);
        DurationTextview tv4 = (DurationTextview) findViewById(R.id.durationtextview4);
        tv4.setDuration(3670);
        DurationTextview tv5 = (DurationTextview) findViewById(R.id.durationtextview5);
        tv5.setDuration(18550);


        // chartview
        chartView.setChartData(getRandomFloatData()[0]);
        chartViewAnimated.setChartData(getRandomFloatData()[0]);

    }

    private static final int chartPics = 10;
//    private float[] walking_, running_, cycling_;

    private Dynamics[][] getRandomFloatData() {
        chartValz = new Dynamics[3][chartPics];
        Random random = new Random(System.currentTimeMillis());
        for (int j = 0; j < 3; j++)
            for (int i = 0; i < chartPics; i++) {
                chartValz[j][i] = new Dynamics(random.nextInt(MAX));
                while (chartValz[j][i].getPosition() < 0)
                    chartValz[j][i] = new Dynamics(random.nextInt(MAX));
                // scale it.
//                L.d("randomfloat "+ chartValz[j][i]);
            }
        return chartValz;
    }


    @OnClick (R.id.walking)
    public void walking () {
        if (chartValz == null)
            chartViewAnimated.setChartData(getRandomFloatData()[0]);
        else
            chartViewAnimated.setChartData(chartValz[0]);
    }

    @OnClick (R.id.running)
    public void running () {
        if (chartValz == null)
            chartViewAnimated.setChartData(getRandomFloatData()[1]);
        else
            chartViewAnimated.setChartData(chartValz[1]);
    }

    @OnClick (R.id.cycling)
    public void cycling () {
        if (chartValz == null)
            chartViewAnimated.setChartData(getRandomFloatData()[2]);
        else
            chartViewAnimated.setChartData(chartValz[2]);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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


}
