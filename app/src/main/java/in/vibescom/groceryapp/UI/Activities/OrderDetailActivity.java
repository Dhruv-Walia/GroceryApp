package in.vibescom.groceryapp.UI.Activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageButton;
import android.widget.TextView;

import in.vibescom.groceryapp.R;
import in.vibescom.groceryapp.UI.Fragments.OrderItemsFragment;
import in.vibescom.groceryapp.UI.Fragments.OrderSummaryFragment;

public class OrderDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView tvTitle = findViewById(R.id.tv_title);
        tvTitle.setText("Order Details");

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        ViewPager viewPager = findViewById(R.id.view_pager);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        ImageButton backButton = findViewById(R.id.iv_back_btn);
        backButton.setOnClickListener(v -> finish());
    }

}

class ViewPagerAdapter extends FragmentPagerAdapter {
    ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (position == 0) {
            fragment = new OrderSummaryFragment();
        } else if(position == 1){
            fragment = new OrderItemsFragment();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if (position == 0) {
            title = "Order Summary";
        } else if (position == 1) {
            title = "Order Items";
        }
        return title;
    }
}
