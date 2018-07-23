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


    TextView CreateAccount,ForgotPassword;
    EditText Email,Password;
    Button SignIn;
    CheckBox ShowPassword;
    String m_org_str ;
    Spannable Span_ssBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        CreateAccount = findViewById(R.id.tv_createAccount);
        SignIn = findViewById(R.id.btn_login);
        Password = findViewById(R.id.et_login_password);
        ForgotPassword = findViewById(R.id.tv_forgot_password);
        ShowPassword = findViewById(R.id.ck_show_hide_password);
        Email = findViewById(R.id.et_emailid);

        m_org_str=CreateAccount.getText().toString();

        CreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cre_i = new Intent(SignInActivity.this,SignUpActivity.class);
                startActivity(cre_i);
            }
        });

        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( Email.getText().toString().length() == 0 )
                    Email.setError( "This field is required!" );

                else if( Password.getText().toString().length() == 0 )
                    Password.setError( "This field is required!" );

                else{
                    Intent signin = new Intent(SignInActivity.this,HomeActivity.class);
                    startActivity(signin);
                }
            }
        });

        SpannableStringBuilder ssBuilder = new SpannableStringBuilder(m_org_str);

        ssBuilder.setSpan(new RelativeSizeSpan(1.7f), 20,27, 0);

        ssBuilder.setSpan(
                new ForegroundColorSpan(Color.BLACK),
                m_org_str.indexOf("Do not have account?"),
                m_org_str.indexOf("Do not have account?") + String.valueOf("Do not have account?").length(),
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        );

        ssBuilder.setSpan(new StyleSpan(Typeface.ITALIC), 0, 22,  Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ssBuilder.setSpan(new RelativeSizeSpan(1.4f), 0,21, 0);
        ssBuilder.setSpan(
                new ForegroundColorSpan(Color.BLUE),
                m_org_str.indexOf("SignUp"),
                m_org_str.indexOf("SignUp") + String.valueOf("SignUp").length(),
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        );


        CreateAccount.setText(ssBuilder);

        ForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent for_i = new Intent(SignInActivity.this,ForgotPasswordActivity.class);
                startActivity(for_i);
            }
        });

        ShowPassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // checkbox status is changed from uncheck to checked.
                if (!isChecked) {
                    // show password
                    Password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                } else {
                    // hide password
                    Password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
            }
        });

    }

}
