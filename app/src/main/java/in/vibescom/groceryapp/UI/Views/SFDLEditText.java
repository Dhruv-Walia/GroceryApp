package in.vibescom.groceryapp.UI.Views;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

public class SFDLEditText extends android.support.v7.widget.AppCompatEditText {
    public SFDLEditText(Context context) {
        super(context);
        createFont();
    }

    public SFDLEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        createFont();
    }



    public SFDLEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        createFont();
    }

    public void createFont() {
        Typeface font = Typeface.createFromAsset(getContext().getAssets(), "fonts/SanFranciscoDisplay-Light.otf");
        setTypeface(font);
    }


}
