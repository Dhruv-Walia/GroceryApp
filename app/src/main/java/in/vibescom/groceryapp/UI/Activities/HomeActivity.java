package in.vibescom.groceryapp.UI.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import in.vibescom.groceryapp.R;
import in.vibescom.groceryapp.UI.Fragments.DashboardFragment;
import in.vibescom.groceryapp.UI.Fragments.OrderHistoryFragment;
import in.vibescom.groceryapp.UI.Fragments.ProfileFragment;
import in.vibescom.groceryapp.UI.Fragments.WalletFragment;
import in.vibescom.groceryapp.UI.Interfaces.MenuListener;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,View.OnClickListener {

    private DrawerLayout drawer;
    private NavigationView navigationView;
    private Fragment currentFragment;
    private TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        title = toolbar.findViewById(R.id.tv_title);

        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ImageButton btnCart = findViewById(R.id.btn_cart);
        btnCart.setOnClickListener(this);

        if (savedInstanceState == null) {
            // on first time display view for first nav row_banner_item
            changeFragment(new DashboardFragment(),false,true,getString(R.string.nav_home));
            navigationView.setCheckedItem(R.id.nav_home);
            title.setText(R.string.nav_home);
            drawer.setDrawerTitle(10,"Home");
        }else{
            //Restore the fragment's instance
            currentFragment = getSupportFragmentManager().getFragment(savedInstanceState, "myFragmentName");
        }
    }

    @Override
    public void onSaveInstanceState(Bundle state) {
        super.onSaveInstanceState(state);
        getSupportFragmentManager().putFragment(state, "myFragmentName", currentFragment);
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view row_banner_item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_home) {
            changeFragment(new DashboardFragment(),true,true,getString(R.string.nav_home));
            title.setText(R.string.nav_home);
        } else if (id == R.id.nav_offers) {

        } else if (id == R.id.nav_account) {
            changeFragment(new ProfileFragment( itemId -> {
                switch (itemId){
                    case R.id.nav_orders:
                        changeFragment(new OrderHistoryFragment(),true,true,getString(R.string.nav_order));
                        title.setText(R.string.nav_order);
                        navigationView.setCheckedItem(R.id.nav_orders);
                        break;
                    case R.id.nav_wallet:
                        changeFragment(new WalletFragment(),true,true,getString(R.string.nav_wallet));
                        title.setText(R.string.nav_wallet);
                        navigationView.setCheckedItem(R.id.nav_wallet);
                        break;
                }
            }),true,true,getString(R.string.nav_account));
            title.setText(R.string.nav_account);
        } else if (id == R.id.nav_orders) {
            changeFragment(new OrderHistoryFragment(),true,true,getString(R.string.nav_order));
            title.setText(R.string.nav_order);
        } else if (id == R.id.nav_wallet) {
            changeFragment(new WalletFragment(),true,true,getString(R.string.nav_wallet));
            title.setText(R.string.nav_wallet);
        } else if (id == R.id.nav_notification) {

        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void changeFragment(Fragment fragment, boolean addToBackStack, boolean animate, String tag) {
        currentFragment = fragment;
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        if (animate) {
            ft.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
        }
        if (addToBackStack) {
            ft.addToBackStack(tag);
        }
        ft.replace(R.id.frame, fragment, tag);
        ft.commitAllowingStateLoss();
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btn_cart){
            Intent intent = new Intent(HomeActivity.this,ShoppingBasketActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            assert currentFragment.getTag() != null;
            if(currentFragment.getTag().equals(getString(R.string.nav_home))){
                getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                super.onBackPressed();
            }else{
                getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                changeFragment(new DashboardFragment(),false,false,getString(R.string.nav_home));
                navigationView.setCheckedItem(R.id.nav_home);
                title.setText(R.string.nav_home);
            }
        }
    }

}
