package in.vibescom.groceryapp.UI.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import in.vibescom.groceryapp.R;

public class MainActivity extends AppCompatActivity {

    TextView create,forgot;
    Button sign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        create = findViewById(R.id.createAccount);
        sign = findViewById(R.id.loginBtn);
        forgot = findViewById(R.id.forgot_password);

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cre_i = new Intent(MainActivity.this,SignUpActivity.class);
                startActivity(cre_i);
            }
        });

        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"you are logged into the activity", Toast.LENGTH_LONG).show();
            }
        });

        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent for_i = new Intent(MainActivity.this,SignUpActivity.class);
                startActivity(for_i);
            }
        });
    }
}
