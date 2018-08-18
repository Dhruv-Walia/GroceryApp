package in.vibescom.groceryapp.UI.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import in.vibescom.groceryapp.R;
import in.vibescom.groceryapp.UI.Fragments.DashboardFragment;
import in.vibescom.groceryapp.UI.Views.SFDRButton;


public class ProductFeedsAdapter extends RecyclerView.Adapter<ProductFeedsAdapter.MyViewHolder> {

    ArrayList<String> personNames;
    ArrayList<String> personImages;
    SFDRButton Add2Cart;
    Context context;
    LinearLayout feeds_linearLayout;

    public ProductFeedsAdapter(Context dashboardfragment, ArrayList<String> personNames, ArrayList<String> personImages,
                               SFDRButton Add2Cart,LinearLayout feeds_linearLayout) {
        this.context = dashboardfragment;
        this.personNames = personNames;
        this.personImages = personImages;
        this.Add2Cart = Add2Cart;
        this.feeds_linearLayout = feeds_linearLayout;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // infalte the row_banner_item Layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_feed_layout, parent, false);

        // set the view's size, margins, paddings and layout parameters
        MyViewHolder vh = new MyViewHolder(v); // pass the view to View Holder

        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        // set the data in items
        holder.name.setText(personNames.get(position));
        //holder.desc.setText(personDesc.get(position));
        Picasso.with(context).load(personImages.get(position)).placeholder(R.drawable.no_product_img).into(holder.image);
        //holder.image.setImageResource(personImages.get(position));

        holder.Add2Cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.feeds_linearLayout.setVisibility(View.VISIBLE);
            }
        });
        // implement setOnClickListener event on row_banner_item view.
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // open another activity on row_banner_item click
                /*Intent intent = new Intent(context, ZoomImageActivity.class);
                intent.putExtra("image", personImages.get(position)); // put image data in Intent
                context.startActivity(intent); // start Intent*/
            }
        });

    }


    @Override
    public int getItemCount() {
        return personNames.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        // init the row_banner_item view's
        TextView name;
        //TextView desc;
        ImageView image;
        LinearLayout feeds_linearLayout;

        //Button Add to cart
        SFDRButton Add2Cart;

        public MyViewHolder(View itemView) {
            super(itemView);

            // get the reference of row_banner_item view's
            name = (TextView) itemView.findViewById(R.id.product_name);
            //desc = (TextView) itemView.findViewById(R.id.desc);
            image = (ImageView) itemView.findViewById(R.id.image);

            feeds_linearLayout = itemView.findViewById(R.id.cart_increase_ll);
            Add2Cart = (SFDRButton) itemView.findViewById(R.id.btn_card_add);
        }
    }
}

