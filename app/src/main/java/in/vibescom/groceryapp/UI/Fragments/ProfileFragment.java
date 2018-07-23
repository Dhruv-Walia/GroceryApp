package in.vibescom.groceryapp.UI.Fragments;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import in.vibescom.groceryapp.R;

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
    @BindView(R.id.tv_gender)
    TextView tvGender;
    @BindView(R.id.tv_wallet_amt)
    TextView tvWalletAmount;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
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

    }

    @OnClick(R.id.view_my_orders)
    void MyOrders(){

    }

    @OnClick(R.id.view_my_cart)
    void MyCart(){

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
