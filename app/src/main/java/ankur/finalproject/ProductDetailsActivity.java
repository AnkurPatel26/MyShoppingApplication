package ankur.finalproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class ProductDetailsActivity extends AppCompatActivity {

    public static Double P = 0.0;
    public static int Q =0;
    public static Double tt = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);


        List<Product> catalog = ShoppingCartHelper.getCatalog(getResources());
        final List<Product> cart = ShoppingCartHelper.getCart();

        int productIndex = getIntent().getExtras().getInt(ShoppingCartHelper.PRODUCT_INDEX);
        final Product selectedProduct = catalog.get(productIndex);

        // Set the proper image and text
        ImageView productImageView = (ImageView) findViewById(R.id.ImageViewProduct);
        productImageView.setImageDrawable(selectedProduct.productImage);
        TextView productTitleTextView = (TextView) findViewById(R.id.TextViewProductTitle);
        productTitleTextView.setText(selectedProduct.title);
        TextView productPriceTextView = (TextView) findViewById(R.id.TextViewProductPrice);
        productPriceTextView.setText(selectedProduct.price+"");
        P = (Double) selectedProduct.price;
        TextView productDetailsTextView = (TextView) findViewById(R.id.TextViewProductDetails);
        productDetailsTextView.setText(selectedProduct.description);
        EditText editTextQuantity = (EditText)findViewById(R.id.editTextQuantity);
        Q = Integer.parseInt(editTextQuantity.getText().toString());

        tt= Q * P;
        Button addToCartButton = (Button) findViewById(R.id.ButtonAddToCart);
        addToCartButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                cart.add(selectedProduct);
                finish();
            }
        });

        // Disable the add to cart button if the item is already in the cart
        if(cart.contains(selectedProduct)) {
            addToCartButton.setEnabled(false);
            addToCartButton.setText("Item in Cart");
        }

    }
}