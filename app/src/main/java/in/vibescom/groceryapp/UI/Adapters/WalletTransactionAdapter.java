package in.vibescom.groceryapp.UI.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.vibescom.groceryapp.Models.WalletTransactions;
import in.vibescom.groceryapp.R;

public class WalletTransactionAdapter extends RecyclerView.Adapter<WalletTransactionAdapter.TransactionHolder>{
    private ArrayList<WalletTransactions> list;

    public WalletTransactionAdapter(ArrayList<WalletTransactions> list){
        this.list = list;
    }

    @NonNull
    @Override
    public TransactionHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_wallet_transaction,parent,false);
        return new TransactionHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TransactionHolder holder, int position) {
        holder.tvWalletHead.setText(list.get(position).getHeading());
        holder.tvWalletDate.setText(list.get(position).getDate());
        try{
            holder.tvWalletAmount.setText(list.get(position).getAmount());
        }catch (Exception e){
            e.printStackTrace();
        }
        if(list.get(position).getTransactionType())
            holder.tvWalletType.setText("+");
        else
            holder.tvWalletType.setText("-");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class TransactionHolder extends RecyclerView.ViewHolder{
        TextView tvWalletHead,tvWalletDate,tvWalletAmount,tvWalletType;

        TransactionHolder(View itemView) {
            super(itemView);
            tvWalletHead = itemView.findViewById(R.id.tv_wallet_head);
            tvWalletDate = itemView.findViewById(R.id.tv_wallet_date);
            tvWalletAmount = itemView.findViewById(R.id.tv_wallet_amount);
            tvWalletType = itemView.findViewById(R.id.tv_wallet_type);
        }
    }
}
