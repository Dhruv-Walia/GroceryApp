package in.vibescom.groceryapp.UI.Views;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

public class SFDLCheckBox extends android.support.v7.widget.AppCompatCheckBox {
    public SFDLCheckBox(Context context) {
        super(context);
        createFont();
    }

    public SFDLCheckBox(Context context, AttributeSet attrs) {
        super(context, attrs);
        createFont();
    }



    public SFDLCheckBox(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        createFont();
    }

    public void createFont() {
        Typeface font = Typeface.createFromAsset(getContext().getAssets(), "fonts/SanFranciscoDisplay-Light.otf");
        setTypeface(font);
    }


}
