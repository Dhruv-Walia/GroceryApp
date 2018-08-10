package in.vibescom.groceryapp.UI.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import in.vibescom.groceryapp.Models.OrderHistory;
import in.vibescom.groceryapp.R;
import in.vibescom.groceryapp.UI.Adapters.OrderHistoryAdapter;
import in.vibescom.groceryapp.UI.Helpers.DividerItemRecyclerDecoration;

public class OrderHistoryFragment extends Fragment{

    RecyclerView rvOrders;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_order_history, container, false);
        rvOrders = rootView.findViewById(R.id.recycler_order);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Shopping Cart Product Adapter with data
        OrderHistoryAdapter adapter = new OrderHistoryAdapter(getActivity(),getList());
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        rvOrders.setLayoutManager(manager);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemRecyclerDecoration(getActivity(), R.drawable.canvas_recycler_divider);
        rvOrders.addItemDecoration(itemDecoration);
        rvOrders.hasFixedSize();
        rvOrders.setAdapter(adapter);
    }


    private ArrayList<OrderHistory> getList(){
        ArrayList<OrderHistory> transactions = new ArrayList<>();
        transactions.add(new OrderHistory("ODI1234KFBG2",19,"Jul-04-2017","1890","COD",1,"9971925766","E 22, Udhyog Marg, Sector 8, Noida, Uttar Pradesh"));
        transactions.add(new OrderHistory("ODI1235KFJG2",10,"Aug-06-2017","1560","Debit Card",2,"9910422365","E 22, Udhyog Marg, Sector 8, Noida, Uttar Pradesh"));
        transactions.add(new OrderHistory("ODI1236GHID2",5,"Nov-08-2017","560","Credit Card",3,"9810450048","E 22, Udhyog Marg, Sector 8, Noida, Uttar Pradesh"));
        transactions.add(new OrderHistory("ODI1237JFTT2",25,"Dec-21-2017","3528","Net Banking",4,"8653304447","E 22, Udhyog Marg, Sector 8, Noida, Uttar Pradesh"));
        return transactions;
    }

}
