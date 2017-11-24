package ankur.finalproject;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText user, pass;
    Button login, not_reg,guest;
    DatabaseHandler db;
    Cursor cursor;
    public static String UID ="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        guest  =(Button) findViewById(R.id.guestUser);
        user = (EditText) findViewById(R.id.eduser);
        pass = (EditText) findViewById(R.id.edpass);
        login = (Button) findViewById(R.id.login);
        not_reg = (Button) findViewById(R.id.not_reg);

        login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                db = new DatabaseHandler(LoginActivity.this, null, null, 2);
                String username = user.getText().toString();
                String password = pass.getText().toString();
                UID=username;
                String StoredPassword = db.getregister(username);
                if (password.equals(StoredPassword)) {

                    Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
                    myIntent.putExtra("guest", false);
                    startActivity(myIntent);
                    LoginActivity.this.finish();
                    Toast.makeText(getApplicationContext(), "Login Successfully", Toast.LENGTH_LONG).show();

                } else {
                    Toast.makeText(getApplicationContext(), "Username/Password incorrect", Toast.LENGTH_LONG).show();
                    user.setText("");
                    pass.setText("");
                }


            }
        });

        guest.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
                myIntent.putExtra("guest", true);
                startActivity(myIntent);
            }
        });

        not_reg.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                startActivity(new Intent(getApplicationContext(), SignUpActivity.class));
            }
        });



    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Take appropriate action for each action item click

        return false;

    }
}