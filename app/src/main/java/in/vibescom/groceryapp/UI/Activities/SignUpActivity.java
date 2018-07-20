package in.vibescom.groceryapp.UI.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import in.vibescom.groceryapp.R;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Button auser = findViewById(R.id.a_user);
        Button signup = findViewById(R.id.signUpBtn);
        EditText u_full_name = findViewById(R.id.fullName);
        EditText u_email = findViewById(R.id.userEmailId);
        EditText u_number = findViewById(R.id.mobileNumber);
        EditText u_location = findViewById(R.id.location);
        EditText u_password = findViewById(R.id.password);
        EditText u_confirm = findViewById(R.id.confirmPassword);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( u_full_name.getText().toString().length() == 0 )
                    u_full_name.setError( "This field is required!" );

                else if( u_password.getText().toString().length() == 0 )
                    u_password.setError( "This field is required!" );

                else if( u_email.getText().toString().length() == 0 )
                    u_email.setError( "This field is required!" );

                else if( u_number.getText().toString().length() == 0 )
                    u_number.setError( "This field is required!" );

                else if( u_location.getText().toString().length() == 0 )
                    u_location.setError( "This field is required!" );

                else if( u_confirm.getText().toString().length() == 0 )
                    u_confirm.setError( "This field is required!" );

                else{
                    Intent signup = new Intent(SignUpActivity.this,SignInActivity.class);
                    startActivity(signup);
                }
            }
        });

        auser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a_i = new Intent(SignUpActivity.this,HomeActivity.class);
                startActivity(a_i);
            }
        });

    }

}
