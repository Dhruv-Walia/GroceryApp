package in.vibescom.groceryapp.UI.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import in.vibescom.groceryapp.R;


public class HomeActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toast.makeText(HomeActivity.this,"Home Activity",Toast.LENGTH_SHORT).show();
    }
}
