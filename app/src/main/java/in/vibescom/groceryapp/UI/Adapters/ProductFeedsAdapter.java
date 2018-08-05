package in.vibescom.groceryapp.UI.Adapters;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import in.vibescom.groceryapp.R;
import in.vibescom.groceryapp.UI.Fragments.DashboardFragment;


public class ProductFeedsAdapter extends RecyclerView.Adapter<ProductFeedsAdapter.MyViewHolder> {

    ArrayList<String> personNames;
    ArrayList<Integer> personImages;
    Button Add2Cart;
    DashboardFragment context;

    public ProductFeedsAdapter(DashboardFragment dashboardfragment, ArrayList<String> personNames, ArrayList<Integer> personImages,
                               Button Add2Cart) {
        this.context = dashboardfragment;
        this.personNames = personNames;
        this.personImages = personImages;
        this.Add2Cart = Add2Cart;

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
        holder.image.setImageResource(personImages.get(position));

        holder.Add2Cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.Add2Cart.setBackgroundColor(Color.RED);
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

        //Button Add to cart
        Button Add2Cart;


        public MyViewHolder(View itemView) {
            super(itemView);

            // get the reference of row_banner_item view's
            name = (TextView) itemView.findViewById(R.id.product_name);
            //desc = (TextView) itemView.findViewById(R.id.desc);
            image = (ImageView) itemView.findViewById(R.id.image);

            Add2Cart = (Button) itemView.findViewById(R.id.btn_card_add);
        }
    }
}

