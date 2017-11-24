package ankur.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class ShoppingCartActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnCheckout;
    private List<Product> mCartList;
    private ProductAdapter mProductAdapter;
 public Double total =ProductDetailsActivity.tt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);

        mCartList = ShoppingCartHelper.getCart();

        // Make sure to clear the selections
        for(int i=0; i<mCartList.size(); i++) {
            mCartList.get(i).selected = false;

        }
        btnCheckout = (Button) findViewById(R.id.Button02);
        btnCheckout.setOnClickListener(this);

        // Create the list
        final ListView listViewCatalog = (ListView) findViewById(R.id.ListViewCatalog);
        mProductAdapter = new ProductAdapter(mCartList, getLayoutInflater(), true);
        listViewCatalog.setAdapter(mProductAdapter);

        listViewCatalog.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {

                Product selectedProduct = mCartList.get(position);
                if(selectedProduct.selected == true)
                    selectedProduct.selected = false;
                else
                    selectedProduct.selected = true;

                mProductAdapter.notifyDataSetInvalidated();

            }
        });

        Button removeButton = (Button) findViewById(R.id.ButtonRemoveFromCart);
        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Loop through and remove all the products that are selected
                // Loop backwards so that the remove works correctly
                for(int i=mCartList.size()-1; i>=0; i--) {

                    if(mCartList.get(i).selected) {
                        mCartList.remove(i);
                    }
                }
                mProductAdapter.notifyDataSetChanged();
            }
        });

    }

    @Override
    public void onClick(View view) {

        if(view == btnCheckout ){

            //total= (int) (total+(ProductDetailsActivity.P * Integer.parseInt(ProductDetailsActivity.Q)));
            Toast.makeText(getApplicationContext(), "Amount="+total+"", Toast.LENGTH_LONG).show();

            // String messageToSend = "Thank you for shopping. Your order will be delivered soon.";
            //String number = "6476710881";
            //SmsManager.getDefault().sendTextMessage(number, null, messageToSend, null,null);

            Intent myIntent = new Intent(getApplicationContext(), MapsActivity.class);
            /*myIntent.putExtra("guest", false);*/
            startActivity(myIntent);

            /*Intent intent = new Intent(Intent.ACTION_SEND);

            intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"dhruv.patel166@gmail.com"});
            intent.putExtra(Intent.EXTRA_SUBJECT, "Confirmation");
            intent.putExtra(Intent.EXTRA_TEXT, "Your order is confirmed.");

            intent.setType("message/rfc822");

            startActivity(Intent.createChooser(intent, "Select Email Sending App :"));*/

        }

    }
}