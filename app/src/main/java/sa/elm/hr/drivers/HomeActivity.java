package sa.elm.hr.drivers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    String pin;
    TextView pin_signup;
    ImageButton register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getExtras();

        pin_signup = findViewById(R.id.pin_signup);
        pin_signup.setText(pin);

        register=findViewById(R.id.continueButtonPIN);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,MainActivity.class));
            }
        });



    }

    private void getExtras() {
        Intent intent = getIntent();
        if (intent != null) {
            pin = intent.getStringExtra(Constants.Keys.USER_PIN);
        }// end if
    }
}
