package in.vibescom.groceryapp.UI.Views;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

public class SFDRTextView extends android.support.v7.widget.AppCompatTextView {
    public SFDRTextView(Context context) {
        super(context);
        createFont();
    }

    public SFDRTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        createFont();
    }



    public SFDRTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        createFont();
    }

    public void createFont() {
        Typeface font = Typeface.createFromAsset(getContext().getAssets(), "fonts/SanFranciscoText-Regular.otf");
        setTypeface(font);
    }


}
