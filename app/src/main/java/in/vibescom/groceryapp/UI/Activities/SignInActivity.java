package in.vibescom.groceryapp.UI.Activities;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import in.vibescom.groceryapp.R;

public class SignInActivity extends AppCompatActivity {


    TextView create,forgot;
    EditText email_id,password;
    Button sign;
    CheckBox check;
    String org_str ;
    Spannable ssBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        create = findViewById(R.id.createAccount);
        sign = findViewById(R.id.loginBtn);
        password = findViewById(R.id.login_password);
        forgot = findViewById(R.id.forgot_password);
        check = findViewById(R.id.show_hide_password);
        email_id = findViewById(R.id.login_emailid);

        org_str=create.getText().toString();

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cre_i = new Intent(SignInActivity.this,SignUpActivity.class);
                startActivity(cre_i);
            }
        });

        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( email_id.getText().toString().length() == 0 )
                    email_id.setError( "This field is required!" );

                else if( password.getText().toString().length() == 0 )
                    password.setError( "This field is required!" );

                else{
                    Intent signin = new Intent(SignInActivity.this,HomeActivity.class);
                    startActivity(signin);
                }
            }
        });

        SpannableStringBuilder ssBuilder = new SpannableStringBuilder(org_str);

        ssBuilder.setSpan(new RelativeSizeSpan(1.7f), 20,27, 0);

        ssBuilder.setSpan(
                new ForegroundColorSpan(Color.BLACK),
                org_str.indexOf("Do not have account?"),
                org_str.indexOf("Do not have account?") + String.valueOf("Do not have account?").length(),
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        );

        ssBuilder.setSpan(new StyleSpan(Typeface.ITALIC), 0, 22,  Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ssBuilder.setSpan(new RelativeSizeSpan(1.4f), 0,21, 0);
        ssBuilder.setSpan(
                new ForegroundColorSpan(Color.BLUE),
                org_str.indexOf("SignUp"),
                org_str.indexOf("SignUp") + String.valueOf("SignUp").length(),
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        );


        create.setText(ssBuilder);
        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent for_i = new Intent(SignInActivity.this,SignUpActivity.class);
                startActivity(for_i);
            }
        });

        check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // checkbox status is changed from uncheck to checked.
                if (!isChecked) {
                    // show password
                    password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                } else {
                    // hide password
                    password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
            }
        });

    }

}
