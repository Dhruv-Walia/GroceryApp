package in.vibescom.groceryapp.UI.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lsjwzh.widget.recyclerviewpager.LoopRecyclerViewPager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Timer;

import in.vibescom.groceryapp.R;
import in.vibescom.groceryapp.UI.Adapters.FeedsAdapter;

public class DashboardFragment extends Fragment {

    Timer timer;
    private int currentPage = 0;
    Button Add2Card;
    ViewPager pager;
    LinearLayout dotsLayout;
    LoopRecyclerViewPager loopRecyclerViewPager;

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

        pager = (ViewPager) rootView.findViewById(R.id.view_pager);
        dotsLayout = rootView.findViewById(R.id.dots_layout);
        //loopRecyclerViewPager = rootView.findViewById(R.id.loop_recycler_view_pager);
        pager.setPageMargin(12);
        MyPagerAdapter adapter = new MyPagerAdapter(getFragmentManager());
        pager.setAdapter(adapter);

// setLayoutManager like normal RecyclerView, you do not need to change any thing.
        LinearLayoutManager layout = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL,false);

        addBottomDots(0,adapter.getCount());


        // set a GridLayoutManager with 1 number of columns , horizontal gravity and false value for reverseLayout to show the items
        // from start to end
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),1);

        recyclerView.setLayoutManager(gridLayoutManager); // set LayoutManager to RecyclerView

        //  call the constructor of FeedsAdapter to send the reference and data to Adapter
        FeedsAdapter feedsAdapter = new FeedsAdapter(DashboardFragment.this,personNames,personImages,Add2Card);

        recyclerView.setAdapter(feedsAdapter); // set the Adapter to RecyclerView
        return rootView;
    }

    private void addBottomDots(int currentPage,int size) {
        TextView[] dots = new TextView[size];
        dotsLayout.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(getContext());
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.inactiveState));
            dotsLayout.addView(dots[i]);
        }
        if (dots.length > 0) {
            dots[currentPage].setTextColor(getResources().getColor(R.color.theme_color));
        }
    }

    private class MyPagerAdapter extends FragmentStatePagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int pos) {

            switch (pos) {
                case 0:
                    return new ImageFragment(R.drawable.offer);
                case 1:
                    return new ImageFragment(R.drawable.offer);
                case 2:
                    return new ImageFragment(R.drawable.offer);
                case 3:
                    return new ImageFragment(R.drawable.offer);
                case 4:
                    return new ImageFragment(R.drawable.apple);

                default:
                    return new ImageFragment(R.drawable.offer);
            }
        }

        @Override
        public float getPageWidth (int position) {
            return 0.8f;
        }

        @Override
        public int getCount() {
            return 5;
        }
    }

}

