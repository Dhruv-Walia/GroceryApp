package in.vibescom.groceryapp.UI.Activities;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import in.vibescom.groceryapp.R;

public class ProductDetailActivity extends AppCompatActivity {

    TextView tvCutPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView tvTitle = findViewById(R.id.tv_title);
        tvTitle.setText("Product Details");

        ImageButton backButton = findViewById(R.id.iv_back_btn);
        backButton.setOnClickListener(v -> finish());

        tvCutPrice = findViewById(R.id.tv_cut_price);
        tvCutPrice.setPaintFlags(tvCutPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        ImageButton btnCart = findViewById(R.id.btn_cart);
        btnCart.setOnClickListener(v -> {
            Intent intent = new Intent(ProductDetailActivity.this,ShoppingBasketActivity.class);
            startActivity(intent);
        });
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
