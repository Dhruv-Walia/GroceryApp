package in.vibescom.groceryapp.UI.Activities;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
    }

    public  void  Onpress(View view) {

        if (view.getId() == R.id.b_log) {

            EditText a = (EditText) findViewById(R.id.et_user);
            String str = a.getText().toString();

            EditText b = (EditText) findViewById(R.id.et_pass);
            String pass = b.getText().toString();

            String password = helper.searchPass(str);
            if(pass.equals(password)) {

                Intent intent = new Intent("com.example.hp.login_form.Welcome");
                intent.putExtra("Username :", str);
                startActivity(intent);
            }else{
                Toast toast = Toast.makeText(MainActivity.this , "Username and Password don't match" , Toast.LENGTH_SHORT);
                toast.show();
            }

        }
        if(view.getId() == R.id.b_sign){
            startActivity(new Intent(this , signup.class));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
