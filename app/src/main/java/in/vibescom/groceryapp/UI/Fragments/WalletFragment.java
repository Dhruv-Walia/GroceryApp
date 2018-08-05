package in.vibescom.groceryapp.UI.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.OnClick;
import in.vibescom.groceryapp.Models.WalletTransactions;
import in.vibescom.groceryapp.R;
import in.vibescom.groceryapp.UI.Activities.ProductDetailActivity;
import in.vibescom.groceryapp.UI.Adapters.WalletTransactionAdapter;

public class WalletFragment extends Fragment {

    TextView tvWalletAmount,tvOfferPt;
    EditText etAddAmount;
    RecyclerView rvTransactions;
    Button btnAddMoney;
    RelativeLayout viewStatement;
    TextView seeAllTransaction;

    public WalletFragment(){ }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_wallet, container, false);
        ButterKnife.bind(this,rootView);
        tvWalletAmount = rootView.findViewById(R.id.tv_wallet_amt);
        etAddAmount = rootView.findViewById(R.id.et_add_amount);
        tvOfferPt = rootView.findViewById(R.id.tv_offer_pts);
        rvTransactions = rootView.findViewById(R.id.rv_wallet_transactions);
        btnAddMoney = rootView.findViewById(R.id.btn_add_money);
        seeAllTransaction = rootView.findViewById(R.id.wallet_see_all);
        viewStatement = rootView.findViewById(R.id.view_wallet_statement);

        // Wallet Transaction Adapter with data
        WalletTransactionAdapter adapter = new WalletTransactionAdapter(getList());
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        rvTransactions.setLayoutManager(manager);
        rvTransactions.hasFixedSize();
        rvTransactions.setAdapter(adapter);

        viewStatement.setOnClickListener(v -> {
            Intent in = new Intent(getActivity(), ProductDetailActivity.class);
            startActivity(in);
        });

        return rootView;
    }

    private ArrayList<WalletTransactions> getList(){
        ArrayList<WalletTransactions> transactions = new ArrayList<>();
        transactions.add(new WalletTransactions("Transaction - 5863752","500","23:45 PM, 21 Jul 2018",false));
        transactions.add(new WalletTransactions("Money Added - 5863521","1000","22:00 PM, 20 Jul 2018",true));
        return transactions;
    }

    @OnClick(R.id.btn_add_money)
    void AddMoney(){ }

    @OnClick(R.id.wallet_see_all)
    void SeeAllTransac(){ }

    @OnClick(R.id.view_wallet_statement)
    void WalletStatement(){
    }
}
