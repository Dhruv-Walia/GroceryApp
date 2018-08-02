package in.vibescom.groceryapp.UI.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Arrays;

import in.vibescom.groceryapp.R;
import in.vibescom.groceryapp.UI.Adapters.FeedsAdapter;

public class DashboardFragment extends Fragment {

    Button Add2Card;
    public final static int PAGES = 5;
    public final static int FIRST_PAGE = 0  ;

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


    public DashboardFragment(){ }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_dashboard, container, false);
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.dash_recyclerView);
//        ViewPager = rootView.findViewById(R.id.viewpager);

        ViewPager pager = (ViewPager) rootView.findViewById(R.id.view_pager);
        pager.setAdapter(new MyPagerAdapter(getFragmentManager()));

        // set a GridLayoutManager with 1 number of columns , horizontal gravity and false value for reverseLayout to show the items
        // from start to end
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),1);

        recyclerView.setLayoutManager(gridLayoutManager); // set LayoutManager to RecyclerView

        //  call the constructor of FeedsAdapter to send the reference and data to Adapter
        FeedsAdapter feedsAdapter = new FeedsAdapter(DashboardFragment.this,personNames,personImages,Add2Card);

        recyclerView.setAdapter(feedsAdapter); // set the Adapter to RecyclerView
        return rootView;
    }
    private class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public android.support.v4.app.Fragment getItem(int pos) {
            switch (pos) {
                case 0:
                    return FragmentViewPager.newInstance("ITEM-ONE", R.drawable.apple);
                case 1:
                    return FragmentViewPager.newInstance("ITEM-TWO", R.drawable.orange);
                case 2:
                    return FragmentViewPager.newInstance("ITEM-THREE", R.drawable.grapes);
                default:
                    return FragmentViewPager.newInstance("ITEM-ONE", R.drawable.apple);
            }
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}

