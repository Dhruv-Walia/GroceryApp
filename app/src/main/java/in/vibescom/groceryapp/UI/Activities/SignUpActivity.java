package in.vibescom.groceryapp.UI.Activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import in.vibescom.groceryapp.R;

public class SignUpActivity extends AppCompatActivity {

    Spinner spinner_sector,spinner_apartment;
    Button signUp;
    TextView existingUser,signUpLabel;
    EditText fullName, emailId, mobileNumber, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        existingUser= findViewById(R.id.tv_existing_user);

        spinner_sector = findViewById(R.id.spin_sector);
        spinner_apartment = findViewById(R.id.spin_apartment);
        signUp = findViewById(R.id.btn_signUp);
        fullName = findViewById(R.id.et_fullName);
        emailId = findViewById(R.id.et_userEmailId);
        mobileNumber = findViewById(R.id.et_mobileNumber);
        password = findViewById(R.id.et_password);

        existingUser = findViewById(R.id.tv_existing_user);
        signUpLabel = findViewById(R.id.sign_up_title);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/deftone_stylus.ttf");
        signUpLabel.setTypeface(typeface);

        //org_str = existingUser.getText().toString();

//        SpannableStringBuilder iBuilder = new SpannableStringBuilder(org_str);

        /*iBuilder.setSpan(new RelativeSizeSpan(1.4f), 15,21, 0);

        iBuilder.setSpan(
                new ForegroundColorSpan(Color.WHITE),
                org_str.indexOf("Already a user!"),
                org_str.indexOf("Already a user!") + String.valueOf("Already a user!").length(),
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        );

        iBuilder.setSpan(new StyleSpan(Typeface.BOLD), 0, 15,  Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        iBuilder.setSpan(new RelativeSizeSpan(0.8f), 0,15, 0);
        iBuilder.setSpan(
                new ForegroundColorSpan(Color.WHITE),
                org_str.indexOf("LogIn"),
                org_str.indexOf("LogIn") + String.valueOf("LogIn").length(),
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        );

        existingUser.setText(iBuilder);
*/
        signUp.setOnClickListener(view -> {
            if( fullName.getText().toString().length() == 0 )
                fullName.setError( "This field is required!" );

            else if( password.getText().toString().length() == 0 )
                password.setError( "This field is required!" );

            else if( emailId.getText().toString().length() == 0 )
                emailId.setError( "This field is required!" );

            else if( mobileNumber.getText().toString().length() == 0 )
                mobileNumber.setError( "This field is required!" );

            else{
                Intent signup = new Intent(SignUpActivity.this,SignInActivity.class);
                startActivity(signup);
            }
        });

        existingUser.setOnClickListener(view -> {
            Intent a_i = new Intent(SignUpActivity.this,SignInActivity.class);
            startActivity(a_i);
        });

    }

}
