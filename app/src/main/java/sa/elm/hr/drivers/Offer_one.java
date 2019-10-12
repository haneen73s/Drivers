package sa.elm.hr.drivers;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Offer_one extends AppCompatActivity {
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.offer_one);
        //set Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        setTitle(R.string.Offers);

        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setSubtitleTextColor(Color.WHITE);
        super.onCreate(savedInstanceState);


    }

    public boolean onSupportNavigateUp(){

        onBackPressed();
        return true;

    }
}
