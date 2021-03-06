package in.vibescom.groceryapp.UI.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import in.vibescom.groceryapp.R;


public class PagerLayoutAdapter extends RecyclerView.Adapter<PagerLayoutAdapter.SimpleViewHolder> {
    public ImageView imageView;
    private RecyclerView mRecyclerView;
    private Context context;
    private ArrayList<String> mItems ;
    private LinearLayout feed_linearLayout;

    public static class SimpleViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;

        SimpleViewHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.iv_banner_image);
        }
    }

    public PagerLayoutAdapter(Context context, RecyclerView recyclerView, ArrayList<String> list) {
        this.context = context;
        this.mItems = list;
        mRecyclerView = recyclerView;
    }


    public void addItem(String item) {
        mItems.add(item);
        notifyDataSetChanged();
    }

    public void removeItem(Integer item) {
        mItems.remove(item);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SimpleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_banner_item, parent, false);
        return new SimpleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SimpleViewHolder holder, int position) {

        Picasso.with(context).load(mItems.get(position)).placeholder(R.drawable.test_product_img).into(holder.imageView);
        //holder.imageView.setImageResource(mItems.indexOf(position));

        View itemView = holder.itemView;
        itemView.setOnClickListener(v -> {
        });
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }
}

