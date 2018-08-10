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


    TextView CreateAccount,ForgotPassword, title_signIn;
    TextInputLayout textInputLayout_1, textInputLayout_2;
    EditText Email,Password;
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
        CreateAccount = findViewById(R.id.tv_createAccount);
        SignIn = findViewById(R.id.btn_login);
        Password = findViewById(R.id.et_login_password);
        ForgotPassword = findViewById(R.id.tv_forgot_password);
        Email = findViewById(R.id.et_email_id);
        title_signIn = findViewById(R.id.tv_title_login);
        textInputLayout_1 = findViewById(R.id.tILayout2);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/deftone_stylus.ttf");
        title_signIn.setTypeface(typeface);


        textInputLayout_1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        // Show white background behind floating label
                        textInputLayout_1.setHintTextAppearance(R.style.textInputLayout);
                    }
                }, 100000);
            }
            }
        });

        //CreateAccount.setTranslationX(2f);

        CreateAccount.setOnClickListener(view -> {
            Intent cre_i = new Intent(SignInActivity.this,SignUpActivity.class);
            startActivity(cre_i);
        });

        Password.setOnTouchListener((v, event) -> {
            ForgotPassword.setVisibility(View.VISIBLE);
            return false;
        });


        SignIn.setOnClickListener(view -> {
            if( Email.getText().toString().length() == 0) {
                Email.setError("This field is required!");
                                                          }
            else if( Password.getText().toString().length() == 0)
            { textInputLayout_1.setError( "This field is required!" );

            }

            else{
                Intent signin = new Intent(SignInActivity.this,HomeActivity.class);
                startActivity(signin);
            }
        });

        ForgotPassword.setOnClickListener(view -> {
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
