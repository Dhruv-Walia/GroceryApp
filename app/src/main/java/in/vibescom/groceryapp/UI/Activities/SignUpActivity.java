package in.vibescom.groceryapp.UI.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import in.vibescom.groceryapp.R;


public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Toast.makeText(this, "SignUp Activity", Toast.LENGTH_SHORT).show();
    }
}
