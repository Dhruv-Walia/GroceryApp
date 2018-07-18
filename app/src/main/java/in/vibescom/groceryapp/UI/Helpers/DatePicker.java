package in.vibescom.groceryapp.UI.Helpers;

import android.app.DatePickerDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class DatePicker {
    private static DatePicker mInstance;
    private Context context;
    private DateSetListener dateSetListener;
    private int type;

    private DatePicker(Context context, int type , DateSetListener dateSetListener) {
        this.context = context;
        this.dateSetListener = dateSetListener;
        this.type = type;
    }

    public static synchronized DatePicker getInstance(Context context, int type, DateSetListener dateSetListener) {
        if(mInstance == null){
            mInstance = new DatePicker(context, type, dateSetListener);
        }
        return mInstance;
    }

    private static SimpleDateFormat getSimpleDateFormat() {
        return new SimpleDateFormat("MMM, dd, yyyy", Locale.UK);
    }

    private DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(android.widget.DatePicker view, int year, int month, int dayOfMonth) {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, month, dayOfMonth);
            String date = getSimpleDateFormat().format(newDate.getTime());
            dateSetListener.onDateSet(date);
        }
    };

    private DatePickerDialog getDatePickerDialog() {
        Calendar newCalendar = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(context, onDateSetListener, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DATE));
        long now = System.currentTimeMillis();
        if(type==1){
            long limit = now - 410227200000L;//for 13 year back set max date
            datePickerDialog.getDatePicker().setMaxDate(limit);
        }else
            datePickerDialog.getDatePicker().setMinDate(now - 50000);
        return datePickerDialog;
    }

    public interface DateSetListener {
        void onDateSet(String date);
    }

    public void showDatePickDialog() {
        if(!((AppCompatActivity)context).isFinishing()){
            getDatePickerDialog().show();
        }
    }


}

