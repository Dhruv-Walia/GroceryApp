package in.vibescom.groceryapp.UI.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import in.vibescom.groceryapp.R;
import in.vibescom.groceryapp.UI.Activities.ProductDetailActivity;
import in.vibescom.groceryapp.UI.Views.SFDRButton;


public class ProductFeedsAdapter extends RecyclerView.Adapter<ProductFeedsAdapter.MyViewHolder> {

    private ArrayList<String> productNames;
    private ArrayList<String> productImages;
    private Context context;

    public ProductFeedsAdapter(Context dashboardfragment, ArrayList<String> productNames, ArrayList<String> productImages) {
        this.context = dashboardfragment;
        this.productNames = productNames;
        this.productImages = productImages;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // infalte the row_banner_item Layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_feed_layout, parent, false);
        // pass the view to View Holder
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        // set the data in items
        holder.name.setText(productNames.get(position));
        //holder.desc.setText(personDesc.get(position));
        Picasso.with(context).load(productImages.get(position)).placeholder(R.drawable.no_product_img).into(holder.image);
        //holder.image.setImageResource(productImages.get(position));

        holder.Add2Cart.setOnClickListener(v -> {
            holder.feeds_linearLayout.setVisibility(View.VISIBLE);
            holder.Add2Cart.setVisibility(View.GONE);
        });
        // implement setOnClickListener event on row_banner_item view.
        holder.itemView.setOnClickListener(view -> {
            // open another activity on row_banner_item click
            Intent in = new Intent(context, ProductDetailActivity.class);
            context.startActivity(in);
            /*Intent intent = new Intent(context, ZoomImageActivity.class);
            intent.putExtra("image", productImages.get(position)); // put image data in Intent
            context.startActivity(intent); // start Intent*/
        });

    }


    @Override
    public int getItemCount() {
        return productNames.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        // init the row_banner_item view's
        TextView name;
        ImageView image;
        LinearLayout feeds_linearLayout;

        //Button Add to cart
        SFDRButton Add2Cart;

        MyViewHolder(View itemView) {
            super(itemView);

            // get the reference of row_banner_item view's
            name = itemView.findViewById(R.id.product_name);
            image = itemView.findViewById(R.id.iv_product_feed);

            feeds_linearLayout = itemView.findViewById(R.id.cart_increase_ll);
            Add2Cart = itemView.findViewById(R.id.btn_card_add);
        }
    }
}

