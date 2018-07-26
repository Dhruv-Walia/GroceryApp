package in.vibescom.groceryapp.UI.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import in.vibescom.groceryapp.R;

public class AddressActivity extends AppCompatActivity {

    Button Submit;

    Spinner sector;
    String[] sec_array;
    String sec_string;
    ArrayAdapter<String> adapter1;

    Spinner TowerName;
    String[] apartment_array;
    ArrayAdapter<String> adapter2;

    Spinner AppartmentName;
    String[] locality_array;
    ArrayAdapter<String> adapter3;

    Spinner FlatNumber;
    String[] flat_num;
    ArrayAdapter<String> adapter4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
        sector = (Spinner)findViewById(R.id.spin_sector);
        TowerName = (Spinner)findViewById(R.id.spin_tower);
        AppartmentName = (Spinner)findViewById(R.id.spin_apartment);
        FlatNumber = (Spinner)findViewById(R.id.spin_flat_no);
        Submit = (Button) findViewById(R.id.btn_submit_addr);

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AddressActivity.this,"address submitted",Toast.LENGTH_SHORT).show();
            }
        });

        sector.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String sp1= String.valueOf(sector.getSelectedItem());
                if(sp1.contentEquals("Chhajarsi Colony")) {
                    TowerName.setVisibility(View.VISIBLE);
                    AppartmentName.setVisibility(View.VISIBLE);
                    FlatNumber.setVisibility(View.VISIBLE);
                    Submit.setVisibility(View.VISIBLE);
                    List<String> list = new ArrayList<String>();
                    list.add("Bahlolpur");
                    list.add("Bahlolpur1");
                    list.add("Bahlolpur2");
                    list.add("Sector 63");
                    
                    List<String> list_1 = new ArrayList<String>();
                    list_1.add("apartment1");
                    list_1.add("apartment2");
                    list_1.add("apartment3");
                    list_1.add("apartment4");

                    List<String> list_2 = new ArrayList<String>();
                    list_2.add("FlatNumber1");
                    list_2.add("FlatNumber2");
                    list_2.add("FlatNumber3");
                    list_2.add("FlatNumber4");
                    ArrayAdapter<String> dataAdapter_2 = new ArrayAdapter<String>(AddressActivity.this,
                            android.R.layout.simple_spinner_item, list_2);
                    dataAdapter_2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    dataAdapter_2.notifyDataSetChanged();  //to  alert changes to UI
                    FlatNumber.setAdapter(dataAdapter_2);


                    ArrayAdapter<String> dataAdapter_1 = new ArrayAdapter<String>(AddressActivity.this,
                            android.R.layout.simple_spinner_item, list_1);
                    dataAdapter_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    dataAdapter_1.notifyDataSetChanged();
                    AppartmentName.setAdapter(dataAdapter_1);
                    
                    ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(AddressActivity.this,
                            android.R.layout.simple_spinner_item, list);
                    dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    dataAdapter.notifyDataSetChanged();
                    TowerName.setAdapter(dataAdapter);
                }
               else if(sp1.contentEquals("Dadri Road")) {
                    TowerName.setVisibility(View.VISIBLE);
                    AppartmentName.setVisibility(View.VISIBLE);
                    FlatNumber.setVisibility(View.VISIBLE);
                    Submit.setVisibility(View.VISIBLE);
                    List<String> list = new ArrayList<String>();
                    list.add("Dadri Road 1");
                    list.add("Dadri Road 2");
                    list.add("Dadri Road 3");
                    list.add("Dadri Road 4");
                    ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(AddressActivity.this,
                            android.R.layout.simple_spinner_item, list);
                    dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    dataAdapter2.notifyDataSetChanged();
                    TowerName.setAdapter(dataAdapter2);
                }
            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
