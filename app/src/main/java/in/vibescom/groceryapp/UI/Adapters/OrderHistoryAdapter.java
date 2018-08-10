package in.vibescom.groceryapp.UI.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import in.vibescom.groceryapp.Models.OrderHistory;
import in.vibescom.groceryapp.R;
import in.vibescom.groceryapp.UI.Activities.OrderDetailActivity;

public class OrderHistoryAdapter extends RecyclerView.Adapter<OrderHistoryAdapter.OrderHistoryHolder>{
    private Context context;
    private ArrayList<OrderHistory> list;

    public OrderHistoryAdapter(Context context,ArrayList<OrderHistory> list){
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public OrderHistoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_order_history,parent,false);
        return new OrderHistoryAdapter.OrderHistoryHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderHistoryHolder holder, int position) {
        holder.tvOrderId.setText(list.get(position).getOrderId());
        holder.tvOrderDate.setText(list.get(position).getOrderDate());
        try{
            String items = "("+context.getString(R.string.total_order_items)+" "+list.get(position).getTotalItems()+")";
            holder.tvTotalItems.setText(items);
        }catch (Exception e){
            e.printStackTrace();
        }
        String amount = context.getString(R.string.Rs) + list.get(position).getAmountPaid();
        holder.tvAmountPaid.setText(amount);
        holder.tvPaymentType.setText(list.get(position).getPaymentType());
        holder.tvCustPhone.setText(list.get(position).getCustPhone());
        holder.tvCustAddress.setText(list.get(position).getCustAddress());
        switch (list.get(position).getOrderStatus()){
            case 1 :
                holder.tvOrderStatus.setText("Processed");
                holder.tvOrderStatus.setTextColor(context.getResources().getColor(android.R.color.holo_blue_dark));
                holder.ivOrderStat.setImageResource(R.drawable.ic_process);
                break;
            case 2 :
                holder.tvOrderStatus.setText("Packed");
                holder.tvOrderStatus.setTextColor(context.getResources().getColor(android.R.color.holo_blue_dark));
                holder.ivOrderStat.setImageResource(R.drawable.ic_packed);
                break;
            case 3 :
                holder.tvOrderStatus.setText("Shipped");
                holder.tvOrderStatus.setTextColor(context.getResources().getColor(android.R.color.holo_green_light));
                holder.ivOrderStat.setImageResource(R.drawable.ic_shipped);
                break;
            case 4 :
                holder.tvOrderStatus.setText("Delivered");
                holder.tvOrderStatus.setTextColor(context.getResources().getColor(android.R.color.holo_green_light));
                holder.ivOrderStat.setImageResource(R.drawable.ic_delivered);
                break;
            case 5 :
                holder.tvOrderStatus.setText("UnRecognized");
                holder.tvOrderStatus.setTextColor(context.getResources().getColor(android.R.color.holo_red_dark));
                holder.ivOrderStat.setImageResource(R.drawable.ic_danger);
                break;
            default :
                break;
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class OrderHistoryHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView ivOrderStat;
        TextView tvTotalItems,tvOrderId,tvOrderDate,tvAmountPaid,tvPaymentType,tvOrderStatus,tvCustPhone,tvCustAddress;

        OrderHistoryHolder(View itemView) {
            super(itemView);
            tvTotalItems = itemView.findViewById(R.id.tv_total_items);
            tvOrderId = itemView.findViewById(R.id.tv_order_id);
            tvOrderDate = itemView.findViewById(R.id.tv_order_date);
            tvAmountPaid = itemView.findViewById(R.id.tv_amount_paid);
            tvPaymentType = itemView.findViewById(R.id.tv_payment_type);
            tvCustPhone = itemView.findViewById(R.id.tv_cust_number);
            tvCustAddress = itemView.findViewById(R.id.tv_cust_address);
            ivOrderStat = itemView.findViewById(R.id.iv_order_status);
            tvOrderStatus = itemView.findViewById(R.id.tv_order_status);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, OrderDetailActivity.class);
            context.startActivity(intent);
        }
    }
}
