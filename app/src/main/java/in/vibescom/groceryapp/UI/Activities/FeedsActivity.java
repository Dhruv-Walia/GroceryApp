package in.vibescom.groceryapp.UI.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Arrays;

import in.vibescom.groceryapp.R;
import in.vibescom.groceryapp.UI.Adapters.FeedsAdapter;

public class FeedsActivity extends AppCompatActivity {

    Button Add2Card;

    // ArrayList for person names
    ArrayList<String> personNames = new ArrayList<>
            (Arrays.asList( "Person 1",
                    "Person 2",
                    "Person 3",
                    "Person 4",
                    "Person 5",
                    "Person 6",
                    "Person 7",
                    "Person 8",
                    "Person 9",
                    "Person 10",
                    "Person 11",
                    "Person 12",
                    "Person 13",
                    "Person 14"));

    ArrayList<Integer> personImages = new ArrayList<>
            (Arrays.asList( R.drawable.person1,
                    R.drawable.person2,
                    R.drawable.person3,
                    R.drawable.person4,
                    R.drawable.person5,
                    R.drawable.person6,
                    R.drawable.person7,

                    R.drawable.person1,
                    R.drawable.person2,
                    R.drawable.person3,
                    R.drawable.person4,
                    R.drawable.person5,
                    R.drawable.person6,
                    R.drawable.person7));


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feeds);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        // set a GridLayoutManager with 1 number of columns , horizontal gravity and false value for reverseLayout to show the items
        // from start to end
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),1);

        recyclerView.setLayoutManager(gridLayoutManager); // set LayoutManager to RecyclerView

        //  call the constructor of FeedsAdapter to send the reference and data to Adapter
        FeedsAdapter feedsAdapter = new FeedsAdapter(FeedsActivity.this,personNames,personImages,Add2Card);

        recyclerView.setAdapter(feedsAdapter); // set the Adapter to RecyclerView
    }
}
