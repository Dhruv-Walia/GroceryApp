package in.vibescom.groceryapp.UI.Adapters;

import android.content.Context;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

import in.vibescom.groceryapp.Models.CartProducts;
import in.vibescom.groceryapp.R;
import in.vibescom.groceryapp.UI.Interfaces.ClickListener;

public class CartProductAdapter extends RecyclerView.Adapter<CartProductAdapter.CartHolder>{
    private Context context;
    private ArrayList<CartProducts> list;
    private ClickListener listener;

    public CartProductAdapter(Context context,ArrayList<CartProducts> list, ClickListener listener){
        this.list = list;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CartHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_shopping_basket_product,parent,false);
        return new CartHolder(view,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull CartHolder holder, int position) {
        holder.tvProductBrand.setText(list.get(position).getProductBrand());
        holder.tvProductName.setText(list.get(position).getProductName());
        try{
            String mrp = context.getString(R.string.mrp)+" "+context.getString(R.string.Rs)+list.get(position).getMrp();
            holder.tvProductMRP.setText(mrp);
            holder.tvProductMRP.setPaintFlags(holder.tvProductMRP.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

            String price = context.getString(R.string.Rs)+list.get(position).getPrice();
            holder.tvProductPrice.setText(price);
        }catch (Exception e){
            e.printStackTrace();
        }
        holder.tvProductWeight.setText(list.get(position).getProductWeight());
        holder.tvQuantity.setText(String.valueOf(list.get(position).getQuantity()));
        if(!list.get(position).getImageUrl().isEmpty())
            Picasso.with(context).load(list.get(position).getImageUrl()).placeholder(R.drawable.test_product_img).into(holder.ivImage);
        else
            Picasso.with(context).load(R.drawable.no_product_img).into(holder.ivImage);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void emptyCart(){
        list.clear();
        notifyDataSetChanged();
    }

    class CartHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView ivImage;
        private ImageButton ivDelete;
        private TextView tvProductBrand,tvProductName,tvProductWeight,tvProductMRP,tvProductPrice,tvQuantity;
        private WeakReference<ClickListener> listenerRef;

        CartHolder(View itemView, ClickListener listener) {
            super(itemView);
            listenerRef = new WeakReference<>(listener);
            ivImage = itemView.findViewById(R.id.iv_product);
            ivDelete = itemView.findViewById(R.id.img_btn_delete);
            tvProductBrand = itemView.findViewById(R.id.tv_product_brand);
            tvProductName = itemView.findViewById(R.id.tv_product_name);
            tvProductWeight = itemView.findViewById(R.id.tv_product_weight);
            tvProductMRP = itemView.findViewById(R.id.tv_product_mrp);
            tvProductPrice = itemView.findViewById(R.id.tv_product_price);
            tvQuantity = itemView.findViewById(R.id.tv_product_qty);
            ivDelete.setOnClickListener(this);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (v.getId() == ivDelete.getId()) {
                list.remove(list.get(getAdapterPosition()));
                notifyItemRemoved(getAdapterPosition());
                listenerRef.get().onDeleteClicked(getAdapterPosition());
            } else {
                listenerRef.get().onPositionClicked(getAdapterPosition());
            }
        }
    }
}
