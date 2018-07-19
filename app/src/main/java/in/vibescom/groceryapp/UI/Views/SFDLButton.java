package in.vibescom.groceryapp.UI.Views;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

public class SFDLButton extends android.support.v7.widget.AppCompatButton {
    public SFDLButton(Context context) {
        super(context);
        createFont();
    }

    public SFDLButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        createFont();
    }


    @Override
    public void setEnabled(boolean enabled) {
        /*if(enabled){
            setBackgroundColor(getResources().getColor(R.color.theme_color));
        }else {
            setBackgroundColor(getResources().getColor(R.color.text_color_lite));
        }*/
        super.setEnabled(enabled);
    }

    public SFDLButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        createFont();
    }

    public void createFont() {
        Typeface font = Typeface.createFromAsset(getContext().getAssets(), "fonts/SanFranciscoDisplay-Light.otf");
        setTypeface(font);
    }


}
