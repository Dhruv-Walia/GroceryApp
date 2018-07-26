package in.vibescom.groceryapp.UI.Adapters;

import android.content.Context;
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
    private Context context;
    private ArrayList<WalletTransactions> list;

    public WalletTransactionAdapter(Context context, ArrayList<WalletTransactions> list){
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public TransactionHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_wallet_transaction,parent);
        return new TransactionHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TransactionHolder holder, int position) {
        holder.tvWalletHead.setText(list.get(position).getHeading());
        holder.tvWalletDate.setText(list.get(position).getDate());
        holder.tvWalletAmount.setText(String.valueOf(list.get(position).getAmount()));
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

        @BindView(R.id.tv_wallet_head)
        TextView tvWalletHead;
        @BindView(R.id.tv_wallet_date)
        TextView tvWalletDate;
        @BindView(R.id.tv_wallet_amt)
        TextView tvWalletAmount;
        @BindView(R.id.tv_wallet_type)
        TextView tvWalletType;

        public TransactionHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
