package in.vibescom.groceryapp.UI.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import in.vibescom.groceryapp.R;

public class SignInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        Toast.makeText(this, "Signin Activity", Toast.LENGTH_SHORT).show();
    }

}
