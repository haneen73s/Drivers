package sa.elm.hr.drivers;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;



public class SplashActivity extends AppCompatActivity implements View.OnClickListener {
    LinearLayout splashLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Refer the ImageView like this
        ImageView imageView = (ImageView) findViewById(R.id.imageView);

// Load the animation like this
        Animation  animSlide = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide);

// Start the animation like this
        imageView.startAnimation(animSlide);


        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {

                checkIsLogin();
            }
        }, 3000); // end timer
        splashLayout = (LinearLayout) findViewById(R.id.splashlayout);
        splashLayout.setOnClickListener(this);
      //  if(!MySharedPrefence.getBoolean(this,Constants.Keys.IS_FILL_DATA,false))
          //  fillDatabase();//end if
    }//end onCreate

    @Override
    public void onClick(View view) {

        checkIsLogin();
        //finish();

    }//end onClick

    private void checkIsLogin() {

        //todo here move to menu drawer
        if (MySharedPrefence.getBoolean(this, Constants.Keys.IS_LOGIN, false)) {
            startActivity(new Intent(this, MainActivity.class));
            finish();}// end if
        else {
            startActivity(new Intent(this, SignInActivity.class));
            finish();
        }//end else

    }//end checkIsLogin

//   private void fillDatabase(){
//   }


}
