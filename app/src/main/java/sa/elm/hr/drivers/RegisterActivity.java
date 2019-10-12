package sa.elm.hr.drivers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.InputType;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.regex.Pattern;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    String phone;
    EditText fname, email, lname, phoneE;
    ImageButton registerButton;
    Toolbar toolbar;
    String MobilePattern = "[0-9]{10}";
    String phoneToValidate;


    private final String LOG =RegisterActivity.class.getSimpleName();

    ImageView img_logo;
    protected static final int INTENT_CAMERA = 401;
    protected static final int INTENT_GALLERY = 301;
    protected static final int PERMISSION_REQUEST_CAMERA_GALLERY = 101;
    boolean isSelected = false;

    private File imageFile;

    String pin;

    char type;//todo

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getExtras();
//        toolbar = findViewById(R.id.toolbar);
//        toolbar.setTitle(getResources().getString(R.string.createAccount));
//        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setDisplayShowHomeEnabled(true);
        fname = (EditText) findViewById(R.id.fname_signup);
        email = (EditText) findViewById(R.id.email_signup);
        lname = (EditText) findViewById(R.id.lname_signup);
        phoneE = (EditText) findViewById(R.id.phone_signupN);
        phoneE.setText(phone);

        phoneE.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_PASSWORD);

        phoneE.setTransformationMethod(new NumericKeyBoardTransformationMethod());

//        img_logo= (ImageView) findViewById(R.id.personalImageSignup);
//        img_logo.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                startDialog();
//            }
//
//        });// end setOnClickListener1


        registerButton = findViewById(R.id.register_button);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (checkDataEntered()){
                    //String phone,String fname,String lname,char type,String email
//
//                            int min=1000;
//        int max=9999;
//
//        int random =(int)(Math.random()*max+min);


                    UsersData.addUser(new User(
                         phoneE.getText().toString(),
                         fname.getText().toString(),
                         lname.getText().toString(),
                            type,
                            email.getText().toString()



                    ));

                    pin= UsersData.getIdByPhone(phone);


                    executeSignUp();

            }

            }
        }); // end setOnClickListener2


    }// end onCreate

    private void executeSignUp() {

        MySharedPrefence.putBoolean(this, Constants.Keys.IS_LOGIN, true);
        MySharedPrefence.putString(this, Constants.Keys.USER_FNAME, fname.getText().toString());
        MySharedPrefence.putString(this, Constants.Keys.USER_LNAME, lname.getText().toString());
        //lname.getText().toString()
        MySharedPrefence.putString(this, Constants.Keys.USER_EMAIL, email.getText().toString());
        MySharedPrefence.putString(this, Constants.Keys.PHONE, phoneE.getText().toString());
        MySharedPrefence.putString(this, Constants.Keys.USER_PIN, pin);//todo change



        Intent intent = new Intent(this, HomeActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra(Constants.Keys.USER_PIN,pin);
        startActivity(intent);
        finish();


    } //end executeSignUp

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

        if (isEmpty(phoneE)) {

            phoneE.setError(getResources().getString(R.string.enterPhone));
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

        phoneToValidate="0"+phoneE.getText().toString().substring(4);

        if(phoneToValidate.matches(MobilePattern)==false) {
            phoneE.setError("Please enter valid 10 digit phone number");
            flag=false;
        }

        if(phoneE.getText().toString().equals("+966581466612")){
            phoneE.setError("This number has been used,Try another number.");
            flag=false;
        }

        return flag;
    }//end checkDataEntered


    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }//end isEmpty
//
//    boolean confirmPassword() {
//        String pass = password.getText().toString();
//        String cpass = cPassword.getText().toString();
//        return pass.equals(cpass);
//    } // end confirmPassword

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


    private void startDialog() {
        android.app.AlertDialog.Builder myAlertDialog = new AlertDialog.Builder(
                this);
        myAlertDialog.setTitle(getResources().getString(R.string.picOpt));
        myAlertDialog.setMessage(getResources().getString(R.string.picQ));

        myAlertDialog.setPositiveButton(getResources().getString(R.string.gallery),
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {

                        Intent pickPhoto = new Intent(Intent.ACTION_PICK,
                                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        startActivityForResult(pickPhoto , 1);

                    }
                });

        myAlertDialog.setNegativeButton(getResources().getString(R.string.camera),
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {

                        Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(takePicture, 0);//zero can be replaced with any action code

                    }
                });
        myAlertDialog.show();
    }// end startDialog


    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        if(imageReturnedIntent==null)
            return;
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);
        switch(requestCode) {
            case 0:
                if(resultCode == RESULT_OK){
                    Uri selectedImage = imageReturnedIntent.getData();
                    img_logo.setImageURI(selectedImage);
                }

                break;
            case 1:
                if(resultCode == RESULT_OK){
                    Uri selectedImage = imageReturnedIntent.getData();
                    img_logo.setImageURI(selectedImage);
                }
                break;
        }
    }// end onActivityResult

    private void getExtras() {
        Intent intent = getIntent();
        if (intent != null) {
            phone = intent.getStringExtra(Constants.Keys.PHONE);
        }// end if
    }
}
