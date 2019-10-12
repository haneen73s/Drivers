package sa.elm.hr.drivers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SignInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        EditText mEdit = (EditText) findViewById(R.id.editText);

        addUsers();

        mEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(SignInActivity.this, SignIn2Activity.class));



            }
        }); // end setOnClickListener2

    }

    private void addUsers(){
        //String phone,String fname,String lname,char type,String email
        User customer= new User(
                "+966581466612",
                "Atheer",
                "Alghannam",
                'c',
                "ath@elm.sa");

        customer.setPIN("1234");
                UsersData.addUser(customer);



//        UsersData.addUser(new User(
//                "+966581466621",
//                "Atheer",
//                "Alghannam",
//                'd',
//                "ath@elm.sa"
//
//                ) );



    }
}
