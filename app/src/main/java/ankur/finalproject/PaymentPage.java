package ankur.finalproject;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class PaymentPage extends AppCompatActivity {


    private EditText cardNumber;
    private EditText holdersName;
    private EditText expiryMonth;
    private EditText expiryYear;
    private Button FPay;
    private Button Back;
    private ImageView iv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_page);

        setContentView(R.layout.activity_payment_page);
        cardNumber = (EditText) findViewById(R.id.CardNumber);
        holdersName = (EditText) findViewById(R.id.HolderName);
        expiryMonth = (EditText) findViewById(R.id.expiryMonth);
        expiryYear = (EditText) findViewById(R.id.ExpiryYear);
        FPay = (Button) findViewById(R.id.FPay);
        Back = (Button) findViewById(R.id.GoBack);
        iv = (ImageView)findViewById(R.id.iv);

         Registerdata r1 =new Registerdata();
         String mob= r1.getMobNo();
        Back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent myIntent = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(myIntent);


            }
        });

        FPay.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                //String uu = LoginActivity.UID;
                //DatabaseHandler  db = new DatabaseHandler(PaymentPage.this, null, null, 2);
                //String no = db.getPhoneNoDB(uu);

                 String messageToSend = "Thank you for shopping. Your order will be delivered soon.";
                 String number = "6476710881";
                 SmsManager.getDefault().sendTextMessage(number, null, messageToSend, null,null);
                Toast.makeText(getApplicationContext(), "Your Payment is done", Toast.LENGTH_LONG).show();

                Intent myIntent = new Intent(getApplicationContext(),LoginActivity.class);
                 startActivity(myIntent);

            }
        });


    }
}
