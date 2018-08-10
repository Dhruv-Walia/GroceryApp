package in.vibescom.groceryapp.UI.Fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import in.vibescom.groceryapp.R;
import in.vibescom.groceryapp.UI.Interfaces.MenuListener;

@SuppressLint("ValidFragment")
public class ProfileFragment extends Fragment {

    @BindView(R.id.iv_profile_image)
    CircleImageView ivProfilePic;
    @BindView(R.id.tv_user_name)
    TextView tvUserName;
    @BindView(R.id.iv_edit)
    ImageView ivEdit;
    @BindView(R.id.tv_joined)
    TextView tvJoinedOn;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_email)
    TextView tvEmail;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.tv_location)
    TextView tvAddrees;
    @BindView(R.id.tv_wallet_amt)
    TextView tvWalletAmount;
    private MenuListener listener;

    public ProfileFragment(MenuListener listener) {
        this.listener = listener;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);
        ButterKnife.bind(this,rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @OnClick(R.id.view_my_wallet)
    void MyWallet(){
        listener.onItemClicked(R.id.nav_wallet);
    }

    @OnClick(R.id.view_my_orders)
    void MyOrders(){
        listener.onItemClicked(R.id.nav_orders);
    }

    @OnClick(R.id.view_my_addresses)
    void MyAddresses(){

    }

    @OnClick(R.id.view_notifications)
    void NotificationPref(){

    }

    @OnClick(R.id.view_password)
    void ChangePassword(){

    }

    @OnClick(R.id.view_logout)
    void Logout(){

    }


}
