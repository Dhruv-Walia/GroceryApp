package in.vibescom.groceryapp.UI.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.LinearLayout;
import android.widget.TextView;

import com.lsjwzh.widget.recyclerviewpager.LoopRecyclerViewPager;

import java.util.ArrayList;
import java.util.Arrays;

import in.vibescom.groceryapp.R;
import in.vibescom.groceryapp.UI.Adapters.ProductFeedsAdapter;
import in.vibescom.groceryapp.UI.Adapters.LayoutAdapter;
import in.vibescom.groceryapp.UI.Views.SFDRButton;

public class DashboardFragment extends Fragment {

    Context context;
    SFDRButton Add2Card;
    LayoutAdapter layoutAdapter;
    LinearLayout dotsLayout;
    LoopRecyclerViewPager mRecyclerViewPager;

    // ArrayList for person names
    ArrayList<String> productNames = new ArrayList<>
            (Arrays.asList( "Product 1",
                    "Product 2",
                    "Product 3",
                    "Product 4",
                    "Product 5",
                    "Product 6",
                    "Product 7"));

    ArrayList<String> productImages = new ArrayList<>
            (Arrays.asList("https://images.yourstory.com/2016/08/125-fall-in-love.png",
                    "https://images.yourstory.com/2016/08/125-fall-in-love.png",
                    "https://images.yourstory.com/2016/08/125-fall-in-love.png",
                    "https://images.yourstory.com/2016/08/125-fall-in-love.png",
                    "https://images.yourstory.com/2016/08/125-fall-in-love.png",
                    "https://images.yourstory.com/2016/08/125-fall-in-love.png",
                    "https://images.yourstory.com/2016/08/125-fall-in-love.png") );

    ArrayList<String> bannerImages = new ArrayList<>
            (Arrays.asList("https://landerapp.com/blog/wp-content/uploads/2018/05/MAG-FR-Oestreicher-Singer-Product-Recommendation-Viral-Marketing-Social-Media-Network-Ecommerce-1200-1200x627.jpg",
                    "https://landerapp.com/blog/wp-content/uploads/2018/05/MAG-FR-Oestreicher-Singer-Product-Recommendation-Viral-Marketing-Social-Media-Network-Ecommerce-1200-1200x627.jpg",
                    "https://landerapp.com/blog/wp-content/uploads/2018/05/MAG-FR-Oestreicher-Singer-Product-Recommendation-Viral-Marketing-Social-Media-Network-Ecommerce-1200-1200x627.jpg",
                    "https://landerapp.com/blog/wp-content/uploads/2018/05/MAG-FR-Oestreicher-Singer-Product-Recommendation-Viral-Marketing-Social-Media-Network-Ecommerce-1200-1200x627.jpg",
                    "https://landerapp.com/blog/wp-content/uploads/2018/05/MAG-FR-Oestreicher-Singer-Product-Recommendation-Viral-Marketing-Social-Media-Network-Ecommerce-1200-1200x627.jpg",
                    "https://landerapp.com/blog/wp-content/uploads/2018/05/MAG-FR-Oestreicher-Singer-Product-Recommendation-Viral-Marketing-Social-Media-Network-Ecommerce-1200-1200x627.jpg",
                    "https://landerapp.com/blog/wp-content/uploads/2018/05/MAG-FR-Oestreicher-Singer-Product-Recommendation-Viral-Marketing-Social-Media-Network-Ecommerce-1200-1200x627.jpg") );

    public DashboardFragment(){ }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_dashboard, container, false);
        context = getActivity();

        RecyclerView rvFeed = rootView.findViewById(R.id.rv__product_feeds);

        dotsLayout = rootView.findViewById(R.id.dots_layout);
        mRecyclerViewPager = rootView.findViewById(R.id.loop_recycler_view_pager);

        initViewPager();
        // set a GridLayoutManager with 1 number of columns , horizontal gravity and false value for reverseLayout to show the items
        // from start to end
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),1);
        rvFeed.setLayoutManager(gridLayoutManager); // set LayoutManager to RecyclerView
        //  call the constructor of ProductFeedsAdapter to send the reference and data to Adapter
        ProductFeedsAdapter feedsAdapter = new ProductFeedsAdapter(getActivity(), productNames, productImages,Add2Card);
        rvFeed.setAdapter(feedsAdapter); // set the Adapter to RecyclerView
        return rootView;
    }

    private void addBottomDots(int currentPage,int size) {
        TextView[] dots = new TextView[size];
        dotsLayout.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(context);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(context.getResources().getColor(R.color.inactiveState));
            dotsLayout.addView(dots[i]);
        }
        if (dots.length > 0) {
            dots[currentPage].setTextColor(context.getResources().getColor(R.color.theme_color));
        }
    }

    protected void initViewPager() {
        LinearLayoutManager layout = new LinearLayoutManager(this.getActivity(), LinearLayoutManager.HORIZONTAL, false);
        mRecyclerViewPager.setTriggerOffset(0.15f);
        mRecyclerViewPager.setFlingFactor(0.25f);
        mRecyclerViewPager.setLayoutManager(layout);
        layoutAdapter = new LayoutAdapter(context, mRecyclerViewPager, bannerImages);
        mRecyclerViewPager.setAdapter(layoutAdapter);
        mRecyclerViewPager.setHasFixedSize(true);
        mRecyclerViewPager.setLongClickable(true);
        addBottomDots(0, bannerImages.size());

        mRecyclerViewPager.addOnPageChangedListener((i, i1) -> addBottomDots(mRecyclerViewPager.getActualCurrentPosition(), bannerImages.size()));

        mRecyclerViewPager.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int scrollState) { }

            @Override
            public void onScrolled(RecyclerView recyclerView, int i, int pos) {
//                mPositionText.setText("First: " + mRecyclerViewPager.getFirstVisiblePosition());
                int childCount = mRecyclerViewPager.getChildCount();
                int width = mRecyclerViewPager.getChildAt(0).getWidth();
                int padding = (mRecyclerViewPager.getWidth() - width) / 2;

                for (int j = 0; j < childCount; j++) {
                    View v = recyclerView.getChildAt(j);
                    //往左 从 padding 到 -(v.getWidth()-padding) 的过程中，由大到小
                    float rate = 0;
                    if (v.getLeft() <= padding) {
                        if (v.getLeft() >= padding - v.getWidth()) {
                            rate = (padding - v.getLeft()) * 1f / v.getWidth();
                        } else {
                            rate = 1;
                        }
                        v.setScaleY(1 - rate * 0.1f);
                    } else {

                        if (v.getLeft() <= recyclerView.getWidth() - padding) {
                            rate = (recyclerView.getWidth() - padding - v.getLeft()) * 1f / v.getWidth();
                        }
                        v.setScaleY(0.9f + rate * 0.1f);
                    }
                }
            }
        });

    }
}

