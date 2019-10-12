package sa.elm.hr.drivers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class SignIn2Activity extends AppCompatActivity {

    String MobilePattern = "[0-9]{10}";
    String phone;
    ImageButton continueButton;
    EditText phoneEdittext;
    String phoneToValidate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in2);

        phoneEdittext = (EditText)findViewById(R.id.edittext_phone);


        phoneEdittext.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_PASSWORD);

        phoneEdittext.setTransformationMethod(new NumericKeyBoardTransformationMethod());
        phoneEdittext.setSelection(phoneEdittext.getText().length());


        continueButton=findViewById(R.id.continueButton);

        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               phone=phoneEdittext.getText().toString();

                phoneToValidate="0"+phone.substring(4);


if(phoneToValidate.matches(MobilePattern)) {

    if (UsersData.isRegistered(phone)) {

        //todo replace with home activity

        Intent intent = new Intent(SignIn2Activity.this, SignIn3Activity.class);
        String foundId = UsersData.getIdByPhone(phone);
        intent.putExtra(Constants.Keys.USER_PIN, foundId);
//                   intent.putExtra(Constants.Keys.USER,""+UsersData.getUser(foundId));

        startActivity(intent);

    } else {


        Intent intent = new Intent(SignIn2Activity.this, RegisterActivity.class);
        intent.putExtra(Constants.Keys.PHONE, phone);


        startActivity(intent);

    }
}else if(!phoneToValidate.matches(MobilePattern)) {
//
//        //todo string
//
      phoneEdittext.setError("Please enter valid 10 digit phone number");
              }




               }



        }); // end setOnClickListener2



    }
}
 class NumericKeyBoardTransformationMethod extends PasswordTransformationMethod {
    @Override
    public CharSequence getTransformation(CharSequence source, View view) {
        return source;
    }
}
