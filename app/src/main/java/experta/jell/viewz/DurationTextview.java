package experta.jell.viewz;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.text.Html;
import android.util.AttributeSet;
import android.widget.TextView;

import experta.jell.R;
import experta.jell.commonLogs.L;

/**
 * Created by ulrich on 15-9-14.
 */


public class DurationTextview extends TextView {

    public DurationTextview(Context context) {
        super(context);
    }

    public DurationTextview(Context context, AttributeSet attrs) {
        super(context, attrs);
        getTemplate(context, attrs);
    }

    public DurationTextview(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        getTemplate(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public DurationTextview(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private void getTemplate(Context context, AttributeSet attrs) {

        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.TemplateTextview);
        String template = attributes.getString(R.styleable.TemplateTextview_template);
//        L.d(template == null ? "null" : template);
        if (template == null || !template.contains("%s")) {
            template = "%s";
        }
        TEMPLATE = template;
        attributes.recycle();
    }

    public static String TEMPLATE = "Duration: <strong>%s</strong>";
    public void setDuration (int sec) {

        // we have a template.
        String hoursText = "", minutesText = "", synthez = "";

        if (sec < 60) {
            synthez = "less than one minute";
            synthez = String.format(TEMPLATE, synthez);
            setText(Html.fromHtml(synthez)+".", BufferType.SPANNABLE);
            return;
        }

        if (sec >= 3600) {
            hoursText += sec/3600+" Hour";
            if (sec/3600 > 1) {
                hoursText+="s";
            }
            hoursText+=" ";
        }
        if (((sec%3600)/ 60) > 0) {
            minutesText+= ((sec%3600)/ 60)+ " minute";
            if (((sec%3600)/ 60 ) > 1) {
                minutesText+="s";
            }
            minutesText+=" ";
        }
        synthez = hoursText+minutesText;
        synthez = String.format(TEMPLATE, synthez);
        setText(Html.fromHtml(synthez)+".", BufferType.SPANNABLE);
    }

}
