package sa.elm.hr.drivers;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

import java.util.regex.Pattern;

public class PersonalInfo extends AppCompatActivity {
    private TextView txtName ;

    EditText fname, lname, email, phone;
    Button save;
    boolean flagPhone;
char type;
    String MobilePattern = "[0-9]{10}";
    String phoneToValidate;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.personalinfo);
        //set Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);



        super.onCreate(savedInstanceState);
        fname = findViewById(R.id.fname_pro);
        //fname.setEnabled(false);
        lname = findViewById(R.id.lname_pro);
        //lname.setEnabled(false);
        email = findViewById(R.id.email_pro);
        // email.setEnabled(false);
        phone = findViewById(R.id.phone_pro);
        phone.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_PASSWORD);

        phone.setTransformationMethod(new NumericKeyBoardTransformationMethod());
        //phone.setEnabled(false);


        save = findViewById(R.id.save_button);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (checkDataEntered()) {
                    UsersData.addUser(new User(
                            phone.getText().toString(),
                            fname.getText().toString(),
                            lname.getText().toString(),
                            type,
                            email.getText().toString()
                    ));




                    executeSave();

                }

            }
        }); // end setOnClickListener2

        if (!MySharedPrefence.getString(this, Constants.Keys.USER_FNAME, "").

                equals("")) {
            fname.setText(MySharedPrefence.getString(this, Constants.Keys.USER_FNAME, ""));
        }//end if
        if (!MySharedPrefence.getString(this, Constants.Keys.USER_LNAME, "").

                equals("")) {
            lname.setText(MySharedPrefence.getString(this, Constants.Keys.USER_LNAME, ""));
        }//end if


        if (!MySharedPrefence.getString(this, Constants.Keys.USER_EMAIL, "").

                equals("")) {
            email.setText(MySharedPrefence.getString(this, Constants.Keys.USER_EMAIL, ""));
        }//end if
        if (!MySharedPrefence.getString(this, Constants.Keys.PHONE, "").

                equals("")) {
            phone.setText(MySharedPrefence.getString(this, Constants.Keys.PHONE, ""));
        }//end if

        flagPhone=phone.getText().toString().equals("+966581466612");


    }//end onCreate

    private void executeSave() {

        MySharedPrefence.putString(this, Constants.Keys.USER_FNAME, fname.getText().toString());
        MySharedPrefence.putString(this, Constants.Keys.USER_LNAME, lname.getText().toString());
        //lname.getText().toString()
        MySharedPrefence.putString(this, Constants.Keys.USER_EMAIL, email.getText().toString());
        MySharedPrefence.putString(this, Constants.Keys.PHONE, phone.getText().toString());
//        NavigationView navigationView = findViewById(R.id.nav_view);
//        txtName = navigationView.getHeaderView(0).findViewById(R.id.navName);
////
////

//        if (!MySharedPrefence.getString(this, Constants.Keys.USER_FNAME, "").equals("")&&!MySharedPrefence.getString(this, Constants.Keys.USER_LNAME, "").equals("")) {
//            txtName.setText(MySharedPrefence.getString(this,Constants.Keys.USER_FNAME, "")+" "+MySharedPrefence.getString(this,Constants.Keys.USER_LNAME, ""));
//        }//end if

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Your changes saved successfully !")
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        startActivity(new Intent(PersonalInfo.this,SplashActivity.class));
                        //do things
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();




    }


    @Override
    public boolean onSupportNavigateUp() {

        onBackPressed();
        return true;

    }

    public boolean checkDataEntered() {
        boolean flag = true;
        if (isEmpty(fname)) {

            fname.setError(getResources().getString(R.string.enterfName));
            flag = false;
        }//end if
        if (isEmpty(lname)) {

            lname.setError(getResources().getString(R.string.enterlName));
            flag = false;
        }//end if
        if (isEmpty(email)) {

            email.setError(getResources().getString(R.string.enterEmail));
            flag = false;
        }//end if

        if (isEmpty(phone)) {

            phone.setError(getResources().getString(R.string.enterPhone));
            flag = false;
        }//end if

        if (isEmail(email.getText().toString()) == false) {
            email.setError(getResources().getString(R.string.enterVEmail));
            flag = false;
        }//end if
//        if (confirmPassword() == false) {
//            password.setError(getResources().getString(R.string.mismatch));
//            cPassword.setError(getResources().getString(R.string.mismatch));
//            flag = false;
//        }//end if
        phoneToValidate="0"+phone.getText().toString().substring(4);

        if(phoneToValidate.matches(MobilePattern)==false) {
            phone.setError("Please enter valid 10 digit phone number");
            flag=false;
        }

        if(phone.getText().toString().equals("+966581466612")){
            if(!flagPhone){
            phone.setError("This number has been used,Try another number.");
            flag=false;
        }}

        return flag;
    }//end checkDataEntered

    private boolean isEmail(String email) {
        //check email is belong elm.sa
        //  if (isElmEmail(email))
        //check isEmail
        return Pattern.compile("^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$").matcher(email).matches();
        //else return false;
    }//end isEmail()
    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }//end isEmpty
}