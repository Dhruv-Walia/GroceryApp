package in.vibescom.groceryapp.UI.Activities;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class signup extends Activity {

    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
    }

    public  void Onsignup(View view){
        if(view.getId() == R.id.b_signin) {
            EditText name = (EditText) findViewById(R.id.tf_name);
            EditText email = (EditText) findViewById(R.id.tf_email);
            EditText uname = (EditText) findViewById(R.id.tf_uname);
            EditText pass1 = (EditText) findViewById(R.id.tf_pass1);
            EditText pass2 = (EditText) findViewById(R.id.tf_pass2);

            String str1 = name.getText().toString();
            String str2 = email.getText().toString();
            String str3 = uname.getText().toString();
            String strpass1 = pass1.getText().toString();
            String strpass2 = pass2.getText().toString();

            if(!strpass1.equals(strpass2)){
                Toast toast = Toast.makeText(signup.this , "Password is incorrect" , Toast.LENGTH_SHORT);
                toast.show();
            }
            else{//INSERT INTO DATABASE
                Contact c = new Contact();
                c.setName(str1);
                c.setEmail(str2);
                c.setUname(str3);
                c.setPass(strpass1);

                helper.insertContact(c);
            }
        }
    }


}
