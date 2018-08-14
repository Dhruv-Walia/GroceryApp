package in.vibescom.groceryapp.UI.Activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.ButterKnife;
import in.vibescom.groceryapp.R;

public class SignInActivity extends AppCompatActivity {


    TextView mCreateAccount, mForgotPassword, mTitleSignIn;
    TextInputLayout mTextInputLayout1, mTextInputLayout2;
    EditText mEmail, mPassword;
    Button SignIn;
    String m_org_str ;
    Spannable Span_ssBuilder;
//    @BindView(R.id.tv_createAccount)
  //  TextView tvCreateAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        ButterKnife.bind(this);
        mCreateAccount = findViewById(R.id.tv_createAccount);
        SignIn = findViewById(R.id.btn_login);
        mPassword = findViewById(R.id.et_login_password);
        mForgotPassword = findViewById(R.id.tv_forgot_password);
        mEmail = findViewById(R.id.et_email_id);
        mTitleSignIn = findViewById(R.id.tv_title_login);
        mTextInputLayout1 = findViewById(R.id.tILayout2);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/deftone_stylus.ttf");
        mTitleSignIn.setTypeface(typeface);


        mTextInputLayout1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        // Show white background behind floating label
                        mTextInputLayout1.setHintTextAppearance(R.style.textInputLayout);
                    }
                }, 100000);
            }
            }
        });

        //mCreateAccount.setTranslationX(2f);

        mCreateAccount.setOnClickListener(view -> {
            Intent cre_i = new Intent(SignInActivity.this,SignUpActivity.class);
            startActivity(cre_i);
        });

        mPassword.setOnTouchListener((v, event) -> {
            mForgotPassword.setVisibility(View.VISIBLE);
            return false;
        });


        SignIn.setOnClickListener(view -> {
            if( mEmail.getText().toString().length() == 0) {
                mEmail.setError("This field is required!");
                                                          }
            else if( mPassword.getText().toString().length() == 0)
            { mTextInputLayout1.setError( "This field is required!" );

            }

            else{
                Intent signin = new Intent(SignInActivity.this,HomeActivity.class);
                startActivity(signin);
            }
        });

        mForgotPassword.setOnClickListener(view -> {
            Intent for_i = new Intent(SignInActivity.this,ForgotPasswordActivity.class);
            startActivity(for_i);
        });

        /*ShowPassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

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
        });*/

    }
    //@OnClick(R.id.btn_login)
    //void loginButton(){

    //}
}
