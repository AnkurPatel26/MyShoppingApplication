package ankur.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ConfirmationActivity extends AppCompatActivity {
 private Button pay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);

        pay = (Button) findViewById(R.id.finalPay);

        String store_location = getIntent().getExtras().getString("location");
        TextView tvLocation = (TextView) findViewById(R.id.Location);
        tvLocation.setText(store_location);

        pay.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent myIntent = new Intent(getApplicationContext(),PaymentPage.class);
                startActivity(myIntent);


            }
        });
    }
}
