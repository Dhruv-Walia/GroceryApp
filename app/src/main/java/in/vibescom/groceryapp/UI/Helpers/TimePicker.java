package in.vibescom.groceryapp.UI.Helpers;

import android.app.TimePickerDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import java.util.Calendar;

public class TimePicker {

    private Context context;
    private TimeSetListener timeSetListener;

    private TimePicker(Context context, TimeSetListener timeSetListener) {
        this.context = context;
        this.timeSetListener = timeSetListener;
    }

    public static TimePicker getInstance(Context context, TimeSetListener timeSetListener) {
        return new TimePicker(context, timeSetListener);
    }

    private TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(android.widget.TimePicker view, int hourOfDay, int minute) {
            String time;
            time = hourOfDay+":"+minute;
            /*if(hourOfDay>12){
                int hour = hourOfDay - 12;
                time = hour+":"+minute+" PM";
            }
            else if(hourOfDay==12)
                time = hourOfDay+":"+minute+" PM";
            else
                time = hourOfDay+":"+minute+" AM";*/
            timeSetListener.onTimeSet(time);
        }
    };

    private TimePickerDialog getTimePickerDailog(){
        Calendar newCalendar = Calendar.getInstance();
        return new TimePickerDialog(context,onTimeSetListener,newCalendar.get(Calendar.HOUR_OF_DAY),newCalendar.get(Calendar.MINUTE),true);
    }

    public interface TimeSetListener {
        void onTimeSet(String date);
    }

    public void showTimePickDialog() {
        if(!((AppCompatActivity)context).isFinishing()){
            getTimePickerDailog().show();
        }
    }
}
