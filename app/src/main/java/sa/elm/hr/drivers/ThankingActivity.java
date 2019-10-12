package sa.elm.hr.drivers;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class ThankingActivity extends AppCompatActivity implements View.OnClickListener {
LinearLayout thank;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thanking);
        thank = findViewById(R.id.activity_thanking);  //Now we dont need casting anymore
        thank.setOnClickListener(this);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                startActivity(new Intent(ThankingActivity.this, MainActivity.class));
                finish();
            }
        }, 3000);


    }

    @Override
    public void onClick(View view) {
        startActivity(new Intent(ThankingActivity.this, MainActivity.class));
        finish();
    }
}
