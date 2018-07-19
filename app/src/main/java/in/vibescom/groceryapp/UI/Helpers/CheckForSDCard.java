package in.vibescom.groceryapp.UI.Helpers;

import android.os.Environment;

public class CheckForSDCard {
    public static String filepath="";
    //Check If SD Card is present or not method
    public boolean isSDCardPresent() {
        if (Environment.getExternalStorageState().equals(

                Environment.MEDIA_MOUNTED)) {
            return true;
        }
        return false;
    }
}
