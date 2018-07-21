package in.vibescom.groceryapp.UI.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import in.vibescom.groceryapp.R;

public class SignUpActivity extends AppCompatActivity {

    Button existing_user_btn,Signup;
    EditText Fullname, EmailId,MobileNumber,Location,Password,Confirm_Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        existing_user_btn= findViewById(R.id.btn_existing_user);

        Signup = findViewById(R.id.btn_signUp);
        Fullname = findViewById(R.id.et_fullName);
        EmailId = findViewById(R.id.et_userEmailId);
        MobileNumber = findViewById(R.id.et_mobileNumber);
        Location = findViewById(R.id.et_location);
        Password = findViewById(R.id.et_password);
        Confirm_Password = findViewById(R.id.et_confirmPassword);

        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( Fullname.getText().toString().length() == 0 )
                    Fullname.setError( "This field is required!" );

                else if( Password.getText().toString().length() == 0 )
                    Password.setError( "This field is required!" );

                else if( EmailId.getText().toString().length() == 0 )
                    EmailId.setError( "This field is required!" );

                else if( MobileNumber.getText().toString().length() == 0 )
                    MobileNumber.setError( "This field is required!" );

                else if( Location.getText().toString().length() == 0 )
                    Location.setError( "This field is required!" );

                else if( Confirm_Password.getText().toString().length() == 0 )
                    Confirm_Password.setError( "This field is required!" );

                else{
                    Intent signup = new Intent(SignUpActivity.this,SignInActivity.class);
                    startActivity(signup);
                }
            }
        });

        existing_user_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a_i = new Intent(SignUpActivity.this,HomeActivity.class);
                startActivity(a_i);
            }
        });

    }

}
