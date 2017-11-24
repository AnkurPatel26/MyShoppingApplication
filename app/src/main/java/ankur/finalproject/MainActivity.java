package ankur.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button viewShoppingCart;
    private List<Product> mProductList;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Boolean guest_user = getIntent().getExtras().getBoolean("guest");

        // Obtain a reference to the product catalog
        mProductList = ShoppingCartHelper.getCatalog(getResources());
        viewShoppingCart = (Button) findViewById(R.id.ButtonViewCart);
        if(guest_user){
            ListView listViewCatalog = (ListView) findViewById(R.id.ListViewCatalog);
            listViewCatalog.setAdapter(new ProductAdapter(mProductList, getLayoutInflater(), false));
            viewShoppingCart.setVisibility(View.GONE);
            listViewCatalog.setEnabled(false);

        }
        else {
            // Create the list
            ListView listViewCatalog = (ListView) findViewById(R.id.ListViewCatalog);
            listViewCatalog.setAdapter(new ProductAdapter(mProductList, getLayoutInflater(), false));

            listViewCatalog.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position,
                                        long id) {
                    Intent productDetailsIntent = new Intent(getBaseContext(), ProductDetailsActivity.class);
                    productDetailsIntent.putExtra(ShoppingCartHelper.PRODUCT_INDEX, position);
                    startActivity(productDetailsIntent);
                }
            });


            viewShoppingCart.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Intent viewShoppingCartIntent = new Intent(getBaseContext(), ShoppingCartActivity.class);
                    startActivity(viewShoppingCartIntent);
                }
            });
        }
    }
}