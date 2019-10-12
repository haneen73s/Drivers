package sa.elm.hr.drivers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class SignIn3Activity extends AppCompatActivity {

    ImageButton continueButton;
    String id;
    EditText pin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in3);

        continueButton=findViewById(R.id.continueButtonPIN);

        pin=findViewById(R.id.pin_login);

        getExtras();


        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {





                if(UsersData.getUser(id).getId().equals(pin.getText().toString()))
                   // startActivity(new Intent(SignIn3Activity.this, HomeActivity.class));
                    //todo move to menu drawer activity
                    {
//                  Intent intent = new Intent(SignIn3Activity.this, MainActivity.class);
//                        startActivity(intent);

                        executeLogin();
                    }

                else
                    pin.setError(getResources().getString(R.string.error_pin));





//                phone=phoneEdittext.getText().toString();
//
//
//
//
//                if(UsersData.isRegistered(phone)) {
//
//                    //todo replace with home activity
//
//                    Intent intent = new Intent(SignIn2Activity.this, SignIn3Activity.class);
//                    int foundId=UsersData.getIdByPhone(phone);
//                    intent.putExtra(Constants.Keys.ID,foundId);
////                   intent.putExtra(Constants.Keys.USER,""+UsersData.getUser(foundId));
//
//                    startActivity(intent);
//
//                }
//
//                else {
//
//
//
//                    Intent intent = new Intent(SignIn2Activity.this, RegisterActivity.class);
//                    intent.putExtra(Constants.Keys.PHONE,phone);
//
//
//                    startActivity(intent);
//
//                }

            }//end onClick
        }); // end setOnClickListener2
    }

    private void getExtras() {
        Intent intent = getIntent();
        if (intent != null) {
             id = intent.getStringExtra(Constants.Keys.USER_PIN);
        }// end if
}

    private void executeLogin() {

        User user = UsersData.getUser(id);
        MySharedPrefence.putBoolean(this, Constants.Keys.IS_LOGIN, true);
        MySharedPrefence.putString(this, Constants.Keys.USER_FNAME, user.getFname());
        MySharedPrefence.putString(this, Constants.Keys.USER_LNAME, user.getLname());
        //lname.getText().toString()
        MySharedPrefence.putString(this, Constants.Keys.USER_EMAIL, user.getEmail());
        MySharedPrefence.putString(this, Constants.Keys.PHONE, user.getPhone());
        MySharedPrefence.putString(this, Constants.Keys.USER_PIN, id);//todo change



        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra(Constants.Keys.USER_PIN,id);
        startActivity(intent);
        finish();


    } //end executeSignUp


}
