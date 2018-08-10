package in.vibescom.groceryapp.UI.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import in.vibescom.groceryapp.Models.CartProducts;
import in.vibescom.groceryapp.R;
import in.vibescom.groceryapp.UI.Adapters.CartProductAdapter;
import in.vibescom.groceryapp.UI.Helpers.DividerItemRecyclerDecoration;
import in.vibescom.groceryapp.UI.Interfaces.ClickListener;

import static in.vibescom.groceryapp.Managers.BaseManagers.ApplicationManager.getContext;

public class ShoppingBasketActivity extends AppCompatActivity {
    RecyclerView rvProducts;
    CartProductAdapter adapter;
    LinearLayout emptyView;
    RelativeLayout dataView;
    ImageButton btnClearCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_basket);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        rvProducts = findViewById(R.id.recycler_cart);
        dataView = findViewById(R.id.csrt_data_view);
        emptyView = findViewById(R.id.empty_cart_view);

        TextView tvTitle = findViewById(R.id.tv_title);
        tvTitle.setText("Shopping Basket");

        // Initializing the recycler basket
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        rvProducts.setLayoutManager(manager);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemRecyclerDecoration(getContext(), R.drawable.canvas_recycler_divider);
        rvProducts.addItemDecoration(itemDecoration);
        rvProducts.hasFixedSize();

        // Shopping Cart Product Adapter with data
        adapter = new CartProductAdapter(getContext(),getList(), new ClickListener() {
            @Override
            public void onPositionClicked(int position) {

            }

            @Override
            public void onDeleteClicked(int position) {
                checkEmptyBasket();
            }
        });
        rvProducts.setAdapter(adapter);
        checkEmptyBasket();

        btnClearCart = findViewById(R.id.btn_clear_cart);
        btnClearCart.setOnClickListener(v -> {
            adapter.emptyCart();
            checkEmptyBasket();
        });

        ImageButton backButton = findViewById(R.id.iv_back_btn);
        backButton.setOnClickListener(v -> finish());

        Button startShopping = findViewById(R.id.btn_start_shopping);
        startShopping.setOnClickListener(v -> {
            Intent intent = new Intent(ShoppingBasketActivity.this,HomeActivity.class);
            startActivity(intent);
            finishAffinity();
        });
    }

    private ArrayList<CartProducts> getList(){
        ArrayList<CartProducts> transactions = new ArrayList<>();
        transactions.add(new CartProducts("http://www.bigbazarathome.com/uploads/Product/7135Image.jpg","MB Royal","Basmati Mogra Royal Rice","5 kg","1200","1000",1));
        transactions.add(new CartProducts("https://images-na.ssl-images-amazon.com/images/I/71liFHlEdrL._SX466_.jpg","Colgate","Max Fresh Super Soothing Paste","150 gm","60","50",1));
        transactions.add(new CartProducts("","Rajdhani","Full Fined Sooji/Rawa","500 gm","600","520",3));
        transactions.add(new CartProducts("https://2.imimg.com/data2/EP/OL/MY-3394706/nescafe-250x250.jpg","Nestle","Coffee Filtered Beans","250 gm","500","420",2));
        return transactions;
    }

    public void checkEmptyBasket(){
        if(adapter.getItemCount()==0){
            btnClearCart.setVisibility(View.INVISIBLE);
            dataView.setVisibility(View.INVISIBLE);
            emptyView.setVisibility(View.VISIBLE);
        }
    }
}
