package in.vibescom.groceryapp.UI.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        Button auser = findViewById(R.id.a_user);
        Button signup = findViewById(R.id.signUpBtn);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SignUpActivity.this,"you are signed in", Toast.LENGTH_SHORT).show();
            }
        });

        auser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a_i = new Intent(SignUpActivity.this,MainActivity.class);
                startActivity(a_i);
            }
        });
    }

}
