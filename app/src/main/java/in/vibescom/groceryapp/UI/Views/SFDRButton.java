package in.vibescom.groceryapp.UI.Views;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

public class SFDRButton extends android.support.v7.widget.AppCompatButton {
    public SFDRButton(Context context) {
        super(context);
        createFont();
    }

    public SFDRButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        createFont();
    }



    public SFDRButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        createFont();
    }

    public void createFont() {
        Typeface font = Typeface.createFromAsset(getContext().getAssets(), "fonts/SanFranciscoText-Regular.otf");
        setTypeface(font);
    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        /*if(enabled){
            setBackground(getResources().getDrawable(R.drawable.canvas_theme_round_corner_btn));
        }else {
            setBackground(getResources().getDrawable(R.drawable.canvas_inactive_round_corner_btn));
        }*/

    }
}
