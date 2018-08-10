package in.vibescom.groceryapp.UI.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import in.vibescom.groceryapp.R;

public class ForgotPasswordActivity extends AppCompatActivity {

    EditText etOldPassword, etNewPassword, etConfirmPassword;
    Button update;
    String pass,confirm_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        etOldPassword = findViewById(R.id.et_old_password);
        etNewPassword = findViewById(R.id.et_new_password);
        etConfirmPassword = findViewById(R.id.et_confirmed_password);
        update = findViewById(R.id.btn_update);

        pass = etNewPassword.getText().toString();
        confirm_pass = etConfirmPassword.getText().toString();
        //Log.e(pass,"Print password");
        //Log.e(confirm_pass,"confirm password");

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etOldPassword.getText().toString().length() == 0)
                    etOldPassword.setError("This field is required!");

                else if (etNewPassword.getText().toString().length() == 0)
                    etNewPassword.setError("This field is required!");

                else if (etConfirmPassword.getText().toString().length() == 0)
                    etConfirmPassword.setError("This field is required!");

                else {
                    if (confirm_pass.equals(pass)) {
                        Toast.makeText(ForgotPasswordActivity.this,"password matches",Toast.LENGTH_LONG).show();
                    }

                    else if(!(confirm_pass.equals(pass))){Toast.makeText(ForgotPasswordActivity.this,"password does not match",Toast.LENGTH_SHORT).show();}

                    Toast.makeText(ForgotPasswordActivity.this, "password Updated successfully", Toast.LENGTH_SHORT).show();
                }
            }
            });

    }
}