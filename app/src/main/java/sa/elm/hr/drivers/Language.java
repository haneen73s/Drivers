package sa.elm.hr.drivers;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;

public class Language extends AppCompatActivity {


    CheckedTextView arabic, english;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lanuage);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        setTitle("Language");


        arabic = findViewById(R.id.lang1);
        english = findViewById(R.id.lang2);


        arabic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arabic.toggle();
                if (arabic.isChecked()) {
                    arabic.setCheckMarkDrawable(R.drawable.ic_check_24dp);
                    english.setCheckMarkDrawable(null);
                    setLanquage("ar");
                }
            }
        });

        english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                english.toggle();
                if (english.isChecked()) {
                    english.setCheckMarkDrawable(R.drawable.ic_check_24dp);
                    arabic.setCheckMarkDrawable(null);
                    setLanquage("en");
                }
            }
        });
    }

    private void setLanquage(String lanquage) {
        MySharedPrefence.putString(this, "APP_LANGUAGE", "language");
        Intent intent = new Intent(this, SplashActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }
    @Override
    public boolean onSupportNavigateUp(){

        onBackPressed();
        return true;

    }

}
